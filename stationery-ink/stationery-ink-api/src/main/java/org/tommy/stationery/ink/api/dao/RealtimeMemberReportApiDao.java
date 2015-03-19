package org.tommy.stationery.ink.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;
import org.tommy.stationery.ink.api.mapper.RealtimeMemberReportApiMapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 19..
 */
@Component
public class RealtimeMemberReportApiDao implements RealtimeMemberReportApiMapper {

    @Autowired
    RealtimeMemberReportApiMapper realtimeMemberReportApiMapper;

    @Override
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByCampaignByMbrseq(RealtimeReportParam realtimeReportParam) {
        return realtimeMemberReportApiMapper.getRealtimeMemberReportGroupByCampaignByMbrseq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdgroupByCampaignseq(RealtimeReportParam realtimeReportParam) {
        return realtimeMemberReportApiMapper.getRealtimeMemberReportGroupByAdgroupByCampaignseq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdByAdgroupseq(RealtimeReportParam realtimeReportParam) {
        return realtimeMemberReportApiMapper.getRealtimeMemberReportGroupByAdByAdgroupseq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdcontentByAdgroupseq(RealtimeReportParam realtimeReportParam) {
        return realtimeMemberReportApiMapper.getRealtimeMemberReportGroupByAdcontentByAdgroupseq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByCampaignseq(RealtimeReportParam realtimeReportParam) {
        return realtimeMemberReportApiMapper.getRealtimeMemberReportGroupByAreatypeByCampaignseq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdgroupseq(RealtimeReportParam realtimeReportParam) {
        return realtimeMemberReportApiMapper.getRealtimeMemberReportGroupByAreatypeByAdgroupseq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdseq(RealtimeReportParam realtimeReportParam) {
        return realtimeMemberReportApiMapper.getRealtimeMemberReportGroupByAreatypeByAdseq(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdcontentseq(RealtimeReportParam realtimeReportParam) {
        return realtimeMemberReportApiMapper.getRealtimeMemberReportGroupByAreatypeByAdcontentseq(realtimeReportParam);
    }
}
