package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Tuple;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 4..
 */
public interface RedisPlugin {
    public void prepare(ShardedJedisPool shardedJedisPool, Map stormConf, TopologyContext topologyContext);
    public boolean execute(Tuple tuple)  throws Exception;
}
