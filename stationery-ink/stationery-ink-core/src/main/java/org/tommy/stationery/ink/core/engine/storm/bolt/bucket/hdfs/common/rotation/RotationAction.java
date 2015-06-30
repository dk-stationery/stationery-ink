package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.common.rotation;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.io.Serializable;

public interface RotationAction extends Serializable {
    void execute(FileSystem fileSystem, Path filePath) throws IOException;
}
