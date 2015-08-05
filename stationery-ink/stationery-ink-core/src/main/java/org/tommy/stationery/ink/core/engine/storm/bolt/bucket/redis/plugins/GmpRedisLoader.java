package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by kun7788 on 15. 8. 4..
 */
public class GmpRedisLoader implements RedisPlugin {
    public boolean execute(ShardedJedisPool shardedJedisPool, ShardedJedis shardedJedis, Tuple tuple) {
        System.out.println("================== GmpRedisLoader =========================");
        shardedJedisPool.returnResource(shardedJedis);
        return true;
    }
}
