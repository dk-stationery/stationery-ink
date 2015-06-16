package org.tommy.stationery.ink.core.config;

import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.enums.SettingEnum;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by kun7788 on 15. 1. 20..
 */
public class ConfigProperties {

    private Properties properties;

    public ConfigProperties(String configFilePath) throws IOException {
        properties = new Properties();
        try {
            properties.load(ConfigProperties.class.getResourceAsStream(configFilePath));
        }catch(Exception ex) {
            InputStream in = null;
            try {
                in = new FileInputStream(configFilePath);
            } catch (FileNotFoundException e1) {
                throw new IOException(e1.getMessage());
            }
            properties.load(in);
        }
    }

    public InkConfig getDefaultInkConfig () {
        InkConfig inkConfig = new InkConfig();
        for (SettingEnum configEnum : SettingEnum.values()) {
            inkConfig.put(configEnum, this.getString(configEnum));
        }
        return inkConfig;
    }

    public InkConfig mergeInkConfig (InkConfig defaultConfig, InkConfig customInkConfig) {
        InkConfig inkConfig = defaultConfig;

        for (SettingEnum configEnum : SettingEnum.values()) {
            if (customInkConfig.getString(configEnum) != null) {
                inkConfig.put(configEnum, customInkConfig.getString(configEnum));
            }
        }
        return inkConfig;
    }


    public List<String> getList(SettingEnum config) {
        String val = properties.getProperty(config.getName());
        List<String> list = new ArrayList<String>(Arrays.asList(val.split(",")));
        return list;
    }

    public String getString(SettingEnum config) {
        String val = properties.getProperty(config.getName());
        if (val == null) {
            return null;
        }
        return val;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
