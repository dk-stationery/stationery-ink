package org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.sync;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Tuple;

public class CountSyncPolicy implements SyncPolicy {
    private int count;
    private int executeCount = 0;

    public CountSyncPolicy(int count){
        this.count = count;
    }

    @Override
    public boolean mark(Tuple tuple, long offset) {
        this.executeCount++;
        return this.executeCount >= this.count;
    }

    @Override
    public void reset() {
        this.executeCount = 0;
    }
}
