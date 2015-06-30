package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt;

/**
 * Created by kun7788 on 15. 3. 25..
 */

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.format.FileNameFormat;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.rotation.FileRotationPolicy;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.rotation.TimedRotationPolicy;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.sync.SyncPolicy;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.common.rotation.RotationAction;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.common.security.HdfsSecurityUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractHdfsInsertBolt extends BaseRichBolt {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractHdfsInsertBolt.class);

    protected ArrayList<RotationAction> rotationActions = new ArrayList<RotationAction>();
    private Path currentFile;
    protected OutputCollector collector;
    protected transient FileSystem fs;
    protected SyncPolicy syncPolicy;
    protected FileRotationPolicy rotationPolicy;
    protected FileNameFormat fileNameFormat;
    protected int rotation = 0;
    protected String fsUrl;
    protected String configKey;
    protected transient Object writeLock;
    protected transient Timer rotationTimer; // only used for TimedRotationPolicy

    protected transient Configuration hdfsConfig;

    protected void rotateOutputFile() throws IOException {
        LOG.info("Rotating output file...");
        long start = System.currentTimeMillis();
        synchronized (this.writeLock) {
            closeOutputFile();
            this.rotation++;

            Path newFile = createOutputFile();
            LOG.info("Performing {} file rotation actions.", this.rotationActions.size());
            for (RotationAction action : this.rotationActions) {
                action.execute(this.fs, this.currentFile);
            }
            this.currentFile = newFile;
        }
        long time = System.currentTimeMillis() - start;
        LOG.info("File rotation took {} ms.", time);
    }

    public final void prepare(Map conf, TopologyContext topologyContext, OutputCollector collector){
        this.writeLock = new Object();
        if (this.syncPolicy == null) throw new IllegalStateException("SyncPolicy must be specified.");
        if (this.rotationPolicy == null) throw new IllegalStateException("RotationPolicy must be specified.");
        if (this.fsUrl == null) {
            throw new IllegalStateException("File system URL must be specified.");
        }

        this.collector = collector;
        this.fileNameFormat.prepare(conf, topologyContext);
        this.hdfsConfig = new Configuration();
        Map<String, Object> map = (Map<String, Object>)conf.get(this.configKey);
        if(map != null){
            for(String key : map.keySet()){
                this.hdfsConfig.set(key, String.valueOf(map.get(key)));
            }
        }

        try{
            HdfsSecurityUtil.login(conf, hdfsConfig);
            doPrepare(conf, topologyContext, collector);
            this.currentFile = createOutputFile();

        } catch (Exception e){
            throw new RuntimeException("Error preparing HdfsBolt: " + e.getMessage(), e);
        }

        if(this.rotationPolicy instanceof TimedRotationPolicy){
            long interval = ((TimedRotationPolicy)this.rotationPolicy).getInterval();
            this.rotationTimer = new Timer(true);
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    try {
                        rotateOutputFile();
                    } catch(IOException e){
                        LOG.warn("IOException during scheduled file rotation.", e);
                    }
                }
            };
            this.rotationTimer.scheduleAtFixedRate(task, interval, interval);
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
    }

    abstract void closeOutputFile() throws IOException;

    abstract Path createOutputFile() throws IOException;

    abstract void doPrepare(Map conf, TopologyContext topologyContext, OutputCollector collector) throws IOException;

}