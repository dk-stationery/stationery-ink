package org.tommy.stationery.ink.api.domain;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 9..
 */
public class DynamicApiCallInfo {
    private String apiName;
    private String tableName;
    private List<String> columns;
    private HashMap<String, String> params;

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
