package org.tommy.stationery.ink.api.enums;

/**
 * Created by kun7788 on 15. 3. 10..
 */
public enum RealtimeReportTypeEnum {
    RealtimeMemberReportGroupByCampaignByMbrseq("getRealtimeMemberReportGroupByCampaignByMbrseq"),
    RealtimeMemberReportGroupByAdgroupByCampaignseq("getRealtimeMemberReportGroupByAdgroupByCampaignseq"),
    RealtimeMemberReportGroupByAdByAdgroupseq("getRealtimeMemberReportGroupByAdByAdgroupseq"),
    RealtimeMemberReportGroupByAdcontentByAdgroupseq("getRealtimeMemberReportGroupByAdcontentByAdgroupseq"),
    RealtimeMemberReportGroupByAreatypeByCampaignseq("getRealtimeMemberReportGroupByAreatypeByCampaignseq"),
    RealtimeMemberReportGroupByAreatypeByAdgroupseq("getRealtimeMemberReportGroupByAreatypeByAdgroupseq"),
    RealtimeMemberReportGroupByAreatypeByAdseq("getRealtimeMemberReportGroupByAreatypeByAdseq"),
    RealtimeMemberReportGroupByAreatypeByAdcontentseq("getRealtimeMemberReportGroupByAreatypeByAdcontentseq"),

    RealtimeMarketerReportGroupByMkrByMkrseqs("getRealtimeMarketerReportGroupByMkrByMkrseqs"),
    RealtimeMarketerReportGroupByAreatypeByMkrseqs("getRealtimeMarketerReportGroupByAreatypeByMkrseqs")
    ;

    private String name;

    public String getName() {
        return name;
    }

    private RealtimeReportTypeEnum(String name) {
        this.name = name;
    }
}
