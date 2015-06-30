package org.tommy.stationery.ink.core.engine.storm.bolt.bucket;

import backtype.storm.task.TopologyContext;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.format.FileNameFormat;

import java.util.Map;

/**
 * Created by kun7788 on 15. 3. 26..
 */
public class HdfsFileNameFormat implements FileNameFormat {
    private String componentId;
    private int taskId;
    private String filePath = "/ink";
    private String fileName = "tmp.csv";

    public HdfsFileNameFormat withFilePath(String filePath){
        this.filePath = filePath;
        return this;
    }

    public HdfsFileNameFormat withFileName(String fileName){
        this.fileName = fileName;
        return this;
    }

    @Override
    public void prepare(Map map, TopologyContext topologyContext) {

    }

    @Override
    public String getName(long rotation, long timeStamp) {
        return timeStamp + "." + "." + fileName + "." + rotation;
    }

    @Override
    public String getPath() {
        return filePath;
    }
}
