package org.tommy.stationery.ink.domain;


import org.tommy.stationery.ink.enums.StatementTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 22..
 */
public class BaseStatement implements Serializable {

    private static final long serialVersionUID = -1401618395026065766L;

    private BaseTableDef table;
    private List<BaseTableDef> bindTables;
    private String query;
    private String dressQuery;
    private StatementTypeEnum type;
    private List<BaseColumnDef> columns;
    private List<BaseBindColumnDef> bindColumns;
    private List<BaseMetaDef> metas;
    private BaseSetDef settingDef;
    private BaseUseDef useDef;

    public BaseTableDef getTable() {
        return table;
    }

    public void setTable(BaseTableDef table) {
        this.table = table;
    }

    public List<BaseColumnDef> getColumns() {
        return columns;
    }

    public void setColumns(List<BaseColumnDef> columns) {
        this.columns = columns;
    }

    public List<BaseMetaDef> getMetas() {
        return metas;
    }

    public void setMetas(List<BaseMetaDef> metas) {
        this.metas = metas;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public StatementTypeEnum getType() {
        return type;
    }

    public void setType(StatementTypeEnum type) {
        this.type = type;
    }

    public List<BaseBindColumnDef> getBindColumns() {
        return bindColumns;
    }

    public void setBindColumns(List<BaseBindColumnDef> bindColumns) {
        this.bindColumns = bindColumns;
    }

    public List<BaseTableDef> getBindTables() {
        return bindTables;
    }

    public void setBindTables(List<BaseTableDef> bindTables) {
        this.bindTables = bindTables;
    }

    public String getDressQuery() {
        return dressQuery;
    }

    public void setDressQuery(String dressQuery) {
        this.dressQuery = dressQuery;
    }

    public BaseSetDef getSettingDef() {
        return settingDef;
    }

    public void setSettingDef(BaseSetDef settingDef) {
        this.settingDef = settingDef;
    }

    public BaseUseDef getUseDef() {
        return useDef;
    }

    public void setUseDef(BaseUseDef useDef) {
        this.useDef = useDef;
    }
}
