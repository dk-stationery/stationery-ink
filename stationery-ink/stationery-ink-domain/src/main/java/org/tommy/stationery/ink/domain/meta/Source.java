package org.tommy.stationery.ink.domain.meta;

import org.tommy.stationery.ink.domain.BaseStatement;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 28..
 */
public class Source implements Serializable {

    private static final long serialVersionUID = 7241119644695527977L;
    private String name;
    private String catalog;
    private String meta;
    private BaseStatement statement;

    public Source() {

    }

    public Source(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
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
