package org.tommy.stationery.ink.core.engine.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.List;
import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 12..
 */
public class RedisHelper {
    private static final Logger LOG = LoggerFactory.getLogger(RedisHelper.class);
    private ShardedJedisPool shardedJedisPool;

    public RedisHelper(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }

    public ShardedJedis getJedisResource() {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
                shardedJedis = shardedJedisPool.getResource();
            }
        }  catch (Exception ex) {
            if (shardedJedisPool != null) {
                shardedJedisPool.returnResource(shardedJedis);
            }
        }
        return shardedJedis;
    }

    public void SET(String key, String value, int expireTime) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = getJedisResource();
            shardedJedis.set(key, value);
            shardedJedis.expire(key, expireTime);

            LOG.info("* key : " + key + " , value : " + value + " = CACHED(SET)");
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
        } finally {
            if (shardedJedis != null)
                shardedJedisPool.returnResource(shardedJedis);
        }
    }

    public boolean EXIST(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = getJedisResource();
            return shardedJedis.exists(key);
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
        } finally {
            if (shardedJedis != null)
                shardedJedisPool.returnResource(shardedJedis);
        }
        return false;
    }

    public String GET(String key) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = getJedisResource();
            return shardedJedis.get(key);
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
        } finally {
            if (shardedJedis != null)
                shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }

    public Long HSET(String key, String field, String value, int expireTime) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = getJedisResource();
            Long ret = shardedJedis.hset(key, field, value);
            shardedJedis.expire(key, expireTime);
            LOG.info("* key : " + key + " ,field" + field + " , val : " + value + " = CACHED(HSET)");
            return ret;
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
        } finally {
            if (shardedJedis != null)
                shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }

    public String HGET(String key, String field) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = getJedisResource();
            return shardedJedis.hget(key, field);
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
        } finally {
            if (shardedJedis != null)
                shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }

    public String HMSET(String key, Map<String, String> value, int expireTime) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = getJedisResource();
            String ret = shardedJedis.hmset(key, value);
            shardedJedis.expire(key, expireTime);
            LOG.info("* key : " + key + " , val : " + value + " = CACHED(HMSET)");
            return ret;
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
        } finally {
            if (shardedJedis != null)
                shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }

    public List<String> HMGET(String key, String field) {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = getJedisResource();
            return shardedJedis.hmget(key, field);
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = null;
            }
        } finally {
            if (shardedJedis != null)
                shardedJedisPool.returnResource(shardedJedis);
        }
        return null;
    }
}
