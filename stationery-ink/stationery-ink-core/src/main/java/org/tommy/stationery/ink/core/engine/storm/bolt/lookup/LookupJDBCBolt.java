package org.tommy.stationery.ink.core.engine.storm.bolt.lookup;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.storm.bolt.GenericBoltUtils;
import org.tommy.stationery.ink.core.util.MetaFinderUtil;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.MetaFieldEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LookupJDBCBolt extends GenericBoltUtils implements IRichBolt, ILookupBolt {

    private static final long serialVersionUID = -5887832622734426744L;

    public static Logger logger = LoggerFactory.getLogger(LookupJDBCBolt.class);

    private OutputCollector collector;
    private String streamId;
    private BaseStatement baseStatement = null;
    private Source inkSource;
    private Stream inkStream;
    private InkConfig inkConfig;
    private String query;

    private ComboPooledDataSource dataSource;
    private Connection connection;
    private Statement statement = null;
    private List<String> previousEmitFileds;

    @Override
    public void setting(String streamId, InkConfig inkConfig, List<String> previousEmitFileds,  BaseStatement baseStatement, Stream inkStream, Source inkSource) {
        this.streamId = streamId;
        this.baseStatement = baseStatement;
        this.inkStream = inkStream;
        this.inkSource = inkSource;
        this.inkConfig = inkConfig;
        this.previousEmitFileds = previousEmitFileds;

        String topic = MetaFinderUtil.findMeta(inkStream.getStatement().getMetas(), MetaFieldEnum.TOPIC).getValue();
        this.query = generatePreQueryForBindTable(topic, baseStatement, inkStream);
    }

    @Override
    public String generateQuery(Tuple input) {
        return generateQueryForBindColumns(query, baseStatement, input);
    }

    @Override
    public Object settingCommunicator() throws PropertyVetoException {
        return getJDBCCommunication(inkConfig, inkSource);
    }

    @Override
    public void prepare(Map stormConf, TopologyContext context,
                        OutputCollector collector) {
        this.collector = collector;

        //attach communicator
        try {
            dataSource = (ComboPooledDataSource)settingCommunicator();
            connection = dataSource.getConnection();
            statement = connection.createStatement();
        } catch (PropertyVetoException e) {
            logger.error("LookupPhoenixBolt:prepare:" + e.getMessage());
        } catch (SQLException e) {
            logger.error("LookupPhoenixBolt:prepare:" + e.getMessage());
        }
    }

    @Override
    public void execute(Tuple tuple) {
        List<List<Object>> values = null;
        String query = null;

        try {
            query = generateQuery(tuple);

            //cache get
            List<List<Object>> cachedValues = LOCAL_CACHE_GET(query);
            if (cachedValues != null) {
                values = new ArrayList<List<Object>>(cachedValues);
            } else {
                ResultSet rs = statement.executeQuery(query);
                if (rs != null) {
                    values = valuesMapperFromJDBCResultColumns(baseStatement, rs);
                    //cache put.
                    LOCAL_CACHE_PUT(query, values);
                } else {
                    throw new InkException(MessageEnum.QUERY_RESULT_IS_NULL);
                }
            }

            //emit!
            for (List<Object> value : values) {
                List<Object> val = new ArrayList<Object>();
                val.addAll(value);
                val.addAll(tuple.getValues());
                collector.emit(streamId, tuple, val);
            }

            collector.ack(tuple);
        } catch (Exception e) {
            logger.error("LookupPhoenixBolt:execute:" + e.getMessage());
            collector.fail(tuple);
        } finally {
            logger.info("LookupPhoenixBolt:execute:query:" + query);
        }
    }

    @Override
    public void cleanup() {
        try {
            if (connection != null) {
                connection.commit();
                connection.close();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declareStream(streamId, getDeclareOutputFields(previousEmitFileds, baseStatement.getColumns()));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }

}
