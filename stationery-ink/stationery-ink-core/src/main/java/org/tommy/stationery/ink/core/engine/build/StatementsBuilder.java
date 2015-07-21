package org.tommy.stationery.ink.core.engine.build;

import com.google.common.base.Preconditions;
import net.hydromatic.linq4j.Linq4j;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.bus.AdvancedEventBus;
import org.tommy.stationery.ink.core.bus.event.BuilderStatementEvent;
import org.tommy.stationery.ink.core.bus.event.ValidateEvent;
import org.tommy.stationery.ink.core.bus.subscriber.BuilderStatementEventHandler;
import org.tommy.stationery.ink.core.bus.subscriber.ValidateEventHandler;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.core.engine.build.filter.SimpleStatementFilterFactory;
import org.tommy.stationery.ink.core.engine.storm.build.executor.SimpleDMLStatementExecutorImp;
import org.tommy.stationery.ink.core.engine.storm.build.executor.SimpleSETTINGStatementExecutorImp;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
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
 * Created by kun7788 on 15. 6. 30..
 */
public class StatementsBuilder implements IStatementBuilder {
    protected AdvancedEventBus eventBus;
    protected ConfigProperties configProperties;
    protected SimpleMetaStoreProviderImp simpleMetaStoreProvider;
    protected NavigableMap<StatementTypeEnum.GroupTypeEnum, ISimpleBuilder> simpleStatementBuilders = new TreeMap<StatementTypeEnum.GroupTypeEnum, ISimpleBuilder>();
    protected Auth auth;

    public void registerEventHandlersFromEventBus() {
        eventBus = new AdvancedEventBus();

        //regist event handler to building by statement.
        ValidateEventHandler validateEventHandler = new ValidateEventHandler();
        eventBus.register(validateEventHandler);

        BuilderStatementEventHandler builderStatementEventHandler = new BuilderStatementEventHandler();
        eventBus.register(builderStatementEventHandler);
    }


    public InkConfig mergedInkConfig(ISimpleBuilder builder) throws InkException {
        return configProperties.mergeInkConfig(configProperties.getDefaultInkConfig(), ((SimpleSETTINGStatementExecutorImp) builder.build()).getCustomInkConfig());
    }

    public void registSQLOnMetastore(InkConfig inkConfig, String sql) throws Exception {
        if (inkConfig.getBoolean(SettingEnum.REGIST_JOB) == true && inkConfig.getString(SettingEnum.JOB_NAME) != null) {
            simpleMetaStoreProvider.doRegistJobAction(inkConfig, sql);
        }
    }

    public void clearSnapshotWastedData(InkConfig inkConfig) {
        try {
            DumpUtil dumpUtil = new DumpUtil();
            dumpUtil.clear(inkConfig.getString(SettingEnum.JOB_NAME), inkConfig.getString(SettingEnum.DUMP_CLEAR_API_URL));
        } catch (Exception ex) {
        }
    }

    public void onBuild(List<BaseStatement> statements, String sql, InkConfig inkConfig, List<StatementTypeEnum.GroupTypeEnum> groups)  throws Exception {
        for (StatementTypeEnum.GroupTypeEnum statementGroupTypeEnum : groups/*StatementTypeEnum.GroupTypeEnum.GroupTypeList()*/) {
            List<BaseStatement> filteredStatements = Linq4j.asEnumerable(statements).where(SimpleStatementFilterFactory.getInstance(statementGroupTypeEnum)).toList();

            ISimpleBuilder builder = org.tommy.stationery.ink.core.engine.build.executor.SimpleStatementBuilderFactory.getInstance(statementGroupTypeEnum, inkConfig, simpleMetaStoreProvider);
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
    }

    public void build(List<BaseStatement> statements, String sql) throws Exception {
        //setting config and statements.
        Preconditions.checkNotNull(statements, MessageEnum.EMPTY_STATEMENTS);

        //build process.
        //'SET' PROCESS
        List<StatementTypeEnum.GroupTypeEnum> groups = new ArrayList<StatementTypeEnum.GroupTypeEnum>();
        groups.add(StatementTypeEnum.GroupTypeEnum.SET);
        onBuild(statements, sql, configProperties.getDefaultInkConfig(), groups);

        //merged InkConfig
        InkConfig inkConfig = mergedInkConfig(simpleStatementBuilders.get(StatementTypeEnum.GroupTypeEnum.SET));

        //'without 'SET' PROCESS
        groups = new ArrayList<StatementTypeEnum.GroupTypeEnum>();
        groups.add(StatementTypeEnum.GroupTypeEnum.USE);
        groups.add(StatementTypeEnum.GroupTypeEnum.DDL);
        groups.add(StatementTypeEnum.GroupTypeEnum.DML);
        onBuild(statements, sql, inkConfig, groups);

        //storm topology run launch.
        SimpleDMLStatementExecutorImp simpleDMLStatementExecutorImp = (SimpleDMLStatementExecutorImp)simpleStatementBuilders.get(StatementTypeEnum.GroupTypeEnum.DML).build();
        if (simpleDMLStatementExecutorImp.isRunable(inkConfig)) {
            //snapshot data clear
            clearSnapshotWastedData(inkConfig);

            //deploy
            deploy(inkConfig, ((SimpleDMLStatementExecutorImp) simpleDMLStatementExecutorImp).getStormTopologyBuilder().build());

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

    @Override
    public void deploy(InkConfig inkConfig, Object topology) throws Exception {

    }
}
