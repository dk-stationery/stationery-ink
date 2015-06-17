package org.tommy.stationery.ink.core.storm.build.executor;

import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.exception.InkException;

/**
 * Created by kun7788 on 15. 6. 17..
 */
public class SimpleStatementBuilderFactory {

    public static ISimpleBuilder getInstance(StatementTypeEnum.GroupTypeEnum groupTypeEnum, InkConfig inkConfig, SimpleMetaStoreProviderImp simpleMetaStoreProvider) throws InkException {
        if (StatementTypeEnum.GroupTypeEnum.USE.equals(groupTypeEnum)) {
            return  new SimpleUSEStatementExecutorImp.Builder();
        } else if (StatementTypeEnum.GroupTypeEnum.SET.equals(groupTypeEnum)) {
            return  new SimpleSETTINGStatementExecutorImp.Builder();
        } else if (StatementTypeEnum.GroupTypeEnum.DDL.equals(groupTypeEnum)) {
            return new SimpleDDLStatementExecutorImp.Builder(inkConfig, simpleMetaStoreProvider);
        } else if (StatementTypeEnum.GroupTypeEnum.DML.equals(groupTypeEnum)) {
            return new SimpleDMLStatementExecutorImp.Builder(inkConfig, simpleMetaStoreProvider);
        } else {
            throw new InkException(MessageEnum.NO_SUPPORT_STATEMENT_SUBGROUP);
        }
    }

}
