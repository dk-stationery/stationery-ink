package org.tommy.stationery.ink.core.util;

import backtype.storm.generated.StormTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.exception.InkException;
import org.tommy.stationery.ink.util.serde.JavaStringSerde;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by kun7788 on 15. 2. 5..
 */
public class StormManager {
    public static Logger logger = LoggerFactory.getLogger(StormManager.class);

    private static String STORM_DEPLOY_CMD = "bin/storm jar ";
    private static String STORM_KILL_CMD = "bin/storm kill ";
    private static String STORM_KILL_TIMEWAIT_SEC_OPT = " -w 0 ";
    private static String LOG_OPT = " 2>&1 ";
    private static String LOG_APPENDED_REDIRECT_CMD = " >> ";
    private static String WHITESPACE = " ";
    private static String DOUBLE_QUOTE = "\"";

    public static String depoly(InkConfig inkConfig, Object topology) throws Exception {
        StormTopology stormTopology = (StormTopology)topology;
        JavaStringSerde javaStringSerde = new JavaStringSerde();

        String jobName = inkConfig.getString(SettingEnum.JOB_NAME);

        StringBuilder paramSb = new StringBuilder();
        paramSb.append(DOUBLE_QUOTE + jobName + DOUBLE_QUOTE + WHITESPACE);
        //paramSb.append(DOUBLE_QUOTE + javaStringSerde.serialize(stormTopology) + DOUBLE_QUOTE + WHITESPACE);
        paramSb.append(DOUBLE_QUOTE + javaStringSerde.serialize(inkConfig) + DOUBLE_QUOTE + WHITESPACE);

        String params = paramSb.toString();

        StringBuilder sb = new StringBuilder();
        sb.append(inkConfig.getString(SettingEnum.STORM_HOME));
        sb.append(STORM_DEPLOY_CMD);
        sb.append(inkConfig.getString(SettingEnum.STORM_CLIENT_FILEPATH) + inkConfig.getString(SettingEnum.STORM_CLIENT_JAR) + WHITESPACE);
        sb.append(inkConfig.getString(SettingEnum.STORM_CLIENT_MAIN_CLASS) + WHITESPACE);
        sb.append(params);
        String runCommand = sb.toString();

        //file export
        String shellFileName = inkConfig.getString(SettingEnum.STORM_CLIENT_FILEPATH) + jobName + ".serialize";
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(shellFileName, false)));
        out.write(javaStringSerde.serialize(stormTopology));
        out.flush();
        out.close();

        logger.info(shellFileName);
        return ShellExecutor.executeCommand(runCommand);
    }

    public static String kill(InkConfig inkConfig, String jobName) throws IOException, InterruptedException, InkException {
        StringBuilder sb = new StringBuilder();
        sb.append(inkConfig.getString(SettingEnum.STORM_HOME));
        sb.append(STORM_KILL_CMD);
        sb.append(jobName + STORM_KILL_TIMEWAIT_SEC_OPT);
        String runCommand = sb.toString();

        logger.info(runCommand);
        return ShellExecutor.executeCommand(runCommand);
    }
}
