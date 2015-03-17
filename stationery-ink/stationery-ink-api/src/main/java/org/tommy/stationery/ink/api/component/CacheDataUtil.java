package org.tommy.stationery.ink.api.component;

import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CacheDataUtil {
	private static final Logger logger = LoggerFactory.getLogger(CacheDataUtil.class);

	private static String PREFIX = "INK_API_V2";
	public static int EXPIRE_SECONDS = 10; //10sec

    private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	ShardedJedisPool shardedJedisPool;

	public static List<JedisShardInfo> generateShardInfo(String hosts, String password, int timeout) {
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		for (String hostname : hosts.split(",")) {
			int port = hostname.indexOf(":") == -1 ? 6379 : Integer.parseInt(hostname.split(":")[1]);
			String host = hostname.indexOf(":") == -1 ? hostname : hostname.split(":")[0];

			JedisShardInfo si = new JedisShardInfo(host, port);
			si.setPassword(password);
			si.setTimeout(timeout);
			shards.add(si);
		}
		return shards;
	}

	public String generateKey(String zlass, String method, Object[] params) {
		String key = PREFIX;
		if (params == null) {
			key = zlass + "_" + method + "_";
		} else {

			String _params = "";
			for (int i=0;i<params.length;i++) {
                _params += params[i].toString();

			}
			key = zlass + "_" + method + "_" + _params;
		}

		return DigestUtils.md5Hex(key);
	}

	public boolean exist(String key) {
		if (key == null) {
			return false;
		}
		ShardedJedis shardedJedis = null;

		try {
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.exists(key);
		} catch (JedisConnectionException ex) {
			shardedJedisPool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			logger.error("CacheDataUtil:get:key:" + key + ":" + ex.getMessage());
		} catch (Exception ex) {
			logger.error("CacheDataUtil:exist:key:" + key + ":" + ex.getMessage());
		} finally {
			if (shardedJedis != null) {
				shardedJedisPool.returnResource(shardedJedis);
			}
		}
		return false;
	}

    public Object getObject(String key) throws IOException {
        return objectMapper.readValue(get(key), new TypeReference<Object>() {
        });
    }

	public String get(String key) {
		if (key == null) {
			return new String();
		}
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis.get(key);
		} catch (JedisConnectionException ex) {
			shardedJedisPool.returnBrokenResource(shardedJedis);
			shardedJedis = null;
			logger.error("CacheDataUtil:get:key:" + key + ":" + ex.getMessage());
		} catch(Exception ex) {
			logger.error("CacheDataUtil:get:key:" + key + ":" + ex.getMessage());
		} finally {
			if (shardedJedis != null) {
				shardedJedisPool.returnResource(shardedJedis);
			}
		}
		return new String();
	}

    public void putObject(String key, Object val, int expireTime) throws IOException {
        put(key, objectMapper.writeValueAsString(val), expireTime);
    }

    public void put(String key, String val, int expireTime) {
        if (key == null || val == null) {
            return;
        }
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
            shardedJedis.set(key, val);
            shardedJedis.expire(key, expireTime);
        } catch (JedisConnectionException ex) {
            shardedJedisPool.returnBrokenResource(shardedJedis);
            shardedJedis = null;
            logger.error("CacheDataUtil:get:key:" + key + ":" + ex.getMessage());
        } catch(Exception ex) {
            logger.error("CacheDataUtil:put:key:" + key + ":" + ex.getMessage());
        } finally {
            if (shardedJedis != null) {
                shardedJedisPool.returnResource(shardedJedis);
            }
        }
    }

	public void put(String key, String val) {
        put(key, val, EXPIRE_SECONDS);
	}
}
