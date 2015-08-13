package org.tommy.stationery.ink.core.engine.utils;

import backtype.storm.tuple.Tuple;

/**
 * Created by kun7788 on 15. 8. 7..
 */
public class TupleUtil {

    public static String getStringValue(Tuple tuple, String field) {
        if (tuple.getFields().contains(field) == false) return null;
        if ("".equals(tuple.getStringByField(field))) return null;
        return tuple.getStringByField(field);
    }

    public static Long getLongValue(Tuple tuple, String field) {
        if (tuple.getFields().contains(field) == false) return null;

        try {
            return Long.valueOf(tuple.getValueByField(field).toString());
        } catch (Exception ex) {
        }

        try {
            return tuple.getLongByField(field);
        } catch(Exception ex){}

        try {
            return Long.valueOf(tuple.getStringByField(field));
        } catch(Exception ex){}



        return null;
    }
}
