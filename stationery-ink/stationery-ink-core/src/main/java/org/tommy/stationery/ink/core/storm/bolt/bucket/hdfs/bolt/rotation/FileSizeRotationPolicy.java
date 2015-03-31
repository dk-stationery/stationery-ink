package org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.rotation;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSizeRotationPolicy implements FileRotationPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(FileSizeRotationPolicy.class);

    public static enum Units {

        KB((long)Math.pow(2, 10)),
        MB((long)Math.pow(2, 20)),
        GB((long)Math.pow(2, 30)),
        TB((long)Math.pow(2, 40));

        private long byteCount;

        private Units(long byteCount){
            this.byteCount = byteCount;
        }

        public long getByteCount(){
            return byteCount;
        }
    }

    private long maxBytes;

    private long lastOffset = 0;
    private long currentBytesWritten = 0;

    public FileSizeRotationPolicy(float count, Units units){
        this.maxBytes = (long)(count * units.getByteCount());
    }

    @Override
    public boolean mark(Tuple tuple, long offset) {
        long diff = offset - this.lastOffset;
        this.currentBytesWritten += diff;
        this.lastOffset = offset;
        return this.currentBytesWritten >= this.maxBytes;
    }

    @Override
    public void reset() {
        this.currentBytesWritten = 0;
        this.lastOffset = 0;
    }

}
