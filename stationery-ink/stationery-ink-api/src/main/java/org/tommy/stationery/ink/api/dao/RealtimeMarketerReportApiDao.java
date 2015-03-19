package org.tommy.stationery.ink.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;
import org.tommy.stationery.ink.api.mapper.RealtimeMarketerReportApiMapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 19..
 */
@Component
public class RealtimeMarketerReportApiDao implements RealtimeMarketerReportApiMapper {

    @Autowired
    RealtimeMarketerReportApiMapper realtimeMarketerReportApiMapper;

    @Override
    public List<HashMap<String, String>> getRealtimeMarketerReportGroupByMkrByMkrseqs(RealtimeReportParam realtimeReportParam) {
        return realtimeMarketerReportApiMapper.getRealtimeMarketerReportGroupByMkrByMkrseqs(realtimeReportParam);
    }

    @Override
    public List<HashMap<String, String>> getRealtimeMarketerReportGroupByAreatypeByMkrseqs(RealtimeReportParam realtimeReportParam) {
        return realtimeMarketerReportApiMapper.getRealtimeMarketerReportGroupByAreatypeByMkrseqs(realtimeReportParam);
    }
}
