package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.engine.utils.TupleUtil;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

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


    public synchronized boolean execute(ShardedJedisPool shardedJedisPool, Tuple tuple) throws Exception {
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
                shardedJedis.expire(GLOBAL_KEY, 2592000);
            }

            String APP_UID_KEY = String.format("%s:%s:%s", TupleUtil.getStringValue(tuple, "app.client_id"), TupleUtil.getStringValue(tuple, "user.account_id"), version);
            switch(eventName) {
                case "session.start": {
                    String sessionHistoryReal = shardedJedis.hget(APP_UID_KEY, "session.history.real");
                    String historyFlat = gmpRedisSerdeHelper.genHistoryFlat(sessionHistoryReal, tuple, "session.ts", "session_length", "session_cnt", 7);
                    if (historyFlat != null) {
                        shardedJedis.hset(APP_UID_KEY, "session.history.real", historyFlat);
                        shardedJedis.expire(APP_UID_KEY, 2592000);
                        LOG.info("REDIS : session.history.real : " + APP_UID_KEY + " : " + historyFlat);
                        LOG.info("event.name : session.start : REDIS CACHED");
                    }
                }
                break;
                case "iap": {
                    LOG.info("event.name : iap : REDIS CACHE..");
                    String purchaseHistoryReal = shardedJedis.hget(APP_UID_KEY, "purchase.history.real");
                    String historyFlat = gmpRedisSerdeHelper.genHistoryFlat(purchaseHistoryReal, tuple, "purchase.ts", "purchase_length", "purchase_cnt", 7);
                    if (historyFlat != null) {
                        shardedJedis.hset(APP_UID_KEY, "purchase.history.real", historyFlat);
                        shardedJedis.expire(APP_UID_KEY, 2592000);
                        LOG.info("REDIS : purchase.history.real : " + APP_UID_KEY + " : " + historyFlat);
                        LOG.info("event.name : purchase.start : REDIS CACHED");
                    }
                }
                break;
            }
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
        } catch (Exception ex) {
            LOG.info("GmpRedisSumLoader ERROR : " + ex.getMessage());
        } finally {
            if (shardedJedis != null)
            shardedJedisPool.returnResource(shardedJedis);
        }
        return true;
    }
}
