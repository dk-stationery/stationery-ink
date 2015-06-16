package org.tommy.stationery.ink.config;

import org.tommy.stationery.ink.enums.SettingEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 1. 20..
 */
public class InkConfig implements Serializable {

    public static String STORM_HOME = "STORM_HOME";
    public static String STORM_CLIENT_FILEPATH = "STORM_CLIENT_FILEPATH";
    public static String STORM_CLIENT_JAR = "STORM_CLIENT_JAR";
    public static String STORM_CLIENT_MAIN_CLASS = "STORM_CLIENT_MAIN_CLASS";
    public static String STORM_RUN_LOG_FULLPATH = "STORM_RUN_LOG_FULLPATH";

    public static String IS_LOCAL = "IS_LOCAL";
    public static String WORKER_CNT = "WORKER_CNT";
    public static String SPOUT_THREAD_CNT = "SPOUT_THREAD_CNT";
    public static String ESPER_THREAD_CNT = "ESPER_THREAD_CNT";
    public static String LOOKUP_THREAD_CNT = "LOOKUP_THREAD_CNT";
    public static String OUTPUT_THREAD_CNT = "OUTPUT_THREAD_CNT";
    public static String IS_DEBUG = "IS_DEBUG";
    public static String COMMIT_INTERVAL = "COMMIT_INTERVAL";

    public static String STORM_MESSAGE_TIMEOUT_SEC = "STORM_MESSAGE_TIMEOUT_SEC";
    public static String STORM_MAXSPOUTPENDING_NUM = "STORM_MAXSPOUTPENDING_NUM";
    public static String STORM_BATCH_SIZE = "STORM_BATCH_SIZE";

    private Map<SettingEnum, String> configs = new HashMap<SettingEnum, String>();

    public void put(SettingEnum name, String value) {
        configs.put(name, value);
    }

    public int getInteger(SettingEnum name) {
        return Integer.valueOf(configs.get(name));
    }

    public String getString(SettingEnum name) {
        if (configs.containsKey(name) == false) {
            return null;
        }
        return configs.get(name);
    }

    public boolean getBoolean(SettingEnum name) {
        if ("Y".equals(getString(name)) == true) {
            return true;
        }
        return false;
    }
}
