package org.tommy.stationery.ink.api.enums;

/**
 * Created by kun7788 on 15. 3. 10..
 */
public enum RealtimeReportTypeEnum {
    RealtimeReportGroupByMkrSeq("getRealtimeReportGroupByMkrSeq"),
    RealtimeReportGroupByMbrSeq("getRealtimeReportGroupByMbrSeq"),
    RealtimeReportGroupByCampaignSeq("getRealtimeReportGroupByCampaignSeq"),
    RealtimeReportGroupByAdgroupSeq("getRealtimeReportGroupByAdgroupSeq"),
    RealtimeReportGroupByAdSeq("getRealtimeReportGroupByAdSeq"),
    RealtimeReportGroupByAdcontentSeq("getRealtimeReportGroupByAdcontentSeq"),
    RealtimeReportGroupByAreaType("getRealtimeReportGroupByAreaType")
    ;

    private String name;

    public String getName() {
        return name;
    }

    private RealtimeReportTypeEnum(String name) {
        this.name = name;
    }
}
