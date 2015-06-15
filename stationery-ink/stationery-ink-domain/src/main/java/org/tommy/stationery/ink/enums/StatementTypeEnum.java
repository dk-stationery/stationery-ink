package org.tommy.stationery.ink.enums;

/**
 * Created by kun7788 on 15. 1. 22..
 */
public enum StatementTypeEnum {
    RUNTIME("RUNTIME", GroupTypeEnum.DML, SubGroupTypeEnum.EMPTY),
    SNAPSHOT_JOB("SNAPSHOT", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    USE("USE", GroupTypeEnum.USE, SubGroupTypeEnum.EMPTY),
    SET("SET", GroupTypeEnum.SET, SubGroupTypeEnum.EMPTY),
    KILL_JOB("KILL_JOB", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    CREATE_STREAM("CREATE_STREAM", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    CREATE_SOURCE("CREATE_SOURCE", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    DROP_STREAM("DROP_STREAM", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    DROP_SOURCE("DROP_SOURCE", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    DROP_JOB("DROP_JOB", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SHOW_STREAM("SHOW_STREAM", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SHOW_STREAMS("SHOW_STREAMS", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SHOW_SOURCE("SHOW_SOURCE", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SHOW_SOURCES("SHOW_SOURCES", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SHOW_JOB("SHOW_JOB", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SHOW_JOBS("SHOW_JOBS", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SHOW_CLUSTER("SHOW_CLUSTER", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SHOW_SYSTEM("SHOW_SYSTEM", GroupTypeEnum.DDL, SubGroupTypeEnum.EMPTY),
    SELECT("SELECT", GroupTypeEnum.DML, SubGroupTypeEnum.ESPER),
    LOOKUP("LOOKUP", GroupTypeEnum.DML, SubGroupTypeEnum.LOOKUP),
    INSERT("INSERT", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET),
    UPSERT("UPSERT", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET),
    UPDATE("UPDATE", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET),
    DELETE("DELETE", GroupTypeEnum.DML, SubGroupTypeEnum.BUCKET)
    ;

    private String name;
    private GroupTypeEnum group;
    private SubGroupTypeEnum subGroup;

    public String getName() {
        return name;
    }
    public GroupTypeEnum getGroup() {
        return group;
    }
    public SubGroupTypeEnum getSubGroup() {
        return subGroup;
    }
    private StatementTypeEnum(String name, GroupTypeEnum group, SubGroupTypeEnum subGroup) {
        this.name = name;
        this.group = group;
        this.subGroup = subGroup;
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
