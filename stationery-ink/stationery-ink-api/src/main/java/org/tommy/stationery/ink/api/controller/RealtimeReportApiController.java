package org.tommy.stationery.ink.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tommy.stationery.ink.api.service.RealtimeReportApiService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 9..
 */
@RestController
@RequestMapping("/realtime/api")
public class RealtimeReportApiController {

    @Autowired
    RealtimeReportApiService realtimeReportApiService;

    @RequestMapping("/getRealtimeReportGroupByMkrSeq")
    public List<HashMap<String, String>> getRealtimeReportGroupByMkrSeq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeq", required = true) Long mkrSeq) throws Exception {
        return realtimeReportApiService.getRealtimeReportGroupByMkrSeq(beginDt, endDt, mkrSeq);
    }

    @RequestMapping("/getRealtimeReportGroupByMbrSeq")
    public List<HashMap<String, String>> getRealtimeReportGroupByMbrSeq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeq", required = true) Long mkrSeq, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq) throws Exception {
        return realtimeReportApiService.getRealtimeReportGroupByMbrSeq(beginDt, endDt, mkrSeq, mbrSeq);
    }

    @RequestMapping("/getRealtimeReportGroupByCampaignSeq")
    public List<HashMap<String, String>> getRealtimeReportGroupByCampaignSeq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeq", required = true) Long mkrSeq, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq) throws Exception {
        return realtimeReportApiService.getRealtimeReportGroupByCampaignSeq(beginDt, endDt, mkrSeq, mbrSeq, campaignSeq);
    }

    @RequestMapping("/getRealtimeReportGroupByAdgroupSeq")
    public List<HashMap<String, String>> getRealtimeReportGroupByAdgroupSeq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeq", required = true) Long mkrSeq, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq, @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq) throws Exception {
        return realtimeReportApiService.getRealtimeReportGroupByAdgroupSeq(beginDt, endDt, mkrSeq, mbrSeq, campaignSeq, adgroupSeq);
    }

    @RequestMapping("/getRealtimeReportGroupByAdSeq")
    public List<HashMap<String, String>> getRealtimeReportGroupByAdSeq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeq", required = true) Long mkrSeq, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq, @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq, @RequestParam(value = "adSeq", required = true) Long adSeq) throws Exception {
        return realtimeReportApiService.getRealtimeReportGroupByAdSeq(beginDt, endDt, mkrSeq, mbrSeq, campaignSeq, adgroupSeq, adSeq);
    }

    @RequestMapping("/getRealtimeReportGroupByAdcontentSeq")
    public List<HashMap<String, String>> getRealtimeReportGroupByAdcontentSeq(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeq", required = true) Long mkrSeq, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq, @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq, @RequestParam(value = "adSeq", required = true) Long adSeq, @RequestParam(value = "adcontentSeq", required = true) Long adcontentSeq) throws Exception {
        return realtimeReportApiService.getRealtimeReportGroupByAdcontentSeq(beginDt, endDt, mkrSeq, mbrSeq, campaignSeq, adgroupSeq, adSeq, adcontentSeq);
    }

    @RequestMapping("/getRealtimeReportGroupByAreaType")
    public List<HashMap<String, String>> getRealtimeReportGroupByAreaType(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeq", required = true) Long mkrSeq, @RequestParam(value = "mbrSeq", required = true) Long mbrSeq, @RequestParam(value = "campaignSeq", required = true) Long campaignSeq, @RequestParam(value = "adgroupSeq", required = true) Long adgroupSeq, @RequestParam(value = "adSeq", required = true) Long adSeq, @RequestParam(value = "adcontentSeq", required = true) Long adcontentSeq, @RequestParam(value = "areaType", required = true) String areaType) throws Exception {
        return realtimeReportApiService.getRealtimeReportGroupByAreaType(beginDt, endDt, mkrSeq, mbrSeq, campaignSeq, adgroupSeq, adSeq, adcontentSeq, areaType);
    }
}
