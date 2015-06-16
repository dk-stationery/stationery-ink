package org.tommy.stationery.ink.core.storm.build;

import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.core.storm.build.executor.ISimpleBuilder;
import org.tommy.stationery.ink.core.storm.build.validator.ISimpleStatementMetaValidator;
import org.tommy.stationery.ink.domain.ResultStatement;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 27..
 */
public interface ISimpleStatementsBuilder {
    public ISimpleBuilder useBuild(InkConfig inkConfig) throws Exception;
    public ISimpleBuilder ddlBuild(InkConfig inkConfig) throws Exception;
    public ISimpleBuilder dmlBuild(InkConfig inkConfig) throws Exception;
    public ISimpleBuilder settingBuild(InkConfig inkConfig) throws Exception;
    public void build(String sql) throws Exception;
    public ResultSet generateResultSets();
    public List<ResultStatement> getResultStatements();
    public String toAST();
    public void init(ConfigProperties configProperties, SimpleMetaStoreProviderImp simpleMetaStoreProvider, ISimpleStatementMetaValidator useValidator, ISimpleStatementMetaValidator settingValidator, ISimpleStatementMetaValidator ddlValidator, ISimpleStatementMetaValidator dmlValidator);
}
