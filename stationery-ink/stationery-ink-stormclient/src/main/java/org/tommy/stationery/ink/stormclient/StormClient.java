package org.tommy.stationery.ink.stormclient;

import backtype.storm.generated.StormTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.stormclient.util.ClusterUtil;
import org.tommy.stationery.ink.util.serde.JavaStringSerde;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by kun7788 on 15. 2. 4..
 */
public class StormClient {

    public static Logger logger = LoggerFactory.getLogger(StormClient.class);

    public static void main(String[] args) throws Exception {
        try {
            if (args == null || args.length != 2) {
                logger.error("Args is null or args count is invalid. must be 3.");
                System.exit(1);
            }

            String jobName = args[0];
            String serializeInkConfig = args[1];

            JavaStringSerde javaStringSerde = new JavaStringSerde();
            InkConfig inkConfig = (InkConfig) javaStringSerde.deserialize(serializeInkConfig);
            String serializeFileName = inkConfig.getString(SettingEnum.STORM_CLIENT_FILEPATH) + jobName + ".serialize";
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(serializeFileName)));
            StringBuilder sb = new StringBuilder();
            String row = "";
            while ((row = in.readLine()) != null) {
                sb.append(row);
            }
            in.close();
            String serializeTopology = sb.toString();

            StormTopology stormTopology = (StormTopology) javaStringSerde.deserialize(serializeTopology);
            ClusterUtil.run(jobName, inkConfig, stormTopology);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw ex;
        }
    }
}
