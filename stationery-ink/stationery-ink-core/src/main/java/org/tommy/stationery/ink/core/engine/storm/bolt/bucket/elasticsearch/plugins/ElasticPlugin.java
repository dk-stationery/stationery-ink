package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.elasticsearch.plugins;

import backtype.storm.tuple.Tuple;
import org.elasticsearch.client.Client;

/**
 * Created by kun7788 on 15. 8. 13..
 */
public interface ElasticPlugin {
    public void prepare(Client client);
    public boolean execute(Tuple tuple)  throws Exception;
}
