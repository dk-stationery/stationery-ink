package org.tommy.stationery.ink.core.util;

import org.tommy.stationery.ink.domain.BaseMetaDef;
import org.tommy.stationery.ink.enums.MetaFieldEnum;

import java.util.List;

/**
 * Created by kun7788 on 15. 2. 9..
 */
public class MetaFinderUtil {

    public static BaseMetaDef findMeta(List<BaseMetaDef> metas, MetaFieldEnum field) {
        for (BaseMetaDef meta : metas) {
            if (meta.getName().equals(field.getName())) {
                return meta;
            }
        }
        return null;
    }
}
