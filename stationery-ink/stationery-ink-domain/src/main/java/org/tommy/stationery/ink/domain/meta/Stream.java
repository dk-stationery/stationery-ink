package org.tommy.stationery.ink.domain.meta;

import org.tommy.stationery.ink.domain.BaseStatement;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 28..
 */
public class Stream implements Serializable {

    private static final long serialVersionUID = 7613869846076662083L;
    private String name;
    private String meta;

    private BaseStatement statement;

    public Stream() {
    }

    public Stream(String name) {
        this.name = name;
    }

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

    public BaseStatement getStatement() {
        return statement;
    }

    public void setStatement(BaseStatement statement) {
        this.statement = statement;
    }

}
