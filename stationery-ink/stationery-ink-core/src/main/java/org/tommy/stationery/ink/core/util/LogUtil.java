package org.tommy.stationery.ink.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.enums.SettingEnum;

public class LogUtil {
	public static Logger logger = LoggerFactory.getLogger(LogUtil.class);
	
	public static boolean LOG(String title, String value, boolean isDebug)  {
		if (isDebug) {
			logger.info(title + " => " + value);
		}
		return isDebug;
	}

    public static void LOG(InkConfig inkConfig, Exception ex)  {
        if (inkConfig.getBoolean(SettingEnum.IS_DEBUG) == true) {
            logger.info(ex.getMessage());
        }
    }
}
