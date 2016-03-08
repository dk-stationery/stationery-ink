package org.tommy.stationery.ink.enums;

/**
 * Created by kun7788 on 15. 1. 23..
 */
public enum SourceCatalogEnum {
    JMS("JMS"),
    DUMMY("DUMMY"),
    KAFKA("KAFKA"),
    RABBITMQ("RABBITMQ"),
    TICK("TICK"),
    HDFS("HDFS"),
    ELASTICSEARCH("ELASTICSEARCH"),
    JDBC("JDBC"),
    PHOENIX("PHOENIX"),
    REDIS("REDIS"),
    REST("REST")
    ;

    private String name;

    public String getName() {
        return name;
    }


    private SourceCatalogEnum(String name) {
        this.name = name;
    }
}

