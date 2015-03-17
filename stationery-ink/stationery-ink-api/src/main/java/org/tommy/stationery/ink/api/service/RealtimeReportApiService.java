package org.tommy.stationery.ink.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.api.annotation.CacheData;
import org.tommy.stationery.ink.api.component.ParallelPhoenixScanUtil;
import org.tommy.stationery.ink.api.dao.RealtimeReportApiDao;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;
import org.tommy.stationery.ink.api.enums.RealtimeReportTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 9..
 */
@Service
public class RealtimeReportApiService {

    @Autowired
    RealtimeReportApiDao realtimeReportApiDao;


    @Autowired
    ParallelPhoenixScanUtil parallelPhoenixScanUtil;

    private static int OLD_REPORT_DATA_CACHE_EXPIRE_TIME = 60*60*24;

    @CacheData
    public List<HashMap<String, String>> getRealtimeReportGroupByMkrSeq(Long beginDt, Long endDt, Long mkrSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMkrSeq(mkrSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeReportGroupByMkrSeq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeReportGroupByMbrSeq(Long beginDt, Long endDt, Long mkrSeq, Long mbrSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMkrSeq(mkrSeq);
        param.setMbrSeq(mbrSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeReportGroupByMbrSeq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeReportGroupByCampaignSeq(Long beginDt, Long endDt, Long mkrSeq, Long mbrSeq, Long campaignSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMkrSeq(mkrSeq);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeReportGroupByCampaignSeq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeReportGroupByAdgroupSeq(Long beginDt, Long endDt, Long mkrSeq, Long mbrSeq, Long campaignSeq, Long adgroupSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMkrSeq(mkrSeq);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeReportGroupByAdgroupSeq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeReportGroupByAdSeq(Long beginDt, Long endDt, Long mkrSeq, Long mbrSeq, Long campaignSeq, Long adgroupSeq, Long adSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMkrSeq(mkrSeq);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setAdSeq(adSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeReportGroupByAdSeq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeReportGroupByAdcontentSeq(Long beginDt, Long endDt, Long mkrSeq, Long mbrSeq, Long campaignSeq, Long adgroupSeq, Long adSeq, Long adcontentSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMkrSeq(mkrSeq);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setAdSeq(adSeq);
        param.setAdcontentSeq(adcontentSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeReportGroupByAdcontentSeq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeReportGroupByAreaType(Long beginDt, Long endDt, Long mkrSeq, Long mbrSeq, Long campaignSeq, Long adgroupSeq, Long adSeq, Long adcontentSeq, String areaType) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMkrSeq(mkrSeq);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setAdSeq(adSeq);
        param.setAdcontentSeq(adcontentSeq);
        param.setAreatype(areaType);
        param.setType(RealtimeReportTypeEnum.RealtimeReportGroupByAreaType);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }
}
