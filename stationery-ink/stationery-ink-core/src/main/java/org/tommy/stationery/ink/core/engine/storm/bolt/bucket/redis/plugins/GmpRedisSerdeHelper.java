package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import org.tommy.stationery.ink.core.engine.utils.TupleUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kun7788 on 15. 8. 7..
 */
public class GmpRedisSerdeHelper {

    Map<String, Integer> sessionHistoryIndexs = new HashMap<String, Integer>();

    public GmpRedisSerdeHelper() {
        sessionHistoryIndexs.put("date", 0);
        sessionHistoryIndexs.put("sum", 1);
        sessionHistoryIndexs.put("count", 2);
    }

    public String getAgeGroup(String ageBand) {
        String ageGroup = "U";
        if (ageBand == null || ageBand.length() < 1) {
            return ageGroup;
        }

        String age = ageBand.substring(0, 1);
        if ("1".equals(age) || "2".equals(age) || "3".equals(age) || "4".equals(age) ||"5".equals(age) || "6".equals(age)) {
            return age;
        } else {
            return ageGroup;
        }
    }

    private String MapToString(NavigableMap<Long, Map<String, Long>> map, Long date, Long sum) {
        boolean isFirstOp = false;
        if (map.containsKey(date) == false) {
            isFirstOp = true;
            Map<String, Long> subMap = new HashMap<String, Long>();
            subMap.put("sum", sum);
            subMap.put("count", 1l);
            map.put(date, subMap);
        }

        final boolean finalIsFirstOp = isFirstOp;
        String str = map.entrySet().parallelStream().map(v -> {
            if (finalIsFirstOp == false && v.getKey().equals(date)) {
                v.getValue().put("sum", v.getValue().get("sum") + sum);
                v.getValue().put("count", v.getValue().get("count") + 1);
            }
            return v;
        }).map(v -> {
            return v.getKey() + "," + v.getValue().get("sum") + "," + v.getValue().get("count");
        }).collect(Collectors.joining("|"));
        return str;
    }


    private NavigableMap<Long, Map<String, Long>> StringToMap(String str, int keyNameIndex, Map<String, Integer> indexs, int limitSize) {
        NavigableMap<Long, Map<String, Long>> map = new TreeMap<Long, Map<String, Long>>();

        List<String> strLists = Arrays.asList(str.split("\\|"));
        if (strLists.size() > limitSize) {
            strLists = strLists.subList(0, limitSize-1);
        }

        strLists.parallelStream().map(k -> {
            String[] vals = k.split("\\,");
            return vals;
        }).forEach(k -> {
            Map<String, Long> data = new HashMap<String, Long>();
            indexs.entrySet().forEach(e -> {
                data.put(e.getKey(), Long.valueOf(k[e.getValue()]));
            });
            map.put(Long.valueOf(k[keyNameIndex]), data);
        });
        return map.descendingMap();
    }


    public String genAccFlat(Map<String, String> appVlaues, String keyName, Tuple tuple, String tsField, String sumField) {
        //first,last,sum,count|,,,,
        String accFlat = "";
        if (appVlaues.containsKey(keyName)) {
            String sessionAcc = appVlaues.get(keyName);
            String[] sessionAccArr = sessionAcc.split("\\,");
            if (TupleUtil.getValue(tuple, tsField) == null || TupleUtil.getValue(tuple, sumField) == null) {
                return null;
            }
            accFlat = sessionAccArr[0] + "," + tuple.getStringByField(tsField) + "," + (Long.valueOf(sessionAccArr[2]) + Long.valueOf(tuple.getStringByField(sumField)) + "," + (Long.valueOf(sessionAccArr[3]) + 1));
        } else {
            accFlat = tuple.getStringByField(tsField) + "," + tuple.getStringByField(tsField) + "," + tuple.getStringByField(sumField) + ",1";
        }
        return accFlat;
    }

    public String genHistoryFlat(Map<String, String> appVlaues, String keyName, Tuple tuple, String tsField, String sumField, int limitSize) {
        String historyFlat = "";
        if (appVlaues.containsKey(keyName)) {
            String sessionHistory = appVlaues.get(keyName);
            NavigableMap<Long, Map<String, Long>> map = StringToMap(sessionHistory, 0, sessionHistoryIndexs, limitSize);
            if (TupleUtil.getValue(tuple, tsField) == null || TupleUtil.getValue(tuple, sumField) == null) {
                return null;
            }
            historyFlat = MapToString(map, Long.valueOf(tuple.getStringByField(tsField)), Long.valueOf((tuple.getStringByField(sumField))));
        } else {
            historyFlat = tuple.getStringByField(tsField) + "," + tuple.getStringByField(sumField) + ",1";
        }
        return historyFlat;
    }
}
