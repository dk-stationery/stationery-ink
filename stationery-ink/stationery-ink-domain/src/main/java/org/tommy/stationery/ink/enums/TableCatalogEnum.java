package org.tommy.stationery.ink.enums;

/**
 * Created by kun7788 on 15. 1. 21..
 */
public enum TableCatalogEnum {
    STREAM("STREAM"),
    LOOKUP("LOOKUP");

    private String name;

    public String getName() {
        return name;
    }


    private TableCatalogEnum(String name) {
        this.name = name;
    }
}
