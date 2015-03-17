package org.tommy.stationery.ink.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;
import org.tommy.stationery.ink.api.mapper.RealtimeReportApiMapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 9..
 */
@Component
public class RealtimeReportApiDao implements RealtimeReportApiMapper {

    @Autowired
    RealtimeReportApiMapper realtimeReportApiMapper;

    @Override
    public List<HashMap<String, String>> getRealtimeReportGroupByMkrSeq(RealtimeReportParam realtimeReportParam) {
        return realtimeReportApiMapper.getRealtimeReportGroupByMkrSeq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeReportGroupByMbrSeq(RealtimeReportParam realtimeReportParam) {
        return realtimeReportApiMapper.getRealtimeReportGroupByMbrSeq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeReportGroupByCampaignSeq(RealtimeReportParam realtimeReportParam) {
        return realtimeReportApiMapper.getRealtimeReportGroupByCampaignSeq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeReportGroupByAdgroupSeq(RealtimeReportParam realtimeReportParam) {
        return realtimeReportApiMapper.getRealtimeReportGroupByAdgroupSeq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeReportGroupByAdSeq(RealtimeReportParam realtimeReportParam) {
        return realtimeReportApiMapper.getRealtimeReportGroupByAdSeq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeReportGroupByAdcontentSeq(RealtimeReportParam realtimeReportParam) {
        return realtimeReportApiMapper.getRealtimeReportGroupByAdcontentSeq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeReportGroupByAreaType(RealtimeReportParam realtimeReportParam) {
        return realtimeReportApiMapper.getRealtimeReportGroupByAreaType(realtimeReportParam);
    }
}
