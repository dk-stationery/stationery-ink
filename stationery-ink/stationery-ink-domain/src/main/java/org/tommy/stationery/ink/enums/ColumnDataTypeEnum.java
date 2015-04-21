package org.tommy.stationery.ink.enums;

/**
 * Created by kun7788 on 15. 1. 21..
 */
public enum ColumnDataTypeEnum {
    STRING("STRING", String.class),
    INTEGER("INTEGER", Integer.class),
    FLOAT("FLOAT", Float.class),
    OBJECT("OBJECT", Object.class),
    DOUBLE("DOUBLE", Double.class);

    private String name;
    private Class zlass;
;
    public String getName() {
        return name;
    }
    public Class getZlass() {
        return zlass;
    }

    private ColumnDataTypeEnum(String name, Class zlass) {
        this.name = name;
        this.zlass = zlass;
    }
}
