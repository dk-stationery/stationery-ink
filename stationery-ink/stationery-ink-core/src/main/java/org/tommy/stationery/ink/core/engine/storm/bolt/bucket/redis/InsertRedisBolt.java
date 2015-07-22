package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.storm.bolt.GenericBoltUtils;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.IBucketBolt;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.ColumnDataTypeEnum;
import org.tommy.stationery.ink.enums.StatementTypeEnum;
import org.tommy.stationery.ink.util.serde.JsonSerde;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kun7788 on 15. 7. 21..
 */
public class InsertRedisBolt implements IRichBolt, IBucketBolt {

    public static enum RedisCommand {
        INSERT_HSET("INSERT_HSET"),
        UPDATE_HSET("UPDATE_HSET")
        ;
        private String name;

        public String getName() {
            return name;
        }
        private RedisCommand(String name) {
            this.name = name;
        }
    }

    private ShardedJedisPool shardedJedisPool;
    private static final Logger LOG = LoggerFactory.getLogger(InsertRedisBolt.class);
    private OutputCollector collector;
    private Source inkSource;
    private Stream inkStream;
    private InkConfig inkConfig;
    private String streamId;
    private List<String> previousEmitFileds;
    private BaseStatement statement;
    private JsonSerde jsonSerde;
    private List<BaseColumnDef> columns;

    private List<JedisShardInfo> generateShardInfo(String hosts, String password, int timeout) {
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

    private ShardedJedisPool shardedJedisPool() {
        List<JedisShardInfo> shards = generateShardInfo(
                "host"
                , "passwd"
                , 10000
        );
        GenericObjectPool.Config config = new GenericObjectPool.Config();
        config.whenExhaustedAction = GenericObjectPool.WHEN_EXHAUSTED_GROW;
        config.maxActive = 100;
        return new ShardedJedisPool(config, shards);
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
        this.columns = extractColumns();
        shardedJedisPool = shardedJedisPool();
    }

    private List<BaseColumnDef> extractColumns() {
        BaseTableDef tableDef = statement.getBindTables().get(0);
        String bindTableTag = "\\[" + tableDef.getName() + ":" + tableDef.getSource() + "\\]";

        String[] columnsArrys = null;
        String query = statement.getQuery();
        Pattern pattern = Pattern.compile(bindTableTag + "\\((.+?)\\)");
        Matcher matcher = pattern.matcher(query);
        while(matcher.find()) {
            columnsArrys = matcher.group(1).replace(" ", "").replace("'", "").split(",");
        }

        List<BaseColumnDef> columns = new ArrayList<BaseColumnDef>();
        for (String column : columnsArrys) {
            for (BaseColumnDef columnDef : inkStream.getStatement().getColumns()) {
                if (columnDef.getName().equals(column)) {
                    columns.add(columnDef);
                    break;
                }
            }
        }
        return columns;
    }

    @Override
    public void execute(Tuple tuple) {
        try {
            boolean ret = redisExecute(tuple);
            if (ret == false) {
                LOG.error("ERROR InsertRedisBolt : redisExecute : " + tuple.toString());
            }
        } finally {
            collector.ack(tuple);
        }
    }

    @Override
    public void cleanup() {
        if (shardedJedisPool != null) {
            shardedJedisPool.destroy();
            shardedJedisPool = null;
        }
    }

    private ShardedJedis getJedisResource() {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
        } catch (JedisConnectionException ex) {
            if (shardedJedis != null) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
                shardedJedis = shardedJedisPool.getResource();
            }
        } catch (Exception ex) {
            if (shardedJedisPool != null) {
                shardedJedisPool.returnResource(shardedJedis);
                shardedJedis = null;
            }
        }
        return shardedJedis;
    }
    @Override
    public void setting(String streamId, InkConfig inkConfig, List<String> previousEmitFileds, BaseStatement statement, Stream inkStream, Source inkSource) {
        this.streamId = streamId;
        this.inkConfig = inkConfig;
        this.previousEmitFileds = previousEmitFileds;
        this.statement = statement;
        this.inkStream = inkStream;
        this.inkSource = inkSource;
    }

    @Override
    public String generateQuery(Tuple input) {
        return null;
    }

    public boolean redisExecute(Tuple input) {
        String key = inkStream.getName();

        ShardedJedis shardedJedis = getJedisResource();
        if (shardedJedis == null) return false;

        StatementTypeEnum queryType = statement.getType();

        for (int i=0;i<columns.size();i++) {
            BaseColumnDef columnDef  = columns.get(i);
            String columnKey = columnDef.getName();
            if (StatementTypeEnum.INSERT.equals(queryType) || StatementTypeEnum.UPSERT.equals(queryType)) {
                shardedJedis.hset(key, columnKey, (String) input.getValue(i));
            } else if (StatementTypeEnum.UPDATE.equals(queryType)) {
                if (ColumnDataTypeEnum.DOUBLE.equals(columnDef.getType()) || ColumnDataTypeEnum.FLOAT.equals(columnDef.getType()) || ColumnDataTypeEnum.INTEGER.equals(columnDef.getType())) {
                    shardedJedis.hincrBy(key, columnKey, (Long)input.getValue(i));
                } else if (ColumnDataTypeEnum.OBJECT.equals(columnDef.getType()) || ColumnDataTypeEnum.STRING.equals(columnDef.getType())) {
                    shardedJedis.hset(key, columnKey, (String) input.getValue(i));
                } else {
                    continue;
                }
            } else if (StatementTypeEnum.DELETE.equals(queryType)) {
                shardedJedis.hdel(key, columnDef.getName());
            } else {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object settingCommunicator() throws PropertyVetoException {
        return null;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        GenericBoltUtils genericBoltUtils = new GenericBoltUtils();
        outputFieldsDeclarer.declareStream(streamId, genericBoltUtils.getDeclareOutputFields(previousEmitFileds, statement.getColumns()));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}