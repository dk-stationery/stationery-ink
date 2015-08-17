package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis;

import java.util.*;

/**
 * Created by kun7788 on 15. 8. 13..
 */
public class Test1 {
    private static Map<String, Integer> appInstalledIndexs = new HashMap<String, Integer>();

    public static NavigableMap<Long, Map<String, String>> StringToMapV2(String str, int keyNameIndex, Map<String, Integer> indexs, int limitSize) {
        NavigableMap<Long, Map<String, String>> map = new TreeMap<Long, Map<String, String>>();

        List<String> strLists = Arrays.asList(str.split("\\|"));
        if (strLists.size() > limitSize) {
            strLists = strLists.subList(0, limitSize-1);
        }

        strLists.stream().map(k -> {
            String[] vals = k.split("\\,");
            return vals;
        }).forEach(k -> {
            Map<String, String> data = new HashMap<String, String>();
            indexs.entrySet().forEach(e -> {
                data.put(e.getKey(), k[e.getValue()]);
            });
            map.put(Long.valueOf(k[keyNameIndex]), data);
        });
        return map.descendingMap();
    }

    public static void main(String[] args) {
        appInstalledIndexs.put("clientId", 0);
        appInstalledIndexs.put("date", 1);

       // String appInstalledFlat = Test1.MapToStringV2(map, TupleUtil.getLongValue(tuple, tsField), TupleUtil.getStringValue(tuple, clientIdField));
    }
}
