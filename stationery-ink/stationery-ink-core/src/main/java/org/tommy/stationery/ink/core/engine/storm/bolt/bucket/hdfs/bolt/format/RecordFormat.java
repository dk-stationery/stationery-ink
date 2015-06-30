package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.format;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Tuple;

import java.io.Serializable;

public interface RecordFormat extends Serializable {
    byte[] format(Tuple tuple);
}
