package org.tommy.stationery.ink.core.storm.bolt;

import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.enums.SettingEnum;
import org.tommy.stationery.ink.util.DumpUtil;
import org.tommy.stationery.ink.util.domain.Dump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 27..
 */
public class GenericDumpBoltUtils {
    public static Logger logger = LoggerFactory.getLogger(GenericDumpBoltUtils.class);

    private List<Dump> cachedDumps = new ArrayList<Dump>(1000);
    private DumpUtil dumpUtil = new DumpUtil();

    private int dumpCnt = 0;
    private static int DUMP_LIMIT_CNT = 10;

    public void dump(InkConfig inkConfig, Tuple tuple) {
        if (dumpCnt == -1) {
            return;
        } else {
            if (tuple != null) {
                StringBuilder sb = new StringBuilder();
                HashMap<String, String> rows = new HashMap<String, String>();
                for (int i=0;i<tuple.getFields().size();i++) {
                    String field = tuple.getFields().get(i);
                    Object val = tuple.getValueByField(field);
                    rows.put(field, val.toString());
                }
                dump(inkConfig, rows);
            }
        }
    }

    public void dump(InkConfig inkConfig, HashMap<String, String> data) {

        //collect
        if (dumpCnt == -1) {
            return;
        } else if (dumpCnt != -1 && dumpCnt < DUMP_LIMIT_CNT) {
            dumpCnt++;

            String jobName = inkConfig.getString(SettingEnum.JOB_NAME);
            if (jobName != null) {
                Dump dump = new Dump();
                dump.setData(data);
                cachedDumps.add(dump);
            }
        } else {
            dumpCnt = -1;

            //flush
            String jobName = inkConfig.getString(SettingEnum.JOB_NAME);
            if (jobName != null) {
                String DUMP_FLUSH_API_URL = inkConfig.getString(SettingEnum.DUMP_FLUSH_API_URL);
                dumpUtil.flush(jobName, DUMP_FLUSH_API_URL, cachedDumps);
            }
            //clear
            cachedDumps.clear();
        }
    }
}
