package org.tommy.stationery.ink.core.util;

import net.hydromatic.linq4j.function.Function1;
import net.hydromatic.linq4j.function.Predicate1;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseMetaDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.enums.StatementTypeEnum;

/**
 * Created by kun7788 on 15. 1. 27..
 */
public class LinqQuery {

    public static final Predicate1<BaseColumnDef> PARTITIONKEY_COLUMN_GROUP_FILTER = new Predicate1<BaseColumnDef>() {
        @Override
        public boolean apply(BaseColumnDef column) {
            if (column.isPk()) {
                return true;
            }
            return false;
        }
    };


    public static final Function1<BaseStatement, StatementTypeEnum> STATEMENT_TYPE_SELECTOR =
            new Function1<BaseStatement, StatementTypeEnum>() {
                @Override
                public StatementTypeEnum apply(BaseStatement statement) {
                    return statement.getType();
                }
            };

    public static final Predicate1<BaseStatement> USE_STATEMENT_GROUP_FILTER = new Predicate1<BaseStatement>() {
        @Override
        public boolean apply(BaseStatement statement) {
            if (StatementTypeEnum.GroupTypeEnum.USE.equals(statement.getType().getGroup())) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseStatement> SETTING_STATEMENT_GROUP_FILTER = new Predicate1<BaseStatement>() {
        @Override
        public boolean apply(BaseStatement statement) {
            if (StatementTypeEnum.GroupTypeEnum.SET.equals(statement.getType().getGroup())) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseStatement> DDL_STATEMENT_GROUP_FILTER = new Predicate1<BaseStatement>() {
        @Override
        public boolean apply(BaseStatement statement) {
            if (StatementTypeEnum.GroupTypeEnum.DDL.equals(statement.getType().getGroup())) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseStatement> DML_STATEMENT_GROUP_FILTER = new Predicate1<BaseStatement>() {
        @Override
        public boolean apply(BaseStatement statement) {
            if (StatementTypeEnum.GroupTypeEnum.DML.equals(statement.getType().getGroup())) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseStatement> ESPER_STATEMENT_GROUP_FILTER = new Predicate1<BaseStatement>() {
        @Override
        public boolean apply(BaseStatement statement) {
            if (StatementTypeEnum.SubGroupTypeEnum.ESPER.equals(statement.getType().getSubGroup())) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseStatement> LOOKUP_STATEMENT_GROUP_FILTER = new Predicate1<BaseStatement>() {
        @Override
        public boolean apply(BaseStatement statement) {
            if (StatementTypeEnum.SubGroupTypeEnum.LOOKUP.equals(statement.getType().getSubGroup())) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseStatement> BUCKET_STATEMENT_GROUP_FILTER = new Predicate1<BaseStatement>() {
        @Override
        public boolean apply(BaseStatement statement) {
            if (StatementTypeEnum.SubGroupTypeEnum.BUCKET.equals(statement.getType().getSubGroup())) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseMetaDef> DDL_META_CATALOG_FILTER = new Predicate1<BaseMetaDef>() {
        @Override
        public boolean apply(BaseMetaDef metaDef) {
            if ("CATALOG".equals(metaDef.getName()) && metaDef.getValue() != null) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseMetaDef> META_URL_FILTER = new Predicate1<BaseMetaDef>() {
        @Override
        public boolean apply(BaseMetaDef metaDef) {
            if ("URL".equals(metaDef.getName()) && metaDef.getValue() != null) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseMetaDef> META_TOPIC_FILTER = new Predicate1<BaseMetaDef>() {
        @Override
        public boolean apply(BaseMetaDef metaDef) {
            if ("TOPIC".equals(metaDef.getName()) && metaDef.getValue() != null) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseMetaDef> META_PORT_FILTER = new Predicate1<BaseMetaDef>() {
        @Override
        public boolean apply(BaseMetaDef metaDef) {
            if ("PORT".equals(metaDef.getName()) && metaDef.getValue() != null) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseMetaDef> META_ID_FILTER = new Predicate1<BaseMetaDef>() {
        @Override
        public boolean apply(BaseMetaDef metaDef) {
            if ("ID".equals(metaDef.getName()) && metaDef.getValue() != null) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseMetaDef> META_PW_FILTER = new Predicate1<BaseMetaDef>() {
        @Override
        public boolean apply(BaseMetaDef metaDef) {
            if ("PW".equals(metaDef.getName()) && metaDef.getValue() != null) {
                return true;
            }
            return false;
        }
    };

    public static final Predicate1<BaseMetaDef> META_VHOST_FILTER = new Predicate1<BaseMetaDef>() {
        @Override
        public boolean apply(BaseMetaDef metaDef) {
            if ("VHOST".equals(metaDef.getName()) && metaDef.getValue() != null) {
                return true;
            }
            return false;
        }
    };
}
