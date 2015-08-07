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
public class GmpRedisLoader implements RedisPlugin {

    private static final Logger LOG = LoggerFactory.getLogger(GmpRedisLoader.class);
    GmpRedisSerdeHelper gmpRedisSerdeHelper;

    public void prepare() {
        gmpRedisSerdeHelper = new GmpRedisSerdeHelper();
    }


    public boolean execute(ShardedJedisPool shardedJedisPool, ShardedJedis shardedJedis, Tuple tuple) throws Exception {
        try {
            String GLOBAL_KEY = String.format("GLOBAL:%s", TupleUtil.getValue(tuple, "user.account_id"));
            LOG.info("GmpRedisLoader GLOBAL_KEY : " + GLOBAL_KEY);
            Map<String, String> globalValues = new HashMap<String, String>();
            if (TupleUtil.getValue(tuple, "user.gender") != null || TupleUtil.getValue(tuple, "age_band") != null) {
                globalValues.put("gender", TupleUtil.getValue(tuple, "user.gender") == null ? "U" : TupleUtil.getValue(tuple, "user.gender"));
                globalValues.put("agegrp", gmpRedisSerdeHelper.getAgeGroup(TupleUtil.getValue(tuple, "age_band")));
                shardedJedis.hmset(GLOBAL_KEY, globalValues);
            }


            String APP_UID_KEY = String.format("%s:%s:v1", TupleUtil.getValue(tuple, "app.client_id"), TupleUtil.getValue(tuple, "user.account_id"));
            Map<String, String> appVlaues = shardedJedis.hgetAll(APP_UID_KEY);

            if ("session.start".equals(tuple.getStringByField("event.name"))) {
                LOG.info("event.name : session.start : CACHE..");
                String aceFlat = gmpRedisSerdeHelper.genAccFlat(appVlaues, "session.acc", tuple, "session.ts", "session.length");
                if (aceFlat != null) {
                    appVlaues.put("session.acc", aceFlat);
                }
                String historyFlat = gmpRedisSerdeHelper.genHistoryFlat(appVlaues, "session.history", tuple, "session.ts", "session.length", 7);
                if (historyFlat != null) {
                    appVlaues.put("session.history", historyFlat);
                }
            }

            if ("iap".equals(tuple.getStringByField("event.name"))) {
                LOG.info("event.name : iap : REDIS CACHE..");
                String aceFlat = gmpRedisSerdeHelper.genAccFlat(appVlaues, "purchase.acc", tuple, "purchase.ts", "purchase.length");
                if (aceFlat != null) {
                    appVlaues.put("purchase.acc", aceFlat);
                }
                String historyFlat = gmpRedisSerdeHelper.genHistoryFlat(appVlaues, "purchase.history", tuple, "purchase.ts", "purchase.length", 7);
                if (historyFlat != null) {
                    appVlaues.put("purchase.history", historyFlat);
                }
            }
            shardedJedis.hmset(APP_UID_KEY, appVlaues);
            LOG.info("GmpRedisLoader APP_UID_KEY : " + APP_UID_KEY);
        } finally {
            if (shardedJedis != null)
            shardedJedisPool.returnResource(shardedJedis);
        }
        return true;
    }
}
