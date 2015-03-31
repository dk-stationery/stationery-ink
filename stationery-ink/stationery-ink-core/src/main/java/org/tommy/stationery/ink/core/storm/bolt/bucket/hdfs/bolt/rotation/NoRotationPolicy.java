package org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.rotation;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Tuple;

public class NoRotationPolicy implements FileRotationPolicy {
    @Override
    public boolean mark(Tuple tuple, long offset) {
        return false;
    }

    @Override
    public void reset() {
    }
}
