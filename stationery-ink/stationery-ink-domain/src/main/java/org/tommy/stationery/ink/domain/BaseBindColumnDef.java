package org.tommy.stationery.ink.domain;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 26..
 */
public class BaseBindColumnDef implements Serializable {

    private static final long serialVersionUID = 7899946860358614320L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
