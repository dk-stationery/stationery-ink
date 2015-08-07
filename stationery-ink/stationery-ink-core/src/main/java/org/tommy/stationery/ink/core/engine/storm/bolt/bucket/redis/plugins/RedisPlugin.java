package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by kun7788 on 15. 8. 4..
 */
public interface RedisPlugin {
    public void prepare();
    public boolean execute(ShardedJedisPool shardedJedisPool, ShardedJedis shardedJedis , Tuple tuple)  throws Exception;
}
