package org.tommy.stationery.ink.domain;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 21..
 */
public class BaseMetaDef implements Serializable {

    private static final long serialVersionUID = -3640927274259925286L;
    private String name;
    private String value;

    public BaseMetaDef() {

    }

    public BaseMetaDef(String name, String value) {
        setName(name);
        setValue(value);
    }

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
