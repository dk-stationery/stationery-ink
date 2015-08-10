package org.tommy.stationery.ink.core.engine.utils;

import backtype.storm.tuple.Tuple;

/**
 * Created by kun7788 on 15. 8. 7..
 */
public class TupleUtil {

    public static String getStringValue(Tuple tuple, String field) {
        if (tuple.getFields().contains(field) == false) return null;
        return tuple.getStringByField(field);
    }

    public static Long getLongValue(Tuple tuple, String field) {
        if (tuple.getFields().contains(field) == false) return null;
        return (Long)tuple.getValueByField(field);
    }
}
