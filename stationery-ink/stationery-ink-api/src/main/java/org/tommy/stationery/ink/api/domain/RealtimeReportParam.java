package org.tommy.stationery.ink.api.domain;

import org.tommy.stationery.ink.api.enums.RealtimeReportTypeEnum;

/**
 * Created by kun7788 on 15. 3. 9..
 */
public class RealtimeReportParam {
    private Long mkrSeq;
    private Long mbrSeq;
    private Long campaignSeq;
    private Long adgroupSeq;
    private Long adSeq;
    private Long adcontentSeq;
    private String areatype;
    private Long beginDt;
    private Long endDt;
    private Long dt;
    private String dtStr;
    private RealtimeReportTypeEnum type;

    public Long getMkrSeq() {
        return mkrSeq;
    }

    public void setMkrSeq(Long mkrSeq) {
        this.mkrSeq = mkrSeq;
    }

    public Long getMbrSeq() {
        return mbrSeq;
    }

    public void setMbrSeq(Long mbrSeq) {
        this.mbrSeq = mbrSeq;
    }

    public Long getCampaignSeq() {
        return campaignSeq;
    }

    public void setCampaignSeq(Long campaignSeq) {
        this.campaignSeq = campaignSeq;
    }

    public Long getAdgroupSeq() {
        return adgroupSeq;
    }

    public void setAdgroupSeq(Long adgroupSeq) {
        this.adgroupSeq = adgroupSeq;
    }

    public Long getAdSeq() {
        return adSeq;
    }

    public void setAdSeq(Long adSeq) {
        this.adSeq = adSeq;
    }

    public Long getAdcontentSeq() {
        return adcontentSeq;
    }

    public void setAdcontentSeq(Long adcontentSeq) {
        this.adcontentSeq = adcontentSeq;
    }

    public String getAreatype() {
        return areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype;
    }

    public Long getBeginDt() {
        return beginDt;
    }

    public void setBeginDt(Long beginDt) {
        this.beginDt = beginDt;
    }

    public Long getEndDt() {
        return endDt;
    }

    public void setEndDt(Long endDt) {
        this.endDt = endDt;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public String getDtStr() {
        return dtStr;
    }

    public void setDtStr(String dtStr) {
        this.dtStr = dtStr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mkrSeq);
        sb.append(mbrSeq);
        sb.append(campaignSeq);
        sb.append(adgroupSeq);
        sb.append(adSeq);
        sb.append(adcontentSeq);
        sb.append(areatype);
        sb.append(beginDt);
        sb.append(endDt);
        sb.append(type.getName());
        return sb.toString();
    }

    public String toRenewString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mkrSeq);
        sb.append(mbrSeq);
        sb.append(campaignSeq);
        sb.append(adgroupSeq);
        sb.append(adSeq);
        sb.append(adcontentSeq);
        sb.append(areatype);
        sb.append(type.getName());
        return sb.toString();
    }

    public RealtimeReportTypeEnum getType() {
        return type;
    }

    public void setType(RealtimeReportTypeEnum type) {
        this.type = type;
    }
}
