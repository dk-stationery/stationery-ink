package org.tommy.stationery.ink.enums;

/**
 * Created by kun7788 on 15. 6. 29..
 */
public enum EngineTypeEnum {
    SPARK("SPARK"),
    STORM("STORM");

    private String name;

    public String getName() {
        return name;
    }

    private EngineTypeEnum(String name) {
        this.name = name;
    }
}
