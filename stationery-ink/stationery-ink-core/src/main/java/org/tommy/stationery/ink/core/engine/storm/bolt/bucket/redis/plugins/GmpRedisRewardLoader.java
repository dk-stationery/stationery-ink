package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis.plugins;

import backtype.storm.tuple.Tuple;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.engine.utils.RedisHelper;
import org.tommy.stationery.ink.core.engine.utils.RedisSerdeHelper;
import redis.clients.jedis.ShardedJedisPool;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kun7788 on 15. 8. 10..
 */
public class GmpRedisRewardLoader implements RedisPlugin  {
    private static final Logger LOG = LoggerFactory.getLogger(GmpRedisRewardLoader.class);

    private static String REWARD_CONDITION_GETTING_QUERY = "select * from ink_auth where authuser = ?";
    private RedisSerdeHelper redisSerdeHelper = null;
    private ComboPooledDataSource dataSource = null;
    private ScriptEngine engine;
    private RedisHelper redisHelper;
    private static int CACHE_EXPIRE_TIME = 2592000;

    private ResultSet getRewardConditionData(String bindArg) throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REWARD_CONDITION_GETTING_QUERY);
            preparedStatement.setString(1, bindArg);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean checkRewardCondition(String conditionExp, Bindings bindings) {
        try {
            boolean ret = (boolean) engine.eval(conditionExp, bindings);
            return ret;
        } catch (ScriptException e) {
        }
        return false;
    }

    @Override
    public void prepare(ShardedJedisPool shardedJedisPool) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        engine = mgr.getEngineByName("JavaScript");

        redisHelper = new RedisHelper(shardedJedisPool);
        redisSerdeHelper = new RedisSerdeHelper();

        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
        }
        dataSource.setJdbcUrl("jdbc:postgresql://172.16.215.239:5432/gmp");
        dataSource.setUser("gmp");
        dataSource.setPassword("gmp!1");
        dataSource.setInitialPoolSize(1);
        dataSource.setMaxPoolSize(20);
        dataSource.setMinPoolSize(10);
    }

    @Override
    public synchronized boolean execute(Tuple tuple) throws Exception {
        try {
            String eventName = tuple.getStringByField("event.name");
            String REDIS_CACHE_VERSION = tuple.getStringByField("REDIS_CACHE_VERSION");
            String CALLBACK_SERVER_URL = tuple.getStringByField("CALLBACK_SERVER_URL");
            String REWARD_CACHE_KEY = tuple.getStringByField("REDIS_CACHE_VERSION");
            String REWARD_CONDITION_CACHE_KEY = tuple.getStringByField("REWARD_CONDITION_CACHE_KEY");
            String AUTHUSER = "ADMIN";
            //String askRewardType = tuple.getStringByField("ask.reward_type");

            //get Reward condition.
            String conditionValue = "";
            if (!redisHelper.EXIST(REWARD_CONDITION_CACHE_KEY)) {
                ResultSet resultSet = getRewardConditionData(AUTHUSER);
                if (resultSet != null) {
                    while (resultSet.next()) {
                        conditionValue = resultSet.getString("authuser");
                        System.out.println(conditionValue);
                    }
                    conditionValue = resultSet.getString("authuser");
                    LOG.info("===== GmpRedisRewardLoader execute == " + conditionValue);

                    //TODO -- get conditionValue.
                    //redisHelper.SET(REWARD_CONDITION_CACHE_KEY, conditionValue, CACHE_EXPIRE_TIME);
                }
            } else {
                conditionValue = redisHelper.GET(REWARD_CONDITION_CACHE_KEY);
            }

            switch(eventName) {
                case "campaign.click":
                case "campaign.vimp":
                    if (!redisHelper.EXIST(REWARD_CACHE_KEY)) {
                        redisHelper.SET(REWARD_CACHE_KEY, eventName, CACHE_EXPIRE_TIME);
                    }
                    break;
                case "app.install":
                case "conversion":
                    if (redisHelper.EXIST(REWARD_CACHE_KEY)) {
                        //reward callback
                        redisSerdeHelper.callbackHttp(CALLBACK_SERVER_URL);
                        //shardedJedis.del(REWARD_CACHE_KEY);
                    }
                    break;
            }


        } catch (Exception ex) {
            LOG.info("ERROR : " + ex.getMessage());
        }
        return true;
    }
}
