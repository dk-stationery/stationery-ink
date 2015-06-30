package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.bolt.format;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import backtype.storm.task.TopologyContext;

import java.util.Map;


/**
 * Creates file names with the following format:
 * <pre>
 *     {prefix}{componentId}-{taskId}-{rotationNum}-{timestamp}{extension}
 * </pre>
 * For example:
 * <pre>
 *     MyBolt-5-7-1390579837830.txt
 * </pre>
 *
 * By default, prefix is empty and extenstion is ".txt".
 *
 */
public class DefaultFileNameFormat implements FileNameFormat {
    private String componentId;
    private int taskId;
    private String path = "/storm";
    private String prefix = "";
    private String extension = ".txt";

    public DefaultFileNameFormat withPrefix(String prefix){
        this.prefix = prefix;
        return this;
    }

    public DefaultFileNameFormat withExtension(String extension){
        this.extension = extension;
        return this;
    }

    public DefaultFileNameFormat withPath(String path){
        this.path = path;
        return this;
    }

    @Override
    public void prepare(Map conf, TopologyContext topologyContext) {
        this.componentId = topologyContext.getThisComponentId();
        this.taskId = topologyContext.getThisTaskId();
    }

    @Override
    public String getName(long rotation, long timeStamp) {
        return this.prefix + this.componentId + "-" + this.taskId +  "-" + rotation + "-" + timeStamp + this.extension;
    }

    public String getPath(){
        return this.path;
    }
}