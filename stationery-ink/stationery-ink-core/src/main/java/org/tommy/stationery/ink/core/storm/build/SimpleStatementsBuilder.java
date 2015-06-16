package org.tommy.stationery.ink.core.storm.build;

import net.hydromatic.linq4j.Linq4j;
import net.hydromatic.linq4j.function.Predicate1;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.core.linq.LinqQuery;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.core.storm.build.executor.*;
import org.tommy.stationery.ink.core.storm.build.validator.ISimpleStatementMetaValidator;
import org.tommy.stationery.ink.core.util.StormManager;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.exception.InkException;
import org.tommy.stationery.ink.util.DumpUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 27..
 */
public class SimpleStatementsBuilder implements ISimpleStatementsBuilder {
    private InkConfig inkConfig;
    private List<BaseStatement> statements;
    private List<ResultStatement> resultStatements = new ArrayList<ResultStatement>();
    private SimpleMetaStoreProviderImp simpleMetaStoreProvider;
    private ISimpleStatementMetaValidator settingValidator;
    private ISimpleStatementMetaValidator ddlValidator;
    private ISimpleStatementMetaValidator dmlValidator;
    private ISimpleStatementMetaValidator useValidator;
    private List<ISimpleStatementExecutor> simpleStatementExecutors = new ArrayList<ISimpleStatementExecutor>();
    private ConfigProperties configProperties;

    public SimpleStatementsBuilder(List<BaseStatement> statements) {
        this.statements = statements;
    }

    public ISimpleBuilder doBuild(ISimpleBuilder builder, ISimpleStatementMetaValidator validator, Predicate1<BaseStatement> filter) throws Exception {
        List<BaseStatement> filteredStatements = Linq4j.asEnumerable(statements).where(filter).toList();

        boolean isLast = false;
        int indexCnt = 0;
        for (BaseStatement statement : filteredStatements) {
            indexCnt++;
            //validate
            if (validator.isValidate(statement) == false) {
                throw new InkException(MessageEnum.META_VALIDATION_ERROR);
            }

            if (filteredStatements.size() == indexCnt) {
                isLast = true;
            }
            builder = (ISimpleBuilder) builder.execute(statement, isLast);
        }
        return builder;
    }

    @Override
    public ISimpleBuilder useBuild(InkConfig inkConfig) throws Exception {

        //build processing.
        SimpleUSEStatementExecutorImp.Builder settingBuilder = new SimpleUSEStatementExecutorImp.Builder();
        settingBuilder = (SimpleUSEStatementExecutorImp.Builder) doBuild(settingBuilder, useValidator, LinqQuery.USE_STATEMENT_GROUP_FILTER);
        return settingBuilder;
    }

    @Override
    public ISimpleBuilder settingBuild(InkConfig inkConfig) throws Exception {

        //build processing.
        SimpleSETTINGStatementExecutorImp.Builder settingBuilder = new SimpleSETTINGStatementExecutorImp.Builder();
        settingBuilder = (SimpleSETTINGStatementExecutorImp.Builder) doBuild(settingBuilder, settingValidator, LinqQuery.SETTING_STATEMENT_GROUP_FILTER);
        return settingBuilder;
    }

    @Override
    public ISimpleBuilder ddlBuild(InkConfig inkConfig) throws Exception {

        //build processing.
        SimpleDDLStatementExecutorImp.Builder ddlBuilder = new SimpleDDLStatementExecutorImp.Builder(inkConfig, simpleMetaStoreProvider);
        ddlBuilder = (SimpleDDLStatementExecutorImp.Builder) doBuild(ddlBuilder, ddlValidator, LinqQuery.DDL_STATEMENT_GROUP_FILTER);
        return ddlBuilder;
    }

    @Override
    public ISimpleBuilder dmlBuild(InkConfig inkConfig) throws Exception {

        //build processing.
        SimpleDMLStatementExecutorImp.Builder dmlBuilder = new SimpleDMLStatementExecutorImp.Builder(inkConfig, simpleMetaStoreProvider);
        dmlBuilder = (SimpleDMLStatementExecutorImp.Builder) doBuild(dmlBuilder, dmlValidator, LinqQuery.DML_STATEMENT_GROUP_FILTER);
        return dmlBuilder;
    }

