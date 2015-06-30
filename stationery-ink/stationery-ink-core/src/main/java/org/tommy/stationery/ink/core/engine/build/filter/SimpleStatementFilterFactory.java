package org.tommy.stationery.ink.core.engine.build.filter;

import net.hydromatic.linq4j.function.Predicate1;
import org.tommy.stationery.ink.core.util.LinqQuery;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.exception.InkException;

/**
 * Created by kun7788 on 15. 6. 17..
 */
public class SimpleStatementFilterFactory {

    public static Predicate1<BaseStatement> getInstance(StatementTypeEnum.GroupTypeEnum groupTypeEnum) throws InkException {
        if (StatementTypeEnum.GroupTypeEnum.USE.equals(groupTypeEnum)) {
            return LinqQuery.USE_STATEMENT_GROUP_FILTER;
        } else if (StatementTypeEnum.GroupTypeEnum.SET.equals(groupTypeEnum)) {
            return LinqQuery.SETTING_STATEMENT_GROUP_FILTER;
        } else if (StatementTypeEnum.GroupTypeEnum.DDL.equals(groupTypeEnum)) {
            return LinqQuery.DDL_STATEMENT_GROUP_FILTER;
        } else if (StatementTypeEnum.GroupTypeEnum.DML.equals(groupTypeEnum)) {
            return LinqQuery.DML_STATEMENT_GROUP_FILTER;
        } else {
            throw new InkException(MessageEnum.NO_SUPPORT_STATEMENT_SUBGROUP);
        }
    }
}
