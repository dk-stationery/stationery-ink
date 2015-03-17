package org.tommy.stationery.ink.domain;

import org.tommy.stationery.ink.enums.ColumnDataTypeEnum;

import java.io.Serializable;

/**
 * Created by kun7788 on 15. 1. 21..
 */
public class BaseColumnDef implements Serializable {

    private static final long serialVersionUID = -574664656764009505L;
    private String name;
    private ColumnDataTypeEnum type;
    private boolean pk;
    private String comment;

    public BaseColumnDef() {

    }

    public BaseColumnDef(String name, ColumnDataTypeEnum type, boolean pk, String comment) {
        setName(name);
        setType(type);
        setPk(pk);
        setComment(comment);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ColumnDataTypeEnum getType() {
        return type;
    }

    public void setType(ColumnDataTypeEnum type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPk() {
        return pk;
    }

    public void setPk(boolean pk) {
        this.pk = pk;
    }
}
