package org.tommy.stationery.ink.core.engine.build;

import org.tommy.stationery.ink.config.InkConfig;
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
public interface IStatementBuilder {
    public void registerEventHandlersFromEventBus();
    public InkConfig mergedInkConfig(ISimpleBuilder builder) throws InkException;
    public void registSQLOnMetastore(InkConfig inkConfig, String sql) throws Exception;
    public void clearSnapshotWastedData(InkConfig inkConfig);
    public void build(List<BaseStatement> statements, String sql) throws Exception;
    public void init(ConfigProperties configProperties, SimpleMetaStoreProviderImp simpleMetaStoreProvider, Auth auth);
    public List<ResultStatement> getResultStatements();
    public String toAST();
}
