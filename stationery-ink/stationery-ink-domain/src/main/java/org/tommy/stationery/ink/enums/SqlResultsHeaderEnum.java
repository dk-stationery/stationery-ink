package org.tommy.stationery.ink.enums;

/**
 * Created by kun7788 on 15. 2. 2..
 */
public enum SqlResultsHeaderEnum {
    ID("ID", 0),
    TYPE("TYPE", 1),
    ERROR("ERROR", 2),
    RESULT("RESULT", 3);


    private String name;
    private int index;

    public String getName() {
        return name;
    }

    private SqlResultsHeaderEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
