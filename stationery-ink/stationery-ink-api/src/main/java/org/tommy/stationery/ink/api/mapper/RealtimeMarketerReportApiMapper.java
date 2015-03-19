package org.tommy.stationery.ink.api.mapper;

import org.springframework.stereotype.Repository;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 19..
 */
@Repository(value="realtimeMarketerReportApiMapper")
public interface RealtimeMarketerReportApiMapper {
    public List<HashMap<String, String>> getRealtimeMarketerReportGroupByMkrByMkrseqs(RealtimeReportParam realtimeReportParam);
    public List<HashMap<String, String>> getRealtimeMarketerReportGroupByAreatypeByMkrseqs(RealtimeReportParam realtimeReportParam);
}
