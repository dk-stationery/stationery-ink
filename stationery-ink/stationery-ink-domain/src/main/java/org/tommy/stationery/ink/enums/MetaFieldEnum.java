package org.tommy.stationery.ink.enums;

/**
 * Created by kun7788 on 15. 2. 9..
 */
public enum MetaFieldEnum {
    TOPIC("TOPIC"),
    CATALOG("CATALOG"),
    URL("URL"),
    DRIVER("DRIVER"),
    ID("ID"),
    PW("PW"),
    VHOST("VHOST"),
    PORT("PORT");

    private String name;

    public String getName() {
        return name;
    }


    private MetaFieldEnum(String name) {
        this.name = name;
    }
}
