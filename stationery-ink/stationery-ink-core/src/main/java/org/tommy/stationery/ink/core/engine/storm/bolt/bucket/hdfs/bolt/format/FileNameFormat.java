package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.format;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.task.TopologyContext;

import java.io.Serializable;
import java.util.Map;

public interface FileNameFormat extends Serializable {

    void prepare(Map conf, TopologyContext topologyContext);

    String getName(long rotation, long timeStamp);

    String getPath();
}
