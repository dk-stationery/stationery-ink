package org.tommy.stationery.ink.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tommy.stationery.ink.api.annotation.CacheData;
import org.tommy.stationery.ink.api.component.ParallelPhoenixScanUtil;
import org.tommy.stationery.ink.api.dao.RealtimeMemberReportApiDao;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;
import org.tommy.stationery.ink.api.enums.RealtimeReportTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 19..
 */
@Service
public class RealtimeMemberReportApiService {

    @Autowired
    RealtimeMemberReportApiDao realtimeMemberReportApiDao;

    @Autowired
    ParallelPhoenixScanUtil parallelPhoenixScanUtil;

    @CacheData
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByCampaignByMbrseq(Long beginDt, Long endDt, Long mbrSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMbrSeq(mbrSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeMemberReportGroupByCampaignByMbrseq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdgroupByCampaignseq(Long beginDt, Long endDt, Long mbrSeq, Long campaignSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeMemberReportGroupByAdgroupByCampaignseq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdByAdgroupseq(Long beginDt, Long endDt, Long mbrSeq, Long campaignSeq, Long adgroupSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeMemberReportGroupByAdByAdgroupseq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdcontentByAdgroupseq(Long beginDt, Long endDt, Long mbrSeq, Long campaignSeq, Long adgroupSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeMemberReportGroupByAdcontentByAdgroupseq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByCampaignseq(Long beginDt, Long endDt, Long mbrSeq, Long campaignSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeMemberReportGroupByAreatypeByCampaignseq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdgroupseq(Long beginDt, Long endDt, Long mbrSeq, Long campaignSeq, Long adgroupSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeMemberReportGroupByAreatypeByAdgroupseq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdseq(Long beginDt, Long endDt, Long mbrSeq, Long campaignSeq, Long adgroupSeq, Long adSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setAdSeq(adSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeMemberReportGroupByAreatypeByAdseq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }

    @CacheData
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdcontentseq(Long beginDt, Long endDt, Long mbrSeq, Long campaignSeq, Long adgroupSeq, Long adcontentSeq) throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setBeginDt(beginDt);
        param.setEndDt(endDt);
        param.setMbrSeq(mbrSeq);
        param.setCampaignSeq(campaignSeq);
        param.setAdgroupSeq(adgroupSeq);
        param.setAdcontentSeq(adcontentSeq);
        param.setType(RealtimeReportTypeEnum.RealtimeMemberReportGroupByAreatypeByAdcontentseq);

        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();
        reports.addAll(parallelPhoenixScanUtil.getRealtimeReportForParallels(parallelPhoenixScanUtil.getBetweenDt(param), param, ParallelPhoenixScanUtil.OLD_REPORT_DATA_CACHE_EXPIRE_TIME));
        return reports;
    }
}
