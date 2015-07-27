package org.tommy.stationery.ink.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 22..
 */
public enum StatementTypeEnum {
    RUNTIME("RUNTIME", GroupTypeEnum.DML, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.EMPTY),
    SNAPSHOT_JOB("SNAPSHOT", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    USE("USE", GroupTypeEnum.USE, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    SET("SET", GroupTypeEnum.SET, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    KILL_JOB("KILL_JOB", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_WRITE_DEPLOY),
    CREATE_STREAM("CREATE_STREAM", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_WRITE),
    CREATE_SOURCE("CREATE_SOURCE", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_WRITE),
    DROP_STREAM("DROP_STREAM", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_WRITE),
    DROP_SOURCE("DROP_SOURCE", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_WRITE),
    DROP_JOB("DROP_JOB", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_WRITE),
    SHOW_STREAM("SHOW_STREAM", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    SHOW_STREAMS("SHOW_STREAMS", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    SHOW_SOURCE("SHOW_SOURCE", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    SHOW_SOURCES("SHOW_SOURCES", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    SHOW_JOB("SHOW_JOB", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    SHOW_JOBS("SHOW_JOBS", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    SHOW_CLUSTER("SHOW_CLUSTER", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_ONLY),
    SHOW_SYSTEM("SHOW_SYSTEM", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY, GroupTypeAuthEnum.READ_WRITE_DEPLOY),
    SELECT("SELECT", GroupTypeEnum.DML, SubGroupTypeEnum.ESPER, GroupTypeAuthEnum.READ_WRITE_DEPLOY),
    LOOKUP("LOOKUP", GroupTypeEnum.DML, SubGroupTypeEnum.LOOKUP, GroupTypeAuthEnum.READ_WRITE_DEPLOY),
    INSERT("INSERT", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET, GroupTypeAuthEnum.READ_WRITE_DEPLOY),
    UPSERT("UPSERT", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET, GroupTypeAuthEnum.READ_WRITE_DEPLOY),
    UPDATE("UPDATE", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET, GroupTypeAuthEnum.READ_WRITE_DEPLOY),
    DELETE("DELETE", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET, GroupTypeAuthEnum.READ_WRITE_DEPLOY),
    REST("REST", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET, GroupTypeAuthEnum.READ_WRITE_DEPLOY)
    ;

    private String name;
    private GroupTypeEnum group;
    private SubGroupTypeEnum subGroup;
    private GroupTypeAuthEnum groupTypeAuth;

    public String getName() {
        return name;
    }
    public GroupTypeEnum getGroup() {
        return group;
    }
    public GroupTypeAuthEnum getGroupAuth() {
        return groupTypeAuth;
    }
    public SubGroupTypeEnum getSubGroup() {
        return subGroup;
    }
    private StatementTypeEnum(String name, GroupTypeEnum group, SubGroupTypeEnum subGroup, GroupTypeAuthEnum groupTypeAuth) {
        this.name = name;
        this.group = group;
        this.subGroup = subGroup;
        this.groupTypeAuth = groupTypeAuth;
    }

    public static enum GroupTypeAuthEnum {
        EMPTY("EMPTY", 0x0000),
        READ_ONLY("READ_ONLY", 0x001),
        READ_WRITE("READ_WRITE", 0x011),
        READ_WRITE_DEPLOY("READ_WRITE_DEPLOY", 0x111);

        private String name;
        private int bit;
        public String getName() {
            return name;
        }
        public int getBit() {
            return bit;
        }
        private GroupTypeAuthEnum(String name, int bit) {
            this.name = name;
            this.bit = bit;
        }
    }

    public static enum GroupTypeEnum {
        SET("SET"),
        USE("USE"),
        DDL("DDL"),
        DML("DML");

        private String name;
        public String getName() {
            return name;
        }

        private GroupTypeEnum(String name) {
            this.name = name;
        }

        public static List<GroupTypeEnum> GroupTypeList() {
           return new ArrayList<GroupTypeEnum>(Arrays.asList(
                   StatementTypeEnum.GroupTypeEnum.USE
                   , StatementTypeEnum.GroupTypeEnum.SET
                   , StatementTypeEnum.GroupTypeEnum.DML
                   , StatementTypeEnum.GroupTypeEnum.DDL
           ));
        }
    }

    public static enum SubGroupTypeEnum {
        EMPTY("EMPTY"),
        ESPER("ESPER"),
        LOOKUP("LOOKUP"),
        BUCKET("BUCKET");

        private String name;
        public String getName() {
            return name;
        }
        private SubGroupTypeEnum(String name) {
            this.name = name;
        }
    }
}
