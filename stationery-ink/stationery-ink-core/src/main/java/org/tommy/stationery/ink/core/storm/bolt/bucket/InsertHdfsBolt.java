package org.tommy.stationery.ink.core.storm.bolt.bucket;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import org.apache.storm.hdfs.bolt.HdfsBolt;
import org.apache.storm.hdfs.bolt.format.DelimitedRecordFormat;
import org.apache.storm.hdfs.bolt.format.FileNameFormat;
import org.apache.storm.hdfs.bolt.format.RecordFormat;
import org.apache.storm.hdfs.bolt.rotation.FileRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.FileSizeRotationPolicy;
import org.apache.storm.hdfs.bolt.sync.CountSyncPolicy;
import org.apache.storm.hdfs.bolt.sync.SyncPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.core.storm.bolt.GenericBoltUtils;
import org.tommy.stationery.ink.core.util.MetaFinderUtil;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.MetaFieldEnum;
import org.tommy.stationery.ink.enums.SettingEnum;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kun7788 on 15. 3. 25..
 */
public class InsertHdfsBolt extends HdfsBolt implements IRichBolt, IBucketBolt {

    public static Logger logger = LoggerFactory.getLogger(InsertHdfsBolt.class);
    private static final String PROTOCOL = "hdfs://";
    private String streamId;
    private BaseStatement baseStatement = null;
    private Source inkSource;
    private Stream inkStream;
    private InkConfig inkConfig;
    private String hdfsFileName;
    private String hdfsFilePath;
    private List<String> previousEmitFileds;

    @Override
    public void setting(String streamId, InkConfig inkConfig, List<String> previousEmitFileds, BaseStatement statement, Stream inkStream, Source inkSource) {
        this.streamId = streamId;
        this.baseStatement = baseStatement;
        this.inkStream = inkStream;
        this.inkSource = inkSource;
        this.inkConfig = inkConfig;
        this.previousEmitFileds = previousEmitFileds;
        String hdfsFullpathFileName = MetaFinderUtil.findMeta(inkStream.getStatement().getMetas(), MetaFieldEnum.TOPIC).getValue();
        hdfsFilePath = hdfsFullpathFileName.substring(0, hdfsFullpathFileName.lastIndexOf("/"));
        hdfsFileName = inkStream.getName() + ".txt";
    }

    @Override
    public void doPrepare(Map conf, TopologyContext topologyContext, OutputCollector collector) throws IOException {
        super.doPrepare(conf, topologyContext, collector);


        List<String> columns = new ArrayList<String>();
        if (baseStatement.getColumns() != null) {
            for (BaseColumnDef columnDef : baseStatement.getColumns()) {
                columns.add(columnDef.getName());
            }
        }

        RecordFormat format = new DelimitedRecordFormat()
                .withFieldDelimiter(",").withFields(new Fields(columns.toArray(new String[0])));
        this.withRecordFormat(format);

        SyncPolicy syncPolicy = new CountSyncPolicy((inkConfig.getInteger(SettingEnum.COMMIT_INTERVAL) < 10) ? 100 : inkConfig.getInteger(SettingEnum.COMMIT_INTERVAL)); //performance issue.
        this.withSyncPolicy(syncPolicy);

        FileRotationPolicy rotationPolicy = new FileSizeRotationPolicy(1024.0f, FileSizeRotationPolicy.Units.MB);
        this.withRotationPolicy(rotationPolicy);

        FileNameFormat fileNameFormat = new HdfsFileNameFormat()
                .withFilePath(hdfsFilePath).withFileName(hdfsFileName);
        this.withFileNameFormat(fileNameFormat);

        this.withFsUrl(PROTOCOL + MetaFinderUtil.findMeta(inkSource.getStatement().getMetas(), MetaFieldEnum.URL).getValue());
    }

    @Override
    public void execute(Tuple tuple) {
        super.execute(tuple);
    }

    @Override
    public void cleanup() {
        super.cleanup();
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        GenericBoltUtils genericBoltUtils = new GenericBoltUtils();
        declarer.declareStream(streamId, genericBoltUtils.getDeclareOutputFields(previousEmitFileds, baseStatement.getColumns()));
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
