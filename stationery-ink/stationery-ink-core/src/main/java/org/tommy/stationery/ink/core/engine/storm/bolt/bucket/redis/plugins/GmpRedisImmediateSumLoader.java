package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.get.GetField;
import org.tommy.stationery.ink.core.engine.utils.RedisHelper;
import org.tommy.stationery.ink.core.engine.utils.RedisSerdeHelper;
import redis.clients.jedis.ShardedJedisPool;

import java.util.*;

/**
 * Created by kun7788 on 15. 8. 17..
 */
public class GmpRedisImmediateSumLoader implements RedisPlugin  {

    Client client;
    private RedisSerdeHelper redisSerdeHelper;
    private RedisHelper redisHelper;
    private static int GLOBAL_CACHE_EXPIRE_TIME = 8640000;
    private static int APP_CACHE_EXPIRE_TIME = 2592000;
    private static String APP_INDEX_NAME = "test-apps";
    private static String APP_INDEX_TYPE = "user";
    private static String CTX_SOURCE = "ctx._source.";
    private ObjectMapper objectMapper = new ObjectMapper();


    private static class Event {
        public String name;
        public Map<String, Object> ask;
        public Map<String, Object> user_status;
        public Map<String, Object> iap;
        public Map<String, Object> profile;
    }

    private static class Log {
        public String user_key;
        public String ts;
        public String dt;
        public Map<String, String> device;
        public Map<String, String> app;
        public Map<String, String> sdk;
        public Map<String, Object> session;
        public Event event;
    }

    private List<Long> genHistoricData(String user_key, String appKey, String dt, String targetFieldName, Integer targetFieldVal, boolean isCount) {
        Integer length = targetFieldVal;

        GetResponse response=client.prepareGet(APP_INDEX_NAME, APP_INDEX_TYPE, user_key).setFields(appKey + "." + targetFieldName).execute().actionGet();
        GetField field = response.getField(appKey + "." + targetFieldName);
        if (field != null) {
            List<Long> counts = (List<Long>)field.getValue();
            NavigableMap<Long, Long> map = new TreeMap<>();

            if (counts != null) {
                for (Long count : counts) {
                    String tc = String.format("%15s", count.toString().substring(4, 8));
                    map.put(Long.valueOf(tc), count);
                }

                String tc = String.format("%15s", dt.substring(4, 8));
                if (map.containsKey(Long.valueOf(tc))) {
                    Long count = map.get(Long.valueOf(tc));
                    if (isCount == true) {
                        map.put(Long.valueOf(tc), count + 1);
                    } else {
                        map.put(Long.valueOf(tc), count + length);
                    }
                } else {
                    if (isCount == true) {
                        map.put(Long.valueOf(tc), Long.valueOf(tc) + 1);
                    } else {
                        map.put(Long.valueOf(tc), Long.valueOf(tc) + length);
                    }
                }


            } else {
                String tc = String.format("%15s", dt.substring(4, 8));
                Long c = 0l;
                if (isCount == true) {
                    c = Long.valueOf(tc) + 1;
                } else {
                    c = Long.valueOf(tc) + length;
                }
                map.put(c, Long.valueOf(tc));
            }

            List<Long> historys = Arrays.asList((Long[]) map.values().toArray());
            return historys;
        }
        return null;
    }

    @Override
    public void prepare(ShardedJedisPool shardedJedisPool) {
        redisSerdeHelper = new RedisSerdeHelper();
        redisHelper = new RedisHelper(shardedJedisPool);
    }

    @Override
    public synchronized boolean execute(Tuple tuple) throws Exception {
        String payload = tuple.getStringByField("_PAYLOAD_");
        Log log = objectMapper.readValue(payload, new TypeReference<Log>() {
        });

        /* if (appKey != null && "session.start".equals(log.event)) {
            Integer length = Integer.valueOf(log.session.get("length").toString());

            if (length != null) {
                bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_TYPE, APP_INDEX_TYPE, log.user_key)
                        .addScriptParam("acc_sum", length)
                        .setScript(CTX_SOURCE + appKey + ".session.acc_sum+=" + CTX_SOURCE + appKey + ".session.acc_sum + " + length + ";").setUpsert(appKey + ".session.acc_sum", length));

                bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_TYPE, APP_INDEX_TYPE, log.user_key)
                        .setScript(CTX_SOURCE + appKey + ".session.acc_count+=1;").setUpsert(appKey + ".session.acc_count", 1));
            }


            List<Long> countHistorys = genHistoricData(log.user_key, appKey, dt, "session.count", length, true);
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_TYPE, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("count", countHistorys)
                    .setScript(CTX_SOURCE + appKey + ".session.count=count;").setUpsert(appKey + ".session.count", countHistorys));

            List<Long> sumHistorys = genHistoricData(log.user_key, appKey, dt, "session.sum", length, false);
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_TYPE, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("sum", sumHistorys)
                    .setScript(CTX_SOURCE + appKey + ".session.sum=sum;").setUpsert(appKey + ".session.sum", sumHistorys));
        }


        if (appKey != null && "iap".equals(log.event)) {
            Integer length = Integer.valueOf(log.event.iap.get("to_krw").toString());

            if (length != null) {
                bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_TYPE,APP_INDEX_TYPE, log.user_key)
                        .addScriptParam("acc_sum", length)
                        .setScript(CTX_SOURCE + appKey + ".purchase.acc_sum+=ctx._source." + appKey + ".purchase.acc_sum + " + length + ";").setUpsert(appKey + ".purchase.acc_sum", length));

                bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_TYPE, APP_INDEX_TYPE, log.user_key)
                        .setScript(CTX_SOURCE + appKey + ".purchase.acc_count+=1;").setUpsert(appKey + ".purchase.acc_count", 1));
            }


            List<Long> countHistorys = genHistoricData(log.user_key, appKey, dt, "purchase.count", length, true);
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_TYPE, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("count", countHistorys)
                    .setScript(CTX_SOURCE + appKey + ".purchase.count=count;").setUpsert(appKey + ".purchase.count", countHistorys));

            List<Long> sumHistorys = genHistoricData(log.user_key, appKey, dt, "purchase.sum", length, false);
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_TYPE, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("sum", sumHistorys)
                    .setScript(CTX_SOURCE + appKey + ".purchase.sum=sum;").setUpsert(appKey + ".purchase.sum", sumHistorys));
        }*/
        return false;
    }
}
