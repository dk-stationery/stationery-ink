package org.tommy.stationery.ink.core.storm.bolt.bucket;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.storm.bolt.GenericBoltUtils;
import org.tommy.stationery.ink.core.util.MetaFinderUtil;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MetaFieldEnum;
import org.tommy.stationery.ink.enums.SettingEnum;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class InsertJDBCBolt extends GenericBoltUtils implements IRichBolt, IBucketBolt {
    public static Logger logger = LoggerFactory.getLogger(InsertJDBCBolt.class);

    private OutputCollector collector;
    private String streamId;
    private BaseStatement baseStatement = null;
    private Source inkSource;
    private Stream inkStream;
    private InkConfig inkConfig;
    private String query;
    private String topic;
    private ComboPooledDataSource dataSource;
    private GlobalDatabaseWriter globalDatabaseWriter;
    private List<String> previousEmitFileds;

    @Override
    public void setting(String streamId, InkConfig inkConfig, List<String> previousEmitFileds, BaseStatement baseStatement, Stream inkStream, Source inkSource) {
        this.streamId = streamId;
        this.baseStatement = baseStatement;
        this.inkStream = inkStream;
        this.inkSource = inkSource;
        this.inkConfig = inkConfig;
        this.previousEmitFileds = previousEmitFileds;
        this.topic = MetaFinderUtil.findMeta(inkStream.getStatement().getMetas(), MetaFieldEnum.TOPIC).getValue();
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
            globalDatabaseWriter = new GlobalDatabaseWriter(dataSource, inkConfig.getInteger(SettingEnum.COMMIT_INTERVAL));
            globalDatabaseWriter.startAsync();
        } catch (PropertyVetoException e) {
        } catch (SQLException e) {
        }
    }

    @Override
    public void execute(Tuple tuple) {
        String query = null;
        try {

            query = generateQuery(tuple);
            if (query == null) {
                collector.ack(tuple);
            } else {
                //run sql
                globalDatabaseWriter.writeAsync(query);
                collector.ack(tuple);
                collector.emit(streamId, tuple.getValues());
                logger.info("InsertPhoenixBolt:execute:query = " + query);

            }
        } catch(Exception ex) {
            collector.fail(tuple);
            logger.error("InsertPhoenixBolt:execute:error = " + ex.getMessage());
        }
    }

    @Override
    public void cleanup() {
        globalDatabaseWriter.stopAsync();
        try {
            globalDatabaseWriter.shutDown();
        } catch (Exception e) {
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
