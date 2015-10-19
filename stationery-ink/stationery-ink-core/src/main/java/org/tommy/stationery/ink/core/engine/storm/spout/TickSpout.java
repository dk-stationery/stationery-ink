package org.tommy.stationery.ink.core.engine.storm.spout;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.util.MetaFinderUtil;
import org.tommy.stationery.ink.domain.BaseMetaDef;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MetaFieldEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2015. 10. 19..
 */
public class TickSpout  extends BaseRichSpout {

    private static final Logger LOG = LoggerFactory.getLogger(TickSpout.class);

    private SpoutOutputCollector collector;
    private int tickSEC;
    private int tickCnt;

    public TickSpout(Stream inkStream) {
        tickSEC = Integer.valueOf(MetaFinderUtil.findMeta(inkStream.getStatement().getMetas(), MetaFieldEnum.TICKSEC).getValue());
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("str"));
    }

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
        tickCnt = 0;
    }

    @Override
    public void nextTuple() {
        tickCnt++;
        List<Object> tuples = new ArrayList<Object>();
        String body = "{\"str\":" + "{\"tickCnt\":" + "\"" + tickCnt + "\"}}";
        tuples.add(body);
        LOG.info(body);
        collector.emit(tuples);
        Utils.sleep(tickCnt * 1000);
    }
}
