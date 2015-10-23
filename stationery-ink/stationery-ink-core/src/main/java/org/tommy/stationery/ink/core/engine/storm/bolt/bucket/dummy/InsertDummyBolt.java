package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.dummy;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.storm.bolt.GenericBoltUtils;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.IBucketBolt;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.dummy.plugins.DummyPlugin;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tommy on 2015. 10. 23..
 */
public class InsertDummyBolt implements IRichBolt, IBucketBolt {

    private static final Logger LOG = LoggerFactory.getLogger(InsertDummyBolt.class);

    private OutputCollector collector;
    private Source inkSource;
    private Stream inkStream;
    private InkConfig inkConfig;
    private String streamId;
    private List<String> previousEmitFileds;
    private BaseStatement statement;
    private List<DummyPlugin> plugins = new ArrayList<DummyPlugin>();
    private Map stormConf;
    private TopologyContext topologyContext;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
        stormConf = map;
        this.topologyContext = topologyContext;
        plugins = plugins(extractPluginNames());
    }

    private List<String> extractPluginNames() {
        String query = statement.getQuery();
        Pattern pattern = Pattern.compile("plugins(\\s*)\\((.+?)\\)");
        Matcher matcher = pattern.matcher(query);

        String[] pluginNamesArr = null;
        while(matcher.find()) {
            pluginNamesArr = matcher.group(2).replace(" ", "").replace("'", "").split(",");
        }

        List<String> pluginNames = new ArrayList<String>();
        if (pluginNamesArr != null) {
            for (int i = 0; i < pluginNamesArr.length; i++) {
                pluginNames.add(pluginNamesArr[i]);
            }
        }
        return pluginNames;
    }

    private List<DummyPlugin> plugins(List<String> pluginNames) {
        for (String pluginName: pluginNames) {
            Class klass = null;
            try {
                klass = Class.forName(pluginName);
                DummyPlugin plugin = (DummyPlugin)klass.newInstance();
                plugin.prepare(stormConf, topologyContext);
                plugins.add(plugin);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return plugins;
    }

    @Override
    public void execute(Tuple tuple) {
        try {
            for (DummyPlugin plugin : plugins) {
                plugin.execute(tuple);
            }
            collector.emit(streamId, tuple.getValues());
            collector.ack(tuple);
        } catch (Exception e) {
            LOG.error("InsertDummyBolt exception : ", e);
            collector.fail(tuple);
        }
    }

    @Override
    public void cleanup() {

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
