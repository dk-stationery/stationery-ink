package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt;

/**
 * Created by kun7788 on 15. 3. 30..
 */

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.client.HdfsDataOutputStream;
import org.apache.hadoop.hdfs.client.HdfsDataOutputStream.SyncFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.storm.bolt.GenericBoltUtils;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.HdfsCountSyncPolicy;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.HdfsFileNameFormat;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.IBucketBolt;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.format.DelimitedRecordFormat;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.format.FileNameFormat;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.format.RecordFormat;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.rotation.FileRotationPolicy;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.rotation.FileSizeRotationPolicy;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.sync.SyncPolicy;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.common.rotation.RotationAction;
import org.tommy.stationery.ink.core.util.MetaFinderUtil;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MetaFieldEnum;
import org.tommy.stationery.ink.enums.SettingEnum;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class InsertHdfsBolt extends AbstractHdfsInsertBolt implements IRichBolt, IBucketBolt {
    private static final Logger LOG = LoggerFactory.getLogger(InsertHdfsBolt.class);

    private transient FSDataOutputStream out;
    private RecordFormat format;
    private long offset = 0;

    private String streamId;
    private BaseStatement baseStatement = null;
    private Source inkSource;
    private Stream inkStream;
    private InkConfig inkConfig;
    private String hdfsFileName;
    private String hdfsFilePath;
    private List<String> previousEmitFileds;
    private OutputCollector collector;

    public InsertHdfsBolt withFsUrl(String fsUrl){
        this.fsUrl = fsUrl;
        return this;
    }

    public InsertHdfsBolt withConfigKey(String configKey){
        this.configKey = configKey;
        return this;
    }

    public InsertHdfsBolt withFileNameFormat(FileNameFormat fileNameFormat){
        this.fileNameFormat = fileNameFormat;
        return this;
    }

    public InsertHdfsBolt withRecordFormat(RecordFormat format){
        this.format = format;
        return this;
    }

    public InsertHdfsBolt withSyncPolicy(SyncPolicy syncPolicy){
        this.syncPolicy = syncPolicy;
        return this;
    }

    public InsertHdfsBolt withRotationPolicy(FileRotationPolicy rotationPolicy){
        this.rotationPolicy = rotationPolicy;
        return this;
    }

    public InsertHdfsBolt addRotationAction(RotationAction action){
        this.rotationActions.add(action);
        return this;
    }

    @Override
    public void doPrepare(Map conf, TopologyContext topologyContext, OutputCollector collector) throws IOException {
        this.collector = collector;
        this.fs = FileSystem.get(URI.create(this.fsUrl), hdfsConfig);
    }

    @Override
    public void execute(Tuple tuple) {
        try {
            byte[] bytes = this.format.format(tuple);
            synchronized (this.writeLock) {
                out.write(bytes);
                this.offset += bytes.length;

                if (this.syncPolicy.mark(tuple, this.offset)) {
                    if (this.out instanceof HdfsDataOutputStream) {
                        ((HdfsDataOutputStream) this.out).hsync(EnumSet.of(SyncFlag.UPDATE_LENGTH));
                    } else {
                        this.out.sync();
                    }
                    this.syncPolicy.reset();
                }
            }

            collector.emit(streamId, tuple.getValues());
            this.collector.ack(tuple);

            if(this.rotationPolicy.mark(tuple, this.offset)){
                rotateOutputFile(); // synchronized
                this.offset = 0;
                this.rotationPolicy.reset();
            }
        } catch (IOException e) {
            LOG.warn("write/sync failed.", e);
            this.collector.fail(tuple);
        }
    }

    @Override
    void closeOutputFile() throws IOException {
        this.out.close();
    }

    @Override
    Path createOutputFile() throws IOException {
        Path path = new Path(this.fileNameFormat.getPath(), this.fileNameFormat.getName(this.rotation, System.currentTimeMillis()));
        this.out = this.fs.create(path);
        return path;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        GenericBoltUtils genericBoltUtils = new GenericBoltUtils();
        declarer.declareStream(streamId, genericBoltUtils.getDeclareOutputFields(previousEmitFileds, baseStatement.getColumns()));
    }


    public void setting(String streamId, InkConfig inkConfig, List<String> previousEmitFileds, BaseStatement statement, Stream inkStream, Source inkSource) {
        this.streamId = streamId;
        this.baseStatement = statement;
        this.inkStream = inkStream;
        this.inkSource = inkSource;
        this.inkConfig = inkConfig;
        this.previousEmitFileds = previousEmitFileds;
        String hdfsFullpathFileName = MetaFinderUtil.findMeta(inkStream.getStatement().getMetas(), MetaFieldEnum.TOPIC).getValue();
        hdfsFilePath = hdfsFullpathFileName.substring(0, hdfsFullpathFileName.lastIndexOf("/"));
        hdfsFileName = hdfsFullpathFileName.substring(hdfsFullpathFileName.lastIndexOf("/") + 1, hdfsFullpathFileName.length());

        List<String> columns = new ArrayList<String>();
        if (baseStatement.getColumns() != null) {
            for (BaseColumnDef columnDef : baseStatement.getColumns()) {
                columns.add(columnDef.getName());
            }
        }

        RecordFormat format = new DelimitedRecordFormat()
                .withFieldDelimiter("|").withFields(new Fields(columns.toArray(new String[0])));
        this.withRecordFormat(format);

        HdfsCountSyncPolicy syncPolicy = new HdfsCountSyncPolicy(inkConfig.getInteger(SettingEnum.COMMIT_INTERVAL)); //performance issue.
        this.withSyncPolicy((SyncPolicy) syncPolicy);

        FileRotationPolicy rotationPolicy = new FileSizeRotationPolicy(1.0f, FileSizeRotationPolicy.Units.MB);
        this.withRotationPolicy((FileRotationPolicy) rotationPolicy);

        FileNameFormat fileNameFormat = new HdfsFileNameFormat()
                .withFilePath(hdfsFilePath).withFileName(hdfsFileName);
        this.withFileNameFormat((FileNameFormat) fileNameFormat);

        this.withFsUrl(MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.URL).getValue());
    }

    @Override
    public String generateQuery(Tuple input) {
        return null;
    }

    @Override
    public Object settingCommunicator() throws PropertyVetoException {
        return null;
    }
}
