package org.tommy.stationery.ink.api.component;

import org.tommy.stationery.ink.api.dao.RealtimeMarketerReportApiDao;
import org.tommy.stationery.ink.api.dao.RealtimeMemberReportApiDao;
import org.tommy.stationery.ink.api.domain.RealtimeReportData;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;
import org.tommy.stationery.ink.api.enums.RealtimeReportTypeEnum;

import java.util.concurrent.Callable;

/**
 * Created by kun7788 on 15. 3. 10..
 */
public class PhoenixScanCallable implements Callable {

    private RealtimeMemberReportApiDao realtimeMemberReportApiDao;
    private RealtimeMarketerReportApiDao realtimeMarketerReportApiDao;

    private RealtimeReportParam realtimeReportParam;
    private String cacheKey;
    private Long dt;

    public PhoenixScanCallable(RealtimeMarketerReportApiDao realtimeMarketerReportApiDao, RealtimeMemberReportApiDao realtimeMemberReportApiDao, Long dt, String cacheKey, RealtimeReportParam realtimeReportParam) {
        this.realtimeReportParam = realtimeReportParam;
        this.realtimeMarketerReportApiDao = realtimeMarketerReportApiDao;
        this.realtimeMemberReportApiDao = realtimeMemberReportApiDao;
        this.cacheKey = cacheKey;
        this.dt = dt;
    }

    private RealtimeReportParam cloneParam(RealtimeReportParam src, Long dt) {
        RealtimeReportParam param = new RealtimeReportParam();
        param.setInQuery(src.getInQuery());
        param.setMkrSeq(src.getMkrSeq());
        param.setMbrSeq(src.getMbrSeq());
        param.setCampaignSeq(src.getCampaignSeq());
        param.setAdgroupSeq(src.getAdgroupSeq());
        param.setAdSeq(src.getAdSeq());
        param.setAdcontentSeq(src.getAdcontentSeq());
        param.setAreatype(src.getAreatype());
        param.setDt(src.getDt());
        param.setBeginDt(src.getBeginDt());
        param.setEndDt(src.getEndDt());
        param.setDt(dt);
        return param;
    }

    @Override
    public RealtimeReportData call() throws Exception {
        RealtimeReportParam param = cloneParam(realtimeReportParam, dt);
        RealtimeReportData realtimeReportData = new RealtimeReportData();
        if (RealtimeReportTypeEnum.RealtimeMemberReportGroupByCampaignByMbrseq.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMemberReportApiDao.getRealtimeMemberReportGroupByCampaignByMbrseq(param));
        } else if (RealtimeReportTypeEnum.RealtimeMemberReportGroupByAdgroupByCampaignseq.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMemberReportApiDao.getRealtimeMemberReportGroupByAdgroupByCampaignseq(param));
        } else if (RealtimeReportTypeEnum.RealtimeMemberReportGroupByAdByAdgroupseq.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMemberReportApiDao.getRealtimeMemberReportGroupByAdByAdgroupseq(param));
        } else if (RealtimeReportTypeEnum.RealtimeMemberReportGroupByAdcontentByAdgroupseq.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMemberReportApiDao.getRealtimeMemberReportGroupByAdcontentByAdgroupseq(param));
        } else if (RealtimeReportTypeEnum.RealtimeMemberReportGroupByAreatypeByCampaignseq.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMemberReportApiDao.getRealtimeMemberReportGroupByAreatypeByCampaignseq(param));
        } else if (RealtimeReportTypeEnum.RealtimeMemberReportGroupByAreatypeByAdgroupseq.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMemberReportApiDao.getRealtimeMemberReportGroupByAreatypeByAdgroupseq(param));
        } else if (RealtimeReportTypeEnum.RealtimeMemberReportGroupByAreatypeByAdseq.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMemberReportApiDao.getRealtimeMemberReportGroupByAreatypeByAdseq(param));
        }  else if (RealtimeReportTypeEnum.RealtimeMemberReportGroupByAreatypeByAdcontentseq.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMemberReportApiDao.getRealtimeMemberReportGroupByAreatypeByAdcontentseq(param));
        }   else if (RealtimeReportTypeEnum.RealtimeMarketerReportGroupByMkrByMkrseqs.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMarketerReportApiDao.getRealtimeMarketerReportGroupByMkrByMkrseqs(param));
        }  else if (RealtimeReportTypeEnum.RealtimeMarketerReportGroupByAreatypeByMkrseqs.equals(realtimeReportParam.getType())) {
            realtimeReportData.setData(realtimeMarketerReportApiDao.getRealtimeMarketerReportGroupByAreatypeByMkrseqs(param));
        } else {
            throw new Exception("ERROR");
        }

        realtimeReportData.setRealtimeReportParam(realtimeReportParam);
        realtimeReportData.setCachedKey(cacheKey);
        return realtimeReportData;
    }
}
