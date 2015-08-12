package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.engine.utils.RedisHelper;
import org.tommy.stationery.ink.core.engine.utils.RedisSerdeHelper;
import org.tommy.stationery.ink.core.engine.utils.TupleUtil;
import redis.clients.jedis.ShardedJedisPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 4..
 */
public class GmpRedisSumLoader implements RedisPlugin {
    private static final Logger LOG = LoggerFactory.getLogger(GmpRedisSumLoader.class);
    private RedisSerdeHelper redisSerdeHelper;
    private RedisHelper redisHelper;
    private static int CACHE_EXPIRE_TIME = 2592000;

    public void prepare(ShardedJedisPool shardedJedisPool) {
        redisSerdeHelper = new RedisSerdeHelper();
        redisHelper = new RedisHelper(shardedJedisPool);
    }

    public String genGlobalCacheKey(Tuple tuple) {
        String globalCacheKey = String.format("GLOBAL:%s:%s", TupleUtil.getStringValue(tuple, "user.account_id"), tuple.getStringByField("redis_cache_version"));
        LOG.info("* GLOBAL_CACHE_KEY : " + globalCacheKey);
        return globalCacheKey;
    }

    public String genAppUidCacheKey(Tuple tuple) {
        String appUidCacheKey = String.format("%s:%s:%s", TupleUtil.getStringValue(tuple, "app.client_id"), TupleUtil.getStringValue(tuple, "user.account_id"), tuple.getStringByField("redis_cache_version"));
        LOG.info("* APP_UID_CACHE_KEY : " + appUidCacheKey);
        return appUidCacheKey;
    }

    public synchronized boolean execute(Tuple tuple) throws Exception {
        try {
            String eventName = tuple.getStringByField("event.name");

            Map<String, String> globalValues = new HashMap<String, String>();
            if (TupleUtil.getStringValue(tuple, "user.gender") != null || TupleUtil.getStringValue(tuple, "age_band") != null) {
                globalValues.put("gender", TupleUtil.getStringValue(tuple, "user.gender") == null ? "U" : TupleUtil.getStringValue(tuple, "user.gender"));
                globalValues.put("agegrp", redisSerdeHelper.getAgeGroup(TupleUtil.getStringValue(tuple, "age_band")));

                String GLOBAL_CACHE_KEY = genGlobalCacheKey(tuple);
                redisHelper.HMSET(GLOBAL_CACHE_KEY, globalValues, CACHE_EXPIRE_TIME);
            }


            switch(eventName) {
                case "session.start": {
                    String APP_UID_CACHE_KEY = genAppUidCacheKey(tuple);
                    String sessionHistoryReal = redisHelper.HGET(APP_UID_CACHE_KEY, "session.history.real");
                    String historyFlat = redisSerdeHelper.genHistoryFlat(sessionHistoryReal, tuple, "session.ts", "session_length", "session_cnt", 7);
                    if (historyFlat != null) {
                        redisHelper.HSET(APP_UID_CACHE_KEY, "session.history.real", historyFlat, CACHE_EXPIRE_TIME);
                    }
                }
                break;
                case "iap": {
                    LOG.info("event.name : iap : REDIS CACHE..");
                    String APP_UID_CACHE_KEY = genAppUidCacheKey(tuple);
                    String purchaseHistoryReal = redisHelper.HGET(APP_UID_CACHE_KEY, "purchase.history.real");
                    String historyFlat = redisSerdeHelper.genHistoryFlat(purchaseHistoryReal, tuple, "purchase.ts", "purchase_length", "purchase_cnt", 7);
                    if (historyFlat != null) {
                        redisHelper.HSET(APP_UID_CACHE_KEY, "purchase.history.real", historyFlat, CACHE_EXPIRE_TIME);
                    }
                }
                break;
            }
        } catch (Exception ex) {
            LOG.info("ERROR : " + ex.getMessage());
        }
        return true;
    }
}
