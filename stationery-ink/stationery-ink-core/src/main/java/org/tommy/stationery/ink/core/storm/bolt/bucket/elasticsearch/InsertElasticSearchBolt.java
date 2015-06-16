package org.tommy.stationery.ink.core.storm.bolt.bucket.elasticsearch;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.storm.bolt.GenericBoltUtils;
import org.tommy.stationery.ink.core.storm.bolt.bucket.IBucketBolt;
import org.tommy.stationery.ink.core.util.MetaFinderUtil;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MetaFieldEnum;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.util.serde.JsonSerde;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kun7788 on 15. 4. 1..
 */
public class InsertElasticSearchBolt implements IRichBolt, IBucketBolt {

    private static final Logger LOG = LoggerFactory.getLogger(InsertElasticSearchBolt.class);
    private OutputCollector collector;
    private Client client;
    private Source inkSource;
    private Stream inkStream;
    private InkConfig inkConfig;
    private String streamId;
    private List<String> previousEmitFileds;
    private BaseStatement statement;
    private String esIndexName;
    private String esType;
    private JsonSerde jsonSerde;

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
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;

        this.jsonSerde = new JsonSerde();
        String elasticSearchHost = MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.URL).getValue();
        Integer elasticSearchPort =  Integer.valueOf(MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.PORT).getValue());
        String elasticSearchCluster =  MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.CLUSTER).getValue();
        Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", elasticSearchCluster).build();
        client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(elasticSearchHost, elasticSearchPort));

        esIndexName = MetaFinderUtil.findMeta(inkStream.getStatement().getMetas(), MetaFieldEnum.TOPIC).getValue();
        esType = inkConfig.getString(SettingEnum.JOB_NAME);
    }

    @Override
    public void execute(Tuple tuple) {
        try {
            Map<String, String> map = new HashMap<String, String>();
            for (String field : tuple.getFields()) {
                map.put(field, tuple.getStringByField(field));
            }

            String document = jsonSerde.serialize(map);
            byte[] byteBuffer = document.getBytes();

            IndexResponse response = this.client.prepareIndex(esIndexName, esType).setSource(byteBuffer)
                    .execute()
                    .actionGet();

            LOG.info("Indexed Documen, Type[" + esType + "], Index[" + esIndexName + "], Version ["
                    + response.getVersion() + "]");
            collector.emit(streamId, tuple.getValues());
            collector.ack(tuple);
        } catch (Exception e) {
            LOG.error("Unable to index Document, Type[" + esType + "], Index[" + esIndexName + "]", e);
            collector.fail(tuple);
        }
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


    @Override
    public String generateQuery(Tuple input) {
        return null;
    }

    @Override
    public Object settingCommunicator() throws PropertyVetoException {
        return null;
    }

    @Override
    public void cleanup() {
        if (client != null) {
            client.close();
        }
    }
}
