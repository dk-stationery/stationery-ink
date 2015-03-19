package org.tommy.stationery.ink.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tommy.stationery.ink.api.service.RealtimeMarketerReportApiService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 19..
 */
@RestController
@RequestMapping("/realtime/marketer")
public class RealtimeMarketerReportApiController {

    @Autowired
    RealtimeMarketerReportApiService realtimeMarketerReportApiService;

    @RequestMapping("/getRealtimeMarketerReportGroupByMkrByMkrseqs")
    public List<HashMap<String, String>> getRealtimeMarketerReportGroupByMkrByMkrseqs(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeqs", required = true) String mkrSeqs) throws Exception {
        return realtimeMarketerReportApiService.getRealtimeMarketerReportGroupByMkrByMkrseqs(beginDt, endDt, mkrSeqs);
    }

    @RequestMapping("/getRealtimeMarketerReportGroupByAreatypeByMkrseqs")
    public List<HashMap<String, String>> getRealtimeMarketerReportGroupByAreatypeByMkrseqs(@RequestParam(value = "beginDt", required = true) Long beginDt, @RequestParam(value = "endDt", required = true) Long endDt, @RequestParam(value = "mkrSeqs", required = true) String mkrSeqs) throws Exception {
        return realtimeMarketerReportApiService.getRealtimeMarketerReportGroupByAreatypeByMkrseqs(beginDt, endDt, mkrSeqs);
    }

}
