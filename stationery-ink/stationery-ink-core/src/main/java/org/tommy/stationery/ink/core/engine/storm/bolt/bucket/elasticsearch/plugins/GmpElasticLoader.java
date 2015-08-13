package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.elasticsearch.plugins;

import backtype.storm.tuple.Tuple;
import org.elasticsearch.client.Client;

/**
 * Created by kun7788 on 15. 8. 13..
 */
public class GmpElasticLoader implements ElasticPlugin {

    Client client;

    @Override
    public void prepare(Client client) {
        this.client = client;
    }

    @Override
    public synchronized boolean execute(Tuple tuple) throws Exception {
        return true;
    }
}
