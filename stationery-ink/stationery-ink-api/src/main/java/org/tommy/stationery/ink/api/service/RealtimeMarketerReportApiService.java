package org.tommy.stationery.ink.api.service;

import org.apache.hadoop.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.api.annotation.CacheData;
import org.tommy.stationery.ink.api.component.ParallelPhoenixScanUtil;
import org.tommy.stationery.ink.api.dao.RealtimeMarketerReportApiDao;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;
import org.tommy.stationery.ink.api.enums.RealtimeReportTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 19..
 */
@Service
public class RealtimeMarketerReportApiService {

    @Autowired
    RealtimeMarketerReportApiDao realtimeMarketerReportApiDao;

    @Autowired
    ParallelPhoenixScanUtil parallelPhoenixScanUtil;

    @CacheData
    public List<HashMap<String, String>> getRealtimeMarketerReportGroupByMkrByMkrseqs(Long beginDt, Long endDt, String mkrSeqs) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setInQuery(StringUtils.join(",", mkrSeqs.split(",")));
        param.setType(RealtimeReportTypeEnum.RealtimeMarketerReportGroupByMkrByMkrseqs);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeMarketerReportGroupByAreatypeByMkrseqs(Long beginDt, Long endDt, String mkrSeqs) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setInQuery(StringUtils.join(",", mkrSeqs.split(",")));
        param.setType(RealtimeReportTypeEnum.RealtimeMarketerReportGroupByAreatypeByMkrseqs);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

}
