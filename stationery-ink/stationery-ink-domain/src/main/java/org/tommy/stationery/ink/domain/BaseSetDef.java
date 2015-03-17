package org.tommy.stationery.ink.domain;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 2. 13..
 */
public class BaseSetDef implements Serializable {
    private static final long serialVersionUID = 1273152654555939399L;
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
