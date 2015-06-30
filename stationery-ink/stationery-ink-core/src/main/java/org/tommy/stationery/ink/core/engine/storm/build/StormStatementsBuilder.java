package org.tommy.stationery.ink.core.engine.storm.build;

import com.google.common.base.Preconditions;
import net.hydromatic.linq4j.Linq4j;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.bus.event.BuilderStatementEvent;
import org.tommy.stationery.ink.core.bus.event.ValidateEvent;
import org.tommy.stationery.ink.core.engine.build.ISimpleBuilder;
import org.tommy.stationery.ink.core.engine.build.StatementsBuilder;
import org.tommy.stationery.ink.core.engine.build.executor.SimpleStatementBuilderFactory;
import org.tommy.stationery.ink.core.engine.build.filter.SimpleStatementFilterFactory;
import org.tommy.stationery.ink.core.engine.storm.build.executor.SimpleDMLStatementExecutorImp;
import org.tommy.stationery.ink.core.util.StormManager;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.util.List;

/**
 * Created by kun7788 on 15. 6. 16..
 */
public class StormStatementsBuilder extends StatementsBuilder {

    public void build(List<BaseStatement> statements, String sql) throws Exception {
        //setting config and statements.
        Preconditions.checkNotNull(statements, MessageEnum.EMPTY_STATEMENTS);

        //build process.
        for (StatementTypeEnum.GroupTypeEnum statementGroupTypeEnum : StatementTypeEnum.GroupTypeEnum.GroupTypeList()) {
            List<BaseStatement> filteredStatements = Linq4j.asEnumerable(statements).where(SimpleStatementFilterFactory.getInstance(statementGroupTypeEnum)).toList();

            ISimpleBuilder builder = SimpleStatementBuilderFactory.getInstance(statementGroupTypeEnum, configProperties.getDefaultInkConfig(), simpleMetaStoreProvider);
            int indexCnt = 0;
            for (BaseStatement statement : filteredStatements) {
                indexCnt++;

                //validate
                ValidateEvent validateEvent = new ValidateEvent(auth, statementGroupTypeEnum, statement, simpleMetaStoreProvider);
                validateEvent = (ValidateEvent)eventBus.fireEvent(validateEvent);
                if (!validateEvent.isValidate()) {
                    throw new InkException(MessageEnum.META_VALIDATION_ERROR);
                }

                //build.
                BuilderStatementEvent builderStatementEvent = new BuilderStatementEvent(statement, builder, ((filteredStatements.size() == indexCnt) ? true : false));
                builderStatementEvent = (BuilderStatementEvent)eventBus.fireEvent(builderStatementEvent);
                builder = builderStatementEvent.getProcessedBuilder();
            }

            simpleStatementBuilders.put(statementGroupTypeEnum, builder);
        }

        //merged InkConfig
        InkConfig inkConfig = mergedInkConfig(simpleStatementBuilders.get(StatementTypeEnum.GroupTypeEnum.SET));

        //storm topology run launch.
        SimpleDMLStatementExecutorImp simpleDMLStatementExecutorImp = (SimpleDMLStatementExecutorImp)simpleStatementBuilders.get(StatementTypeEnum.GroupTypeEnum.DML).build();
        if (simpleDMLStatementExecutorImp.isRunable(inkConfig)) {
            //snapshot data clear
            clearSnapshotWastedData(inkConfig);

            //storm depoly
            StormManager.depoly(inkConfig, ((SimpleDMLStatementExecutorImp) simpleDMLStatementExecutorImp).getStormTopologyBuilder().build());

            //store sql query on metastore.
            registSQLOnMetastore(inkConfig, sql);
        }
    }
}
