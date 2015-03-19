package org.tommy.stationery.ink.api.mapper;

import org.springframework.stereotype.Repository;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 19..
 */
@Repository(value="realtimeMemberReportApiMapper")
public interface RealtimeMemberReportApiMapper {
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByCampaignByMbrseq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdgroupByCampaignseq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdByAdgroupseq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAdcontentByAdgroupseq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByCampaignseq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdgroupseq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdseq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeMemberReportGroupByAreatypeByAdcontentseq(RealtimeReportParam realtimeReportParam);
}
