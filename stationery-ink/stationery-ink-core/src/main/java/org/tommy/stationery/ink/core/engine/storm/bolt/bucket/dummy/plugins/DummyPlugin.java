package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.dummy.plugins;

import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Tuple;

import java.util.Map;

/**
 * Created by tommy on 2015. 10. 23..
 */
public interface DummyPlugin {
    public void prepare(Map stormConf, TopologyContext topologyContext);
    public boolean execute(Tuple tuple)  throws Exception;
}