    public void build(String sql) throws Exception {
        if (statements == null) {
            throw new InkException(MessageEnum.EMPTY_STATEMENTS);
        }

        //all build.

        //build use
        ISimpleStatementExecutor simpleUSEStatementExecutorImp = (((SimpleUSEStatementExecutorImp.Builder) useBuild(inkConfig)).build());
        simpleStatementExecutors.add(simpleUSEStatementExecutorImp);

        //build setting
        ISimpleStatementExecutor simpleSETTINGStatementExecutorImp = (((SimpleSETTINGStatementExecutorImp.Builder) settingBuild(inkConfig)).build());
        simpleStatementExecutors.add(simpleSETTINGStatementExecutorImp);

        InkConfig mergedCustomConfig = configProperties.mergeInkConfig(inkConfig, ((SimpleSETTINGStatementExecutorImp) simpleSETTINGStatementExecutorImp).getCustomInkConfig());

        //build ddl
        simpleStatementExecutors.add(((SimpleDDLStatementExecutorImp.Builder) ddlBuild(mergedCustomConfig)).build());

        //build dml
        ISimpleStatementExecutor simpleDMLStatementExecutorImp = (((SimpleDMLStatementExecutorImp.Builder) dmlBuild(mergedCustomConfig)).build());
        simpleStatementExecutors.add(simpleDMLStatementExecutorImp);

        if (simpleDMLStatementExecutorImp.getResultStatement().size() >= 1) {
            if (mergedCustomConfig.getString(SettingEnum.JOB_NAME) != null) {
                //dump clear
                try {
                    DumpUtil dumpUtil = new DumpUtil();
                    dumpUtil.clear(mergedCustomConfig.getString(SettingEnum.JOB_NAME), mergedCustomConfig.getString(SettingEnum.DUMP_CLEAR_API_URL));
                } catch (Exception ex) {
                }

                //storm depoly
                StormManager.depoly(mergedCustomConfig, ((SimpleDMLStatementExecutorImp) simpleDMLStatementExecutorImp).getStormTopologyBuilder().build());
            }

            if (mergedCustomConfig.getBoolean(SettingEnum.REGIST_JOB) == true && mergedCustomConfig.getString(SettingEnum.JOB_NAME) != null) {
                simpleMetaStoreProvider.doRegistJobAction(mergedCustomConfig, sql);
            }
        }
    }



    public ResultSet generateResultSets() {
        List<ResultStatement> resultStatements = getResultStatements();
        return null;
    }

    public String toAST() {
        StringBuilder astSb = new StringBuilder();
        for (ISimpleStatementExecutor simpleStatementExecutor : simpleStatementExecutors) {
            astSb.append(simpleStatementExecutor.toAST());
        }
        return astSb.toString();
    }

    @Override
    public void init(ConfigProperties configProperties, SimpleMetaStoreProviderImp simpleMetaStoreProvider, ISimpleStatementMetaValidator useValidator, ISimpleStatementMetaValidator settingValidator, ISimpleStatementMetaValidator ddlValidator, ISimpleStatementMetaValidator dmlValidator) {
        this.configProperties = configProperties;
        this.inkConfig = configProperties.getDefaultInkConfig();
        this.simpleMetaStoreProvider = simpleMetaStoreProvider;
        this.settingValidator = settingValidator;
        this.ddlValidator = ddlValidator;
        this.dmlValidator = dmlValidator;
        this.useValidator = useValidator;
    }

    @Override
    public List<ResultStatement> getResultStatements() {
        List<ResultStatement> resultStatements = new ArrayList<ResultStatement>();
        for (ISimpleStatementExecutor simpleStatementExecutor : simpleStatementExecutors) {
            resultStatements.addAll(simpleStatementExecutor.getResultStatement());
        }
        return resultStatements;
    }

}
