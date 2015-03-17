package org.tommy.stationery.ink.core.util;

import org.tommy.stationery.ink.enums.ColumnDataTypeEnum;

/**
 * Created by kun7788 on 15. 2. 6..
 */
public class TypeConversionUtil {

    public static Object convertion(String val, ColumnDataTypeEnum columnDataTypeEnum) {
        if (columnDataTypeEnum.getZlass().equals(String.class)) {
            return val;
        } else if (columnDataTypeEnum.getZlass().equals(Integer.class)) {
            return Integer.valueOf(val);
        } else if (columnDataTypeEnum.getZlass().equals(Float.class)) {
            return Float.valueOf(val);
        } else if (columnDataTypeEnum.getZlass().equals(Double.class)) {
            return Double.valueOf(val);
        } else {
            //모두 틀리면 STRING값으로 넘긴다!
            return val;
        }
    }
}
