package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.elasticsearch.plugins;

import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Tuple;
import org.elasticsearch.client.Client;

import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 13..
 */
public interface ElasticPlugin {
    public void prepare(Client client, Map stormConf, TopologyContext topologyContext);
    public boolean execute(Tuple tuple)  throws Exception;
}
