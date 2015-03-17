package org.tommy.stationery.ink.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 2..
 */
public class SqlResults implements Serializable {

    private static final long serialVersionUID = 4341455038928932941L;
    private List<Object> rowIds = new ArrayList<Object>();
    private List<Object> types = new ArrayList<Object>();
    private List<Object> results = new ArrayList<Object>();
    private List<Object> errors = new ArrayList<Object>();

    public List<List<Object>> getListFromCursor() {
        List<List<Object>> lists = new ArrayList<List<Object>>();
        lists.add(rowIds);
        lists.add(types);
        lists.add(errors);
        lists.add(results);

        return lists;
    }

    public List<Object> getRowIds() {
        return rowIds;
    }

    public List<Object> getTypes() {
        return types;
    }

    public List<Object> getResults() {
        return results;
    }

    public List<Object> getErrors() {
        return errors;
    }
}
