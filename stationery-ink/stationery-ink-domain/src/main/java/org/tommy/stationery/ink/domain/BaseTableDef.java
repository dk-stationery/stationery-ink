package org.tommy.stationery.ink.domain;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 23..
 */
public class BaseTableDef implements Serializable {

    private static final long serialVersionUID = 4145032205381651197L;
    private String name;
    private String source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
