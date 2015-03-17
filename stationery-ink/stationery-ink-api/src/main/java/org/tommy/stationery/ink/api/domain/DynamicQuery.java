package org.tommy.stationery.ink.api.domain;

/**
 * Created by kun7788 on 15. 2. 10..
 */
public class DynamicQuery {
    private String tableName;
    private String where;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
