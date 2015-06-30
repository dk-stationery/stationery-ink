package org.tommy.stationery.ink.core.engine.spark.build;

import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.build.ISimpleBuilder;
import org.tommy.stationery.ink.core.engine.build.IStatementBuilder;
import org.tommy.stationery.ink.core.config.ConfigProperties;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.ResultStatement;
import org.tommy.stationery.ink.domain.meta.Auth;
import org.tommy.stationery.ink.exception.InkException;

import java.util.List;

/**
 * Created by kun7788 on 15. 6. 29..
 */
public class SparkStatementBuilder implements IStatementBuilder {
    @Override
    public void registerEventHandlersFromEventBus() {

    }

    @Override
    public InkConfig mergedInkConfig(ISimpleBuilder builder) throws InkException {
        return null;
    }

    @Override
    public void registSQLOnMetastore(InkConfig inkConfig, String sql) throws Exception {

    }

    @Override
    public void clearSnapshotWastedData(InkConfig inkConfig) {

    }

    @Override
    public void build(List<BaseStatement> statements, String sql) throws Exception {

    }

    @Override
    public void init(ConfigProperties configProperties, SimpleMetaStoreProviderImp simpleMetaStoreProvider, Auth auth) {

    }

    @Override
    public List<ResultStatement> getResultStatements() {
        return null;
    }

    @Override
    public String toAST() {
        return null;
    }
}
