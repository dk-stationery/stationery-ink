package org.tommy.stationery.ink.stormclient.util;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.StormTopology;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.enums.SettingEnum;
import storm.trident.spout.RichSpoutBatchExecutor;

/**
 * Created by kun7788 on 15. 2. 4..
 */
public class ClusterUtil {
    public static Config topologyConfig(InkConfig inkConfig) {
        //setup topology config
        Config topologyConfig = new Config();
        topologyConfig.setDebug(false);
        topologyConfig.setMessageTimeoutSecs(inkConfig.getInteger(SettingEnum.STORM_MESSAGE_TIMEOUT_SEC));
        topologyConfig.put(RichSpoutBatchExecutor.MAX_BATCH_SIZE_CONF, inkConfig.getInteger(SettingEnum.STORM_BATCH_SIZE));
        topologyConfig.setNumWorkers(inkConfig.getInteger(SettingEnum.WORKER_CNT));
        topologyConfig.setMaxSpoutPending(inkConfig.getInteger(SettingEnum.STORM_MAXSPOUTPENDING_NUM));
        return topologyConfig;
    }

    public static void run(String jobName, InkConfig inkConfig, StormTopology topology) throws Exception {
        Config topologyConfig = topologyConfig(inkConfig);

        if (inkConfig.getBoolean(SettingEnum.IS_LOCAL) == true) {
            LocalCluster localCluster = new LocalCluster();
            localCluster.submitTopology(jobName, topologyConfig, topology);
        } else {
            StormSubmitter.submitTopology(jobName, topologyConfig, topology);
        }
    }
}
