package org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.rotation;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.tuple.Tuple;

public class TimedRotationPolicy implements FileRotationPolicy {

    public static enum TimeUnit {

        SECONDS((long)1000),
        MINUTES((long)1000*60),
        HOURS((long)1000*60*60),
        DAYS((long)1000*60*60*24);

        private long milliSeconds;

        private TimeUnit(long milliSeconds){
            this.milliSeconds = milliSeconds;
        }

        public long getMilliSeconds(){
            return milliSeconds;
        }
    }

    private long interval;

    public TimedRotationPolicy(float count, TimeUnit units){
        this.interval = (long)(count * units.getMilliSeconds());
    }

    @Override
    public boolean mark(Tuple tuple, long offset) {
        return false;
    }

    @Override
    public void reset() {

    }

    public long getInterval(){
        return this.interval;
    }
}
