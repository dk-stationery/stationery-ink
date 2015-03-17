package org.tommy.stationery.ink.api.domain;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 3. 10..
 */
public class RealtimeReportData {
    private String cachedKey;
    private RealtimeReportParam realtimeReportParam;
    private List<HashMap<String, String>> data;

    public RealtimeReportParam getRealtimeReportParam() {
        return realtimeReportParam;
    }

    public void setRealtimeReportParam(RealtimeReportParam realtimeReportParam) {
        this.realtimeReportParam = realtimeReportParam;
    }

    public List<HashMap<String, String>> getData() {
        return data;
    }

    public void setData(List<HashMap<String, String>> data) {
        this.data = data;
    }

    public String getCachedKey() {
        return cachedKey;
    }

    public void setCachedKey(String cachedKey) {
        this.cachedKey = cachedKey;
    }
}
