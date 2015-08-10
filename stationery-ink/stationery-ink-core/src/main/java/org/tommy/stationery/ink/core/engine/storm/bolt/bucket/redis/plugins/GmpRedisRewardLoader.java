package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.engine.utils.TupleUtil;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by kun7788 on 15. 8. 10..
 */
public class GmpRedisRewardLoader implements RedisPlugin  {
    private static final Logger LOG = LoggerFactory.getLogger(GmpRedisRewardLoader.class);
    GmpRedisSerdeHelper gmpRedisSerdeHelper;

    private void callbackHttp(String callBackProxyServerUrl) {
        StringBuilder lines = new StringBuilder();
        // HttpClient 생성
        HttpClient httpclient = new DefaultHttpClient();
        try {
            // HttpGet생성
            HttpGet httpget = new HttpGet(callBackProxyServerUrl);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    lines.append(line);
                }
            }
            httpget.abort();
            httpclient.getConnectionManager().shutdown();

            LOG.info("callback result : " + callBackProxyServerUrl + " : "+ lines.toString());
        } catch (Exception ex) {

        }
    }

    @Override
    public void prepare() {
        gmpRedisSerdeHelper = new GmpRedisSerdeHelper();
    }

    @Override
    public boolean execute(ShardedJedisPool shardedJedisPool, ShardedJedis shardedJedis, Tuple tuple) throws Exception {
        try {
            String eventName = tuple.getStringByField("event.name");
            String version = tuple.getStringByField("redis_cache_version");
            String callBackProxyServerUrl = tuple.getStringByField("callback_proxy_server_url");
            String CACHE_KEY = String.format("%s:%s:%s", TupleUtil.getStringValue(tuple, "app.client_id"), TupleUtil.getStringValue(tuple, "user.account_id"), version);

            switch(eventName) {
                case "campaign.click":
                case "campaign.vimp":
                    if (!shardedJedis.exists(CACHE_KEY)) {
                        shardedJedis.set(CACHE_KEY, eventName);
                    }
                    break;
                case "app.install":
                case "conversion":
                    if (shardedJedis.exists(CACHE_KEY)) {
                        //reward callback
                        callbackHttp(callBackProxyServerUrl);
                        shardedJedis.del(CACHE_KEY);
                    }
                    break;
            }

        } finally {
            if (shardedJedis != null)
                shardedJedisPool.returnResource(shardedJedis);
        }
        return true;
    }
}
