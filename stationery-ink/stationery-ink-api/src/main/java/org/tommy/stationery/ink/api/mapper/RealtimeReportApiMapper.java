package org.tommy.stationery.ink.api.mapper;

import org.springframework.stereotype.Repository;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 9..
 */
@Repository(value="realtimeReportApiMapper")
public interface RealtimeReportApiMapper {

    public List<HashMap<String, String>> getRealtimeReportGroupByMkrSeq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeReportGroupByMbrSeq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeReportGroupByCampaignSeq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeReportGroupByAdgroupSeq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeReportGroupByAdSeq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeReportGroupByAdcontentSeq(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeReportGroupByAreaType(RealtimeReportParam realtimeReportParam);
}