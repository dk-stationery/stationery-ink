package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis;

import org.apache.commons.pool.impl.GenericObjectPool;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.*;

/**
 * Created by kun7788 on 15. 8. 13..
 */
public class Test1 {
    private static Map<String, Integer> appInstalledIndexs = new HashMap<String, Integer>();

    public static List<JedisShardInfo> generateShardInfo(String hosts, String password, int timeout) {
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        for (String hostname : hosts.split(",")) {
            int port = hostname.indexOf(":") == -1 ? 6379 : Integer.parseInt(hostname.split(":")[1]);
            String host = hostname.indexOf(":") == -1 ? hostname : hostname.split(":")[0];

            System.out.println(host + " : " + port);
            JedisShardInfo si = new JedisShardInfo(host, port);
            si.setTimeout(timeout);
            shards.add(si);
        }
        return shards;
    }


    public static void main(String[] args) {
        List<JedisShardInfo> shards = generateShardInfo(
                "puma047.dakao.io:6379"
                , null
                , 10000
        );
        GenericObjectPool.Config config = new GenericObjectPool.Config();
        config.whenExhaustedAction = GenericObjectPool.WHEN_EXHAUSTED_GROW;
        config.maxActive = 20;
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(config, shards);

        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        System.out.println(shardedJedis.hgetAll("appkey_aa3:g1:v61"));
    }
}
