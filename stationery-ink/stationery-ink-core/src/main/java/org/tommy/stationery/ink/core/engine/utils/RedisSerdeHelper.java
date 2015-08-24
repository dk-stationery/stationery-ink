package org.tommy.stationery.ink.core.engine.utils;

import backtype.storm.tuple.Tuple;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kun7788 on 15. 8. 7..
 */
public class RedisSerdeHelper {

    Map<String, Integer> sessionHistoryIndexs = new HashMap<String, Integer>();
    Map<String, Integer> appInstalledIndexs = new HashMap<String, Integer>();

    public void callbackHttp(String callBackProxyServerUrl) {
        StringBuilder lines = new StringBuilder();
        // HttpClient 생성
        HttpClient httpclient = new DefaultHttpClient();
        try {
            // HttpGet생성
            HttpGet httpget = new HttpGet(callBackProxyServerUrl);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    lines.append(line);
                }
            }
            httpget.abort();
            httpclient.getConnectionManager().shutdown();
        } catch (Exception ex) {

        }
    }

    public RedisSerdeHelper() {
        sessionHistoryIndexs.put("date", 0);
        sessionHistoryIndexs.put("sum", 1);
        sessionHistoryIndexs.put("count", 2);

        appInstalledIndexs.put("clientId", 0);
        appInstalledIndexs.put("date", 1);
    }

    private String MapToString(NavigableMap<Long, Map<String, Long>> map, Long date, Long sum, Long cnt) {
        boolean isFirstOp = false;
        if (map.containsKey(date) == false) {
            isFirstOp = true;
            Map<String, Long> subMap = new HashMap<String, Long>();
            subMap.put("sum", sum);
            subMap.put("count", cnt);
            map.put(date, subMap);
        }

        final boolean finalIsFirstOp = isFirstOp;
        String str = map.entrySet().stream().map(v -> {
            if (finalIsFirstOp == false && v.getKey().equals(date)) {
                v.getValue().put("sum", v.getValue().get("sum") + sum);
                v.getValue().put("count", v.getValue().get("count") + cnt);
            }
            return v;
        }).map(v -> {
            return v.getKey() + "," + v.getValue().get("sum") + "," + v.getValue().get("count");
        }).collect(Collectors.joining("|"));
        return str;
    }

    private String MapToStringV2(NavigableMap<Long, Map<String, String>> map, Long date, String clientId) {
        boolean isFirstOp = false;
        if (map.containsKey(date) == false) {
            isFirstOp = true;
            Map<String, String> subMap = new HashMap<String, String>();
            subMap.put("clientId", clientId);
            map.put(date, subMap);
        }

        final boolean finalIsFirstOp = isFirstOp;
        String str = map.entrySet().stream().map(v -> {
            if (finalIsFirstOp == false && v.getKey().equals(date)) {
                return clientId + "," + v.getKey();
            }
            return v.getValue().get("clientId") + "," + v.getKey();
        }).collect(Collectors.joining("|"));
        return str;
    }

    private NavigableMap<Long, Map<String, Long>> StringToMap(String str, int keyNameIndex, Map<String, Integer> indexs, int limitSize) {
        NavigableMap<Long, Map<String, Long>> map = new TreeMap<Long, Map<String, Long>>();

        List<String> strLists = Arrays.asList(str.split("\\|"));
        if (strLists.size() > limitSize) {
            strLists = strLists.subList(0, limitSize-1);
        }

        strLists.stream().map(k -> {
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


    private NavigableMap<Long, Map<String, String>> StringToMapV2(String str, int keyNameIndex, Map<String, Integer> indexs, int limitSize) {
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

    public String genAccFlat(String sessionAcc, Tuple tuple, String tsField, String sumField, String cntField) {
        //first,last,sum,count|,,,,
        String accFlat = null;

        if (TupleUtil.getStringValue(tuple, tsField) == null || TupleUtil.getLongValue(tuple, sumField) == null || TupleUtil.getLongValue(tuple, cntField) == null) {
            return accFlat;
        }

        if (sessionAcc != null) {
            String[] sessionAccArr = sessionAcc.split("\\,");
            accFlat = sessionAccArr[0] + "," + tuple.getStringByField(tsField) + "," + (Long.valueOf(sessionAccArr[2]) + TupleUtil.getLongValue(tuple, sumField)) + "," + (Long.valueOf(sessionAccArr[3]) + TupleUtil.getLongValue(tuple, cntField));
        } else {
            accFlat = tuple.getStringByField(tsField) + "," + tuple.getStringByField(tsField) + "," + TupleUtil.getLongValue(tuple, sumField) + "," + TupleUtil.getLongValue(tuple, cntField);
        }
        return accFlat;
    }

    public String genHistoryFlat(String sessionHistory, Tuple tuple, String tsField, String sumField, String cntField, int limitSize) {
        String historyFlat = null;

        System.out.println("AAAAA-1 ======== " + tuple.getValues());
        System.out.println("AAAAA-1-0 ======== " + tuple.getFields());
        System.out.println("AAAAA-1-1 ========" + tsField + " , " + TupleUtil.getStringValue(tuple, tsField));
        System.out.println("AAAAA-1-2 ========" + sumField + " , " + TupleUtil.getLongValue(tuple, sumField));
        System.out.println("AAAAA-1-3 ========" + cntField + " , " + TupleUtil.getLongValue(tuple, cntField));

        if (TupleUtil.getStringValue(tuple, tsField) == null || TupleUtil.getLongValue(tuple, sumField) == null  || TupleUtil.getLongValue(tuple, cntField) == null) {
            return historyFlat;
        }
        System.out.println("AAAAA-2 ========");
        if (sessionHistory != null) {
            System.out.println("AAAAA-3 ========");
            NavigableMap<Long, Map<String, Long>> map = StringToMap(sessionHistory, 0, sessionHistoryIndexs, limitSize);
            historyFlat = MapToString(map, TupleUtil.getLongValue(tuple, tsField), TupleUtil.getLongValue(tuple, sumField), TupleUtil.getLongValue(tuple, cntField));
        } else {
            historyFlat = tuple.getStringByField(tsField) + "," + TupleUtil.getLongValue(tuple, sumField) + "," + TupleUtil.getLongValue(tuple, cntField);
        }
        return historyFlat;
    }

    public String genClientIdAndDtHistoryFlat(String appInstalled, Tuple tuple, String tsField, String clientIdField, int limitSize) {
        String appInstalledFlat = null;
        if (TupleUtil.getStringValue(tuple, tsField) == null || TupleUtil.getStringValue(tuple, clientIdField) == null) {
            return appInstalledFlat;
        }
        if (appInstalled != null) {
            NavigableMap<Long, Map<String, String>> map = StringToMapV2(appInstalled, 1, appInstalledIndexs, limitSize);
            appInstalledFlat = MapToStringV2(map, TupleUtil.getLongValue(tuple, tsField), TupleUtil.getStringValue(tuple, clientIdField));
        } else {
            appInstalledFlat = tuple.getStringByField(clientIdField) + "," + TupleUtil.getLongValue(tuple, tsField);
        }
        return appInstalledFlat;
    }
}
