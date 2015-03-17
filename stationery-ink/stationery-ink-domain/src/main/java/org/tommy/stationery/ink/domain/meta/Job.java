package org.tommy.stationery.ink.domain.meta;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 28..
 */
public class Job implements Serializable {
    private static final long serialVersionUID = 436881708565023641L;
    private String name;
    private String meta;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

}
