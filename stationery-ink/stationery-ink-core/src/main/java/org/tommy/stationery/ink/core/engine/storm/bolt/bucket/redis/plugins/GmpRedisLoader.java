package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import org.codehaus.jackson.map.ObjectMapper;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 4..
 */
public class GmpRedisLoader implements RedisPlugin {

    ObjectMapper objectMapper = new ObjectMapper();

    private String getAgeGroup(String ageBand) {
        String ageGroup = "U";
        if ("40S-EARLY".equals(ageBand)) {
            ageGroup = "4";
        } else {

        }


        return ageGroup;
    }


    public boolean execute(ShardedJedisPool shardedJedisPool, ShardedJedis shardedJedis, Tuple tuple) throws Exception {

        String GLOBAL_KEY = String.format("GLOBAL:%s", tuple.getStringByField("user.account_id"));

        Map<String, String> globalValues = new HashMap<String, String>();
        globalValues.put("gender", tuple.getStringByField("user.gender"));
        globalValues.put("agegrp", getAgeGroup(tuple.getStringByField("age_band")));
        shardedJedis.hmset(GLOBAL_KEY, globalValues);


        String APP_UID_KEY = String.format("%s:%s", tuple.getStringByField("app.client_id"), tuple.getStringByField("user.account_id"));
        Map<String, String> appVlaues = shardedJedis.hgetAll(APP_UID_KEY);

        //first,last,sum,count|,,,,
        String sessionAccFlat = "";
        if (appVlaues.containsKey("session.acc")) {
            String sessionAcc = appVlaues.get("session.acc");
            String[] sessionAccArr = sessionAcc.split("\\,");
            sessionAccFlat = sessionAccArr[0] + "," + tuple.getStringByField("SESSION.TS") + "," + (Long.valueOf(sessionAccArr[2]) + tuple.getLongByField("session.length")) + "," + (Long.valueOf(sessionAccArr[3]) + 1);
        } else {
            sessionAccFlat = tuple.getStringByField("SESSION.TS") + "," + tuple.getStringByField("SESSION.TS") + "," + tuple.getStringByField("session.length") + ",1";
        }
        appVlaues.put("session.acc", sessionAccFlat);


        //20150701,sum.count
        String sessionHistoryFlat = "";
        if (appVlaues.containsKey("session.history")) {
            String sessionHistory = appVlaues.get("session.history");
            int startIndex = sessionHistory.indexOf(tuple.getStringByField("SESSION.TS"));
            if (startIndex < 0) {
                sessionHistoryFlat = tuple.getStringByField("SESSION.TS") + "," + tuple.getStringByField("session.length") + ",1|" + sessionHistory;
                sessionHistoryFlat = sessionHistoryFlat.substring(0, sessionHistoryFlat.length());
            } else {
                String matchHistoryFlat = "";
                int endIndex = sessionHistory.indexOf("|", startIndex);
                if (endIndex < 0) {
                    matchHistoryFlat = sessionHistory;
                } else {
                    matchHistoryFlat = sessionHistory.substring(startIndex, endIndex);
                }

                String[] matchHistoryArr = matchHistoryFlat.split("\\,");
                Long sum = Long.valueOf(matchHistoryArr[1]) + tuple.getLongByField("session.length");
                Long count = Long.valueOf(matchHistoryArr[2]) + 1;
                sessionHistoryFlat = sessionHistory.replace(matchHistoryFlat, matchHistoryArr[0] + "," + sum + "," + count);
            }
        } else {
            sessionHistoryFlat = tuple.getStringByField("SESSION.TS") + "," + tuple.getStringByField("session.length") + ",1";
        }
        appVlaues.put("session.history", sessionHistoryFlat);



        System.out.println("================== GmpRedisLoader =========================");
        shardedJedisPool.returnResource(shardedJedis);
        return true;
    }
}
