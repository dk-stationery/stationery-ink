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
    private static int GLOBAL_CACHE_EXPIRE_TIME = 8640000;
    private static int APP_CACHE_EXPIRE_TIME = 2592000;

    public void prepare(ShardedJedisPool shardedJedisPool) {
        redisSerdeHelper = new RedisSerdeHelper();
        redisHelper = new RedisHelper(shardedJedisPool);
    }

    public String genGlobalCacheKey(Tuple tuple) {
        String globalCacheKey = String.format("GLOBAL:%s:%s", TupleUtil.getStringValue(tuple, "uid"), tuple.getStringByField("redis_cache_version"));
        LOG.info("* GLOBAL_CACHE_KEY : " + globalCacheKey);
        return globalCacheKey;
    }

    public String genAppUidCacheKey(Tuple tuple) {
        String appUidCacheKey = String.format("%s:%s:%s", TupleUtil.getStringValue(tuple, "app.id"), TupleUtil.getStringValue(tuple, "uid"), tuple.getStringByField("redis_cache_version"));
        LOG.info("* APP_UID_CACHE_KEY : " + appUidCacheKey);
        return appUidCacheKey;
    }

    public synchronized boolean execute(Tuple tuple) throws Exception {
        String eventName = tuple.getStringByField("event.name");

        try {
            Map<String, String> globalValues = new HashMap<String, String>();
            String GLOBAL_CACHE_KEY = genGlobalCacheKey(tuple);

            //profile.sex
            if ("profile".equals(eventName) && TupleUtil.getStringValue(tuple, "event.profile.gender") != null) {
                String profileSex = (TupleUtil.getStringValue(tuple, "event.profile.gender") == null ? "U" : TupleUtil.getStringValue(tuple, "event.profile.gender"));
                redisHelper.HSET(GLOBAL_CACHE_KEY, "profile.sex", profileSex, GLOBAL_CACHE_EXPIRE_TIME);
            }

            //profile.agegrp
            if ("profile".equals(eventName) && TupleUtil.getStringValue(tuple, "event.profile.agegrp") != null) {
                redisHelper.HSET(GLOBAL_CACHE_KEY, "profile.agegrp", TupleUtil.getStringValue(tuple, "event.profile.agegrp"), GLOBAL_CACHE_EXPIRE_TIME);
            }

            //app.installed
            if ("app.install".equals(eventName)) {
                String appInstalledReal = redisHelper.HGET(GLOBAL_CACHE_KEY, "app.installed");
                String appInstallFlat = redisSerdeHelper.genClientIdAndDtHistoryFlat(appInstalledReal, tuple, "dt", "app.client_id", 100);
                if (appInstallFlat != null) {
                    redisHelper.HSET(GLOBAL_CACHE_KEY, "app.installed", appInstallFlat, GLOBAL_CACHE_EXPIRE_TIME);
                }
            }

            //app.active
            String appActiveReal = redisHelper.HGET(GLOBAL_CACHE_KEY, "app.active");
            String appActiveFlat = redisSerdeHelper.genClientIdAndDtHistoryFlat(appActiveReal, tuple, "dt", "app.client_id", 100);
            if (appActiveFlat != null) {
                redisHelper.HSET(GLOBAL_CACHE_KEY, "app.active", appActiveFlat, GLOBAL_CACHE_EXPIRE_TIME);
            }
        } catch (Exception ex) {
            LOG.info("GLOBAL_CACHE_KEY ERROR : " + ex.getMessage());
        }

        try {
            switch(eventName) {
                case "session.start": {
                    String APP_UID_CACHE_KEY = genAppUidCacheKey(tuple);
                    String sessionHistoryReal = redisHelper.HGET(APP_UID_CACHE_KEY, "session.history.real");
                    String historyFlat = redisSerdeHelper.genHistoryFlat(sessionHistoryReal, tuple, "dt", "session_sum", "session_cnt", 7);
                    if (historyFlat != null) {
                        redisHelper.HSET(APP_UID_CACHE_KEY, "session.history.real", historyFlat, APP_CACHE_EXPIRE_TIME);
                    }
                }
                break;
                case "iap": {
                    String APP_UID_CACHE_KEY = genAppUidCacheKey(tuple);
                    String purchaseHistoryReal = redisHelper.HGET(APP_UID_CACHE_KEY, "purchase.history.real");
                    String historyFlat = redisSerdeHelper.genHistoryFlat(purchaseHistoryReal, tuple, "dt", "purchase_sum", "purchase_cnt", 7);
                    if (historyFlat != null) {
                        redisHelper.HSET(APP_UID_CACHE_KEY, "purchase.history.real", historyFlat, APP_CACHE_EXPIRE_TIME);
                    }
                }
                break;
            }
        } catch (Exception ex) {
            LOG.info("APP_UID_CACHE_KEY ERROR : " + ex.getMessage());
        }

        Map<String, String> val = redisHelper.HALLGET(genAppUidCacheKey(tuple));
        LOG.info("REDIS GLOBAL_CACHE_KEY =========> " + val);
        return true;
    }
}
