package org.tommy.stationery.ink.core.storm.bolt.bucket;

import backtype.storm.tuple.Tuple;
import org.apache.storm.hdfs.bolt.sync.SyncPolicy;

/**
 * Created by kun7788 on 15. 3. 27..
 */
public class HdfsCountSyncPolicy implements SyncPolicy {
        private int count;
        private int executeCount = 0;

        public HdfsCountSyncPolicy(int count){
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
