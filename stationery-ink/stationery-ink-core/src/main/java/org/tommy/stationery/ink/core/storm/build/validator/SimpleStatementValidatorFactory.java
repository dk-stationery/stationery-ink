package org.tommy.stationery.ink.core.storm.build.validator;

import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.exception.InkException;

/**
 * Created by kun7788 on 15. 6. 17..
 */
public class SimpleStatementValidatorFactory {

    public static ISimpleStatementMetaValidator getInstance(StatementTypeEnum.GroupTypeEnum groupTypeEnum, SimpleMetaStoreProviderImp simpleMetaStoreProviderImp) throws InkException {
        if (StatementTypeEnum.GroupTypeEnum.USE.equals(groupTypeEnum)) {
            return new SimpleUSEStatementMetaValidatorImp();
        } else if (StatementTypeEnum.GroupTypeEnum.SET.equals(groupTypeEnum)) {
            return new SimpleSETTINGStatementMetaValidatorImp();
        } else if (StatementTypeEnum.GroupTypeEnum.DDL.equals(groupTypeEnum)) {
            return new SimpleDDLStatementMetaValidatorImp();
        } else if (StatementTypeEnum.GroupTypeEnum.DML.equals(groupTypeEnum)) {
            return new SimpleDMLStatementMetaValidatorImp(simpleMetaStoreProviderImp);
        } else {
            throw new InkException(MessageEnum.NO_SUPPORT_STATEMENT_SUBGROUP);
        }
    }
}
