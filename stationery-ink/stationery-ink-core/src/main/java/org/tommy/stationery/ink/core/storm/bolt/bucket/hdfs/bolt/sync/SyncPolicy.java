package org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.sync;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Tuple;

import java.io.Serializable;

public interface SyncPolicy extends Serializable {
    boolean mark(Tuple tuple, long offset);
    void reset();

}
