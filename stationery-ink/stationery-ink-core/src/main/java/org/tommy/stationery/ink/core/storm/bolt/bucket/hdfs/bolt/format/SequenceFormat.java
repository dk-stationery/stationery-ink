package org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.format;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Tuple;
import org.apache.hadoop.io.Writable;

import java.io.Serializable;

public interface SequenceFormat extends Serializable {
    Class keyClass();
    Class valueClass();
    Writable key(Tuple tuple);
    Writable value(Tuple tuple);
}
