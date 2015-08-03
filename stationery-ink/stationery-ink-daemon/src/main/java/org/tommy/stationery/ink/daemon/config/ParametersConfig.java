package org.tommy.stationery.ink.daemon.config;

import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by kun7788 on 14. 12. 19..
 */
public class ParametersConfig {
    public static final String DAEMON_ID = "daemon_id";
    public static final String MULTI_TENANTS = "multi_tenants";
    public static final String TENANT_NAME = "name";
    public static final String TENANT_URL = "url";
    public static final String SESSION_ID = "sessionId";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String SQL = "sql";

    private Map<String, Map<String, Object>> parameters;

    public ParametersConfig(String config) {
        ymlLoadAsResourceByArgFileName(config);
    }

    public Map<String, Map<String, Object>> getConfig() {
        return parameters;
    }

    public Object get(String key) {
        return getConfig().get(key);
    }

    private void ymlLoadAsResourceByArgFileName(String config) {
        String configFileName = System.getProperty(config);
        if (configFileName == null) {
            configFileName = "config-dev.yml";
        }

        Yaml yaml = new Yaml();
        try {
            InputStream in = new ClassPathResource(configFileName).getInputStream();
            parameters = (Map<String, Map<String, Object>>) yaml.load(in);
        } catch (Exception e) {
            InputStream in = null;
            try {
                in = new FileInputStream(configFileName);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            parameters = (Map<String, Map<String, Object>>) yaml.load(in);
        }
    }

    public Integer IntegerValueOf(String key) {
        if (key == null) return null;;
        return Integer.valueOf((String) get(key));
    }

    public String StringValueOf(String key) {
        if (key == null) return null;;
        return String.valueOf((String) get(key));
    }

    public List<Map<String, String>> ListValueOf(String key) {
        if (key == null) return null;;
        return (List<Map<String, String>>)get(key);
    }

    public static Integer IntegerValue(Object value) {
        if (value == null) return null;;
        return Integer.valueOf(value.toString());
    }

    public static String StringValue(Object value) {
        if (value == null) return null;
        return value.toString();
    }

    public static List<Map<String, String>> ListValue(Object value) {
        if (value == null) return null;
        return (List<Map<String, String>>)value;
    }
}
