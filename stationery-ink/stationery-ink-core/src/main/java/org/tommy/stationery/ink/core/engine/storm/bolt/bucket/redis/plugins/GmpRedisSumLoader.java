package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.engine.utils.TupleUtil;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 4..
 */
public class GmpRedisSumLoader implements RedisPlugin {
    private static final Logger LOG = LoggerFactory.getLogger(GmpRedisSumLoader.class);
    GmpRedisSerdeHelper gmpRedisSerdeHelper;

    public void prepare() {
        gmpRedisSerdeHelper = new GmpRedisSerdeHelper();
    }


    public boolean execute(ShardedJedisPool shardedJedisPool, Tuple tuple) throws Exception {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = gmpRedisSerdeHelper.getJedisResource(shardedJedisPool);
            String eventName = tuple.getStringByField("event.name");

            String version = tuple.getStringByField("redis_cache_version");
            String GLOBAL_KEY = String.format("GLOBAL:%s:%s", TupleUtil.getStringValue(tuple, "user.account_id"), version);
            LOG.info("GmpRedisSumLoader GLOBAL_KEY : " + GLOBAL_KEY);
            Map<String, String> globalValues = new HashMap<String, String>();
            if (TupleUtil.getStringValue(tuple, "user.gender") != null || TupleUtil.getStringValue(tuple, "age_band") != null) {
                globalValues.put("gender", TupleUtil.getStringValue(tuple, "user.gender") == null ? "U" : TupleUtil.getStringValue(tuple, "user.gender"));
                globalValues.put("agegrp", gmpRedisSerdeHelper.getAgeGroup(TupleUtil.getStringValue(tuple, "age_band")));
                shardedJedis.hmset(GLOBAL_KEY, globalValues);
            }

            String APP_UID_KEY = String.format("%s:%s:%s", TupleUtil.getStringValue(tuple, "app.client_id"), TupleUtil.getStringValue(tuple, "user.account_id"), version);
            Map<String, String> appVlaues = shardedJedis.hgetAll(APP_UID_KEY);

            switch(eventName) {
                case "session.start": {
                    LOG.info("event.name : session.start : CACHE..");

                    String aceFlat = gmpRedisSerdeHelper.genAccFlat(appVlaues, "session.acc", tuple, "session.ts", "session_length", "session_cnt");
                    if (aceFlat != null) {
                        appVlaues.put("session.acc", aceFlat);
                    }
                    LOG.info("REDIS : session.acc : " + APP_UID_KEY + " : " + aceFlat);
                    String historyFlat = gmpRedisSerdeHelper.genHistoryFlat(appVlaues, "session.history", tuple, "session.ts", "session_length", "session_cnt", 7);
                    if (historyFlat != null) {
                        appVlaues.put("session.history", historyFlat);
                    }
                    LOG.info("REDIS : session.history : " + APP_UID_KEY + " : " + historyFlat);
                }
                break;
                case "iap": {
                    LOG.info("event.name : iap : REDIS CACHE..");
                    String aceFlat = gmpRedisSerdeHelper.genAccFlat(appVlaues, "purchase.acc", tuple, "purchase.ts", "purchase_length", "purchase_cnt");
                    if (aceFlat != null) {
                        appVlaues.put("purchase.acc", aceFlat);
                    }
                    LOG.info("REDIS : purchase.acc : " + APP_UID_KEY + " : " + aceFlat);
                    String historyFlat = gmpRedisSerdeHelper.genHistoryFlat(appVlaues, "purchase.history", tuple, "purchase.ts", "purchase_length", "purchase_cnt", 7);
                    if (historyFlat != null) {
                        appVlaues.put("purchase.history", historyFlat);
                    }
                    LOG.info("REDIS : purchase.history : " + APP_UID_KEY + " : " + historyFlat);
                }
                break;
            }

            shardedJedis.hmset(APP_UID_KEY, appVlaues);
            LOG.info("GmpRedisSumLoader appVlaues : " + appVlaues);
            LOG.info("GmpRedisSumLoader APP_UID_KEY : " + APP_UID_KEY);
        } catch(Exception ex) {
            LOG.info("GmpRedisSumLoader ERROR : " + ex.getMessage());
        } finally {
            if (shardedJedis != null)
            shardedJedisPool.returnResource(shardedJedis);
        }
        return true;
    }
}
