package org.tommy.stationery.ink.core.engine.storm.spout;

import backtype.storm.Config;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.utils.Time;
import backtype.storm.utils.Utils;
import org.apache.storm.guava.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.util.MetaFinderUtil;
import org.tommy.stationery.ink.domain.BaseMetaDef;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MetaFieldEnum;
import storm.kafka.SpoutConfig;
import storm.kafka.ZkState;

import java.util.*;

/**
 * Created by tommy on 2015. 10. 19..
 */
public class TickSpout  extends BaseRichSpout {

    private static final Logger LOG = LoggerFactory.getLogger(TickSpout.class);

    private SpoutOutputCollector collector;
    private int tickSEC;
    private long defaultTxId = 0;
    private ZkState zkState;
    private SpoutConfig spoutConfig;
    private Map stateConf;
    private TopologyContext topologyContext;

    public TickSpout(Stream inkStream, SpoutConfig spoutConfig) {
        tickSEC = Integer.valueOf(MetaFinderUtil.findMeta(inkStream.getStatement().getMetas(), MetaFieldEnum.TICKSEC).getValue());
        try {
            defaultTxId = Long.valueOf(MetaFinderUtil.findMeta(inkStream.getStatement().getMetas(), MetaFieldEnum.TXID).getValue());
        } catch (Exception ex) {
        }
        this.spoutConfig = spoutConfig;
    }

    private String committedPath() {
        return spoutConfig.zkRoot + "/" + spoutConfig.id;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("str"));
    }

    private long writeDataFromZk() {
        String topologyInstanceId = topologyContext.getStormId();
        String path = committedPath();

        long lastCompletedOffset = defaultTxId;
        Map<Object, Object> json = zkState.readJSON(path);
        if (json != null) {
            lastCompletedOffset = (long)json.get("txid") + 1;
        }

        Map<Object, Object> data = (Map<Object, Object>) ImmutableMap.builder()
                .put("topology", ImmutableMap.of(
                        "id", topologyInstanceId,
                        "name", stateConf.get(Config.TOPOLOGY_NAME)))
                .put("txid", lastCompletedOffset)
                .build();
        zkState.writeJSON(path, data);

        return lastCompletedOffset;
    }

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
        this.topologyContext = topologyContext;

        stateConf = new HashMap(map);
        List<String> zkServers = (List<String>) map.get(Config.STORM_ZOOKEEPER_SERVERS);
        Integer zkPort = ((Number) map.get(Config.STORM_ZOOKEEPER_PORT)).intValue();
        stateConf.put(Config.TRANSACTIONAL_ZOOKEEPER_SERVERS, zkServers);
        stateConf.put(Config.TRANSACTIONAL_ZOOKEEPER_PORT, zkPort);
        stateConf.put(Config.TRANSACTIONAL_ZOOKEEPER_ROOT, spoutConfig.zkRoot);

        zkState = new ZkState(stateConf);
    }

    @Override
    public void nextTuple() {
        long offset = writeDataFromZk();
        List<Object> tuples = new ArrayList<Object>();
        String body = "{\"str\":" + "{\"txid\":\"" + offset + "\"}}";
        tuples.add(body);
        LOG.info(body);
        collector.emit(tuples);

        long waitMicrosec = tickSEC * 1000 + (int) (Math.random() * 1500);
        LOG.info("waitMicrosec : " + waitMicrosec);
        Utils.sleep(waitMicrosec);
    }
}
