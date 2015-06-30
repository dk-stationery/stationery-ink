package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.hdfs.common.security;

/**
 * Created by kun7788 on 15. 3. 25..
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.security.SecurityUtil;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.IOException;
import java.util.Map;

/**
 * This class provides util methods for storm-hdfs connector communicating
 * with secured HDFS.
 */
public class HdfsSecurityUtil {
    public static final String STORM_KEYTAB_FILE_KEY = "hdfs.keytab.file";
    public static final String STORM_USER_NAME_KEY = "hdfs.kerberos.principal";

    public static void login(Map conf, Configuration hdfsConfig) throws IOException {
        if (UserGroupInformation.isSecurityEnabled()) {
            String keytab = (String) conf.get(STORM_KEYTAB_FILE_KEY);
            if (keytab != null) {
                hdfsConfig.set(STORM_KEYTAB_FILE_KEY, keytab);
            }
            String userName = (String) conf.get(STORM_USER_NAME_KEY);
            if (userName != null) {
                hdfsConfig.set(STORM_USER_NAME_KEY, userName);
            }
            SecurityUtil.login(hdfsConfig, STORM_KEYTAB_FILE_KEY, STORM_USER_NAME_KEY);
        }
    }
}