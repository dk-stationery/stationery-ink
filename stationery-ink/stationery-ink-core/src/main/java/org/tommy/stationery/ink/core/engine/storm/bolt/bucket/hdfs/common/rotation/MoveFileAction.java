package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.common.rotation;

/**
 * Created by kun7788 on 15. 3. 25..
 */
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MoveFileAction implements RotationAction {
    private static final Logger LOG = LoggerFactory.getLogger(MoveFileAction.class);

    private String destination;

    public MoveFileAction toDestination(String destDir){
        destination = destDir;
        return this;
    }

    @Override
    public void execute(FileSystem fileSystem, Path filePath) throws IOException {
        Path destPath = new Path(destination, filePath.getName());
        LOG.info("Moving file {} to {}", filePath, destPath);
        boolean success = fileSystem.rename(filePath, destPath);
        return;
    }
}
