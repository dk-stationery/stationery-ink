package org.tommy.stationery.ink.core.storm.bolt;

import backtype.storm.contrib.signals.bolt.BaseSignalBolt;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
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
import java.util.Map;

/**
 * Created by kun7788 on 15. 3. 18..
 */
public class DumpAndLogBolt extends BaseSignalBolt implements IRichBolt {

    public static Logger logger = LoggerFactory.getLogger(DumpAndLogBolt.class);
    private List<Dump> cachedDumps = new ArrayList<Dump>(100);
    private OutputCollector collector;
    private DumpUtil dumpUtil;
    private InkConfig inkConfig;
    private int dumpCnt = 0;
    private static int DUMP_LIMIT_CNT = 5;
    private boolean isDump = false;

    public DumpAndLogBolt(String streamId, InkConfig inkConfig) {
        super(inkConfig.getString(SettingEnum.JOB_NAME));
        this.inkConfig = inkConfig;
    }

    @Override
    public void prepare(Map stormConf, TopologyContext context,
                        OutputCollector collector) {
        super.prepare(stormConf, context, collector);
        dumpUtil = new DumpUtil();
        this.collector = collector;
    }

    private void dump(Tuple tuple) {
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
                dump(rows);
            }
        }
    }

    private void dump(HashMap<String, String> data) {

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
            dumpCnt = 0;
            //clear
            cachedDumps.clear();
        }
    }

    @Override
    public void execute(Tuple tuple) {
        try {
            if (isDump == false) {
                dump(tuple);
            }
        } finally {
            collector.ack(tuple);
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public void onSignal(byte[] bytes) {
        try {
            logger.info("SIGNAL === RECEIVED");
            isDump = true;

            //flush
            String jobName = inkConfig.getString(SettingEnum.JOB_NAME);
            if (jobName != null) {
                String DUMP_FLUSH_API_URL = inkConfig.getString(SettingEnum.DUMP_FLUSH_API_URL);
                if (cachedDumps.size() > 0) {
                    dumpUtil.flush(jobName, DUMP_FLUSH_API_URL, cachedDumps);
                }
            }
        } finally {
            //clear
            cachedDumps.clear();
            isDump = false;
        }
    }
}
