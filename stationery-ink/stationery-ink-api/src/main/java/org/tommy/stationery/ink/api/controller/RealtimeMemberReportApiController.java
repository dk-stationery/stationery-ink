package org.tommy.stationery.ink.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tommy.stationery.ink.api.service.RealtimeMemberReportApiService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 19..
 */
@RestController
@RequestMapping("/realtime/member")
public class RealtimeMemberReportApiController {

    @Autowired
    RealtimeMemberReportApiService realtimeMemberReportApiService;

    @RequestMapping("/getRealtimeMemberReportGroupByCampaignByMbrseq")
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByCampaignByMbrseq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq) throws Exception {
        return realtimeMemberReportApiService.getRealtimeMemberReportGroupByCampaignByMbrseq(beginDt, endDt, mbrSeq);
    }

    @RequestMapping("/getRealtimeMemberReportGroupByAdgroupByCampaignseq")
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdgroupByCampaignseq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq) throws Exception {
        return realtimeMemberReportApiService.getRealtimeMemberReportGroupByAdgroupByCampaignseq(beginDt, endDt, mbrSeq, campaignSeq);
    }

    @RequestMapping("/getRealtimeMemberReportGroupByAdByAdgroupseq")
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdByAdgroupseq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq,  @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq) throws Exception {
        return realtimeMemberReportApiService.getRealtimeMemberReportGroupByAdByAdgroupseq(beginDt, endDt, mbrSeq, campaignSeq, adgroupSeq);
    }

    @RequestMapping("/getRealtimeMemberReportGroupByAdcontentByAdgroupseq")
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdcontentByAdgroupseq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq,  @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq) throws Exception {
        return realtimeMemberReportApiService.getRealtimeMemberReportGroupByAdcontentByAdgroupseq(beginDt, endDt, mbrSeq, campaignSeq, adgroupSeq);
    }

    @RequestMapping("/getRealtimeMemberReportGroupByAreatypeByCampaignseq")
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByCampaignseq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq) throws Exception {
        return realtimeMemberReportApiService.getRealtimeMemberReportGroupByAreatypeByCampaignseq(beginDt, endDt, mbrSeq, campaignSeq);
    }

    @RequestMapping("/getRealtimeMemberReportGroupByAreatypeByAdgroupseq")
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdgroupseq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq, @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq) throws Exception {
        return realtimeMemberReportApiService.getRealtimeMemberReportGroupByAreatypeByAdgroupseq(beginDt, endDt, mbrSeq, campaignSeq, adgroupSeq);
    }

    @RequestMapping("/getRealtimeMemberReportGroupByAreatypeByAdseq")
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdseq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq, @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq, @RequestParam(value = "adSeq", required = true) Long adSeq) throws Exception {
        return realtimeMemberReportApiService.getRealtimeMemberReportGroupByAreatypeByAdseq(beginDt, endDt, mbrSeq, campaignSeq, adgroupSeq, adSeq);
    }

    @RequestMapping("/getRealtimeMemberReportGroupByAreatypeByAdcontentseq")
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdcontentseq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq, @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq, @RequestParam(value = "adcontentSeq", required = true) Long adcontentSeq) throws Exception {
        return realtimeMemberReportApiService.getRealtimeMemberReportGroupByAreatypeByAdcontentseq(beginDt, endDt, mbrSeq, campaignSeq, adgroupSeq, adcontentSeq);
    }
}
