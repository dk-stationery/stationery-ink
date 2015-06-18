package org.tommy.stationery.ink.core.storm.build;

import com.google.common.base.Preconditions;
import net.hydromatic.linq4j.Linq4j;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.bus.AdvancedEventBus;
import org.tommy.stationery.ink.core.bus.event.BuilderStatementEvent;
import org.tommy.stationery.ink.core.bus.event.ValidateEvent;
import org.tommy.stationery.ink.core.bus.subscriber.BuilderStatementEventHandler;
import org.tommy.stationery.ink.core.bus.subscriber.ValidateEventHandler;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.core.storm.build.executor.ISimpleBuilder;
import org.tommy.stationery.ink.core.storm.build.executor.SimpleDMLStatementExecutorImp;
import org.tommy.stationery.ink.core.storm.build.executor.SimpleSETTINGStatementExecutorImp;
import org.tommy.stationery.ink.core.storm.build.executor.SimpleStatementBuilderFactory;
import org.tommy.stationery.ink.core.storm.build.filter.SimpleStatementFilterFactory;
import org.tommy.stationery.ink.core.util.StormManager;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.domain.meta.Auth;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.exception.InkException;
import org.tommy.stationery.ink.util.DumpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by kun7788 on 15. 6. 16..
 */
public class AdvancedStatementsBuilder {

    private AdvancedEventBus eventBus;
    private ConfigProperties configProperties;
    private SimpleMetaStoreProviderImp simpleMetaStoreProvider;
    private NavigableMap<StatementTypeEnum.GroupTypeEnum, ISimpleBuilder> simpleStatementBuilders = new TreeMap<StatementTypeEnum.GroupTypeEnum, ISimpleBuilder>();
    private Auth auth;

    private void registerEventHandlersFromEventBus() {
        eventBus = new AdvancedEventBus();

        //regist event handler to building by statement.
        ValidateEventHandler validateEventHandler = new ValidateEventHandler();
        eventBus.register(validateEventHandler);

        BuilderStatementEventHandler builderStatementEventHandler = new BuilderStatementEventHandler();
        eventBus.register(builderStatementEventHandler);
    }

    private InkConfig mergedInkConfig(ISimpleBuilder builder) throws InkException {
        return configProperties.mergeInkConfig(configProperties.getDefaultInkConfig(), ((SimpleSETTINGStatementExecutorImp) builder.build()).getCustomInkConfig());
    }

    private void registSQLOnMetastore(InkConfig inkConfig, String sql) throws Exception {
        if (inkConfig.getBoolean(SettingEnum.REGIST_JOB) == true && inkConfig.getString(SettingEnum.JOB_NAME) != null) {
            simpleMetaStoreProvider.doRegistJobAction(inkConfig, sql);
        }
    }

    private void clearSnapshotWastedData(InkConfig inkConfig) {
        try {
            DumpUtil dumpUtil = new DumpUtil();
            dumpUtil.clear(inkConfig.getString(SettingEnum.JOB_NAME), inkConfig.getString(SettingEnum.DUMP_CLEAR_API_URL));
        } catch (Exception ex) {
        }
    }

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

    public void init(ConfigProperties configProperties,SimpleMetaStoreProviderImp simpleMetaStoreProvider, Auth auth) {
        Preconditions.checkNotNull(configProperties, MessageEnum.EMPTY_CONFIGURE);
        this.configProperties = configProperties;
        this.simpleMetaStoreProvider = simpleMetaStoreProvider;

        Preconditions.checkNotNull(auth, MessageEnum.INVALID_AUTH_INFO);
        this.auth = auth;

        //registing event handler.(eventbus)
        registerEventHandlersFromEventBus();
    }

    public List<ResultStatement> getResultStatements() {
        List<ResultStatement> resultStatements = new ArrayList<ResultStatement>();
        for (ISimpleBuilder simpleBuilder : simpleStatementBuilders.values()) {
            if (simpleBuilder != null) {
                resultStatements.addAll(simpleBuilder.build().getResultStatement());
            }
        }
        return resultStatements;
    }

    public String toAST() {
        StringBuilder astSb = new StringBuilder();
        for (ISimpleBuilder simpleBuilder : simpleStatementBuilders.values()) {
            astSb.append(simpleBuilder.build().toAST());
        }
        return astSb.toString();
    }
}
