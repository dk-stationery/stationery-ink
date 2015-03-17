package org.tommy.stationery.ink.api.component;

import org.tommy.stationery.ink.api.dao.RealtimeReportApiDao;
import org.tommy.stationery.ink.api.domain.RealtimeReportData;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;
import org.tommy.stationery.ink.api.enums.RealtimeReportTypeEnum;

import java.util.concurrent.Callable;

/**
 * Created by kun7788 on 15. 3. 10..
 */
public class PhoenixScanCallable implements Callable {

    private RealtimeReportApiDao realtimeReportApiDao;
    private RealtimeReportParam realtimeReportParam;
    private String cacheKey;
    private Long dt;

    public PhoenixScanCallable(RealtimeReportApiDao realtimeReportApiDao, Long dt, String cacheKey, RealtimeReportParam realtimeReportParam) {
        this.realtimeReportParam = realtimeReportParam;
        this.realtimeReportApiDao = realtimeReportApiDao;
        this.cacheKey = cacheKey;
        this.dt = dt;
    }

    @Override
    public RealtimeReportData call() throws Exception {
        RealtimeReportParam param = new RealtimeReportParam();
        RealtimeReportData realtimeReportData = new RealtimeReportData();
        if (RealtimeReportTypeEnum.RealtimeReportGroupByMkrSeq.equals(realtimeReportParam.getType())) {
            param.setMkrSeq(realtimeReportParam.getMkrSeq());
            param.setDt(dt);
            realtimeReportData.setData(realtimeReportApiDao.getRealtimeReportGroupByMkrSeq(param));
        } else if (RealtimeReportTypeEnum.RealtimeReportGroupByMbrSeq.equals(realtimeReportParam.getType())) {
            param.setMkrSeq(realtimeReportParam.getMkrSeq());
            param.setMbrSeq(realtimeReportParam.getMbrSeq());
            param.setDt(dt);
            realtimeReportData.setData(realtimeReportApiDao.getRealtimeReportGroupByMbrSeq(param));
        } else if (RealtimeReportTypeEnum.RealtimeReportGroupByCampaignSeq.equals(realtimeReportParam.getType())) {
            param.setMkrSeq(realtimeReportParam.getMkrSeq());
            param.setMbrSeq(realtimeReportParam.getMbrSeq());
            param.setCampaignSeq(realtimeReportParam.getCampaignSeq());
            param.setDt(dt);
            realtimeReportData.setData(realtimeReportApiDao.getRealtimeReportGroupByCampaignSeq(param));
        } else if (RealtimeReportTypeEnum.RealtimeReportGroupByAdgroupSeq.equals(realtimeReportParam.getType())) {
            param.setMkrSeq(realtimeReportParam.getMkrSeq());
            param.setMbrSeq(realtimeReportParam.getMbrSeq());
            param.setCampaignSeq(realtimeReportParam.getCampaignSeq());
            param.setAdgroupSeq(realtimeReportParam.getAdgroupSeq());
            param.setDt(dt);
            realtimeReportData.setData(realtimeReportApiDao.getRealtimeReportGroupByAdgroupSeq(param));
        } else if (RealtimeReportTypeEnum.RealtimeReportGroupByAdSeq.equals(realtimeReportParam.getType())) {
            param.setMkrSeq(realtimeReportParam.getMkrSeq());
            param.setMbrSeq(realtimeReportParam.getMbrSeq());
            param.setCampaignSeq(realtimeReportParam.getCampaignSeq());
            param.setAdgroupSeq(realtimeReportParam.getAdgroupSeq());
            param.setAdSeq(realtimeReportParam.getAdSeq());
            param.setDt(dt);
            realtimeReportData.setData(realtimeReportApiDao.getRealtimeReportGroupByAdSeq(param));
        } else if (RealtimeReportTypeEnum.RealtimeReportGroupByAdcontentSeq.equals(realtimeReportParam.getType())) {
            param.setMkrSeq(realtimeReportParam.getMkrSeq());
            param.setMbrSeq(realtimeReportParam.getMbrSeq());
            param.setCampaignSeq(realtimeReportParam.getCampaignSeq());
            param.setAdgroupSeq(realtimeReportParam.getAdgroupSeq());
            param.setAdSeq(realtimeReportParam.getAdSeq());
            param.setAdcontentSeq(realtimeReportParam.getAdcontentSeq());
            param.setDt(dt);
            realtimeReportData.setData(realtimeReportApiDao.getRealtimeReportGroupByAdcontentSeq(param));
        } else if (RealtimeReportTypeEnum.RealtimeReportGroupByAreaType.equals(realtimeReportParam.getType())) {
            param.setMkrSeq(realtimeReportParam.getMkrSeq());
            param.setMbrSeq(realtimeReportParam.getMbrSeq());
            param.setCampaignSeq(realtimeReportParam.getCampaignSeq());
            param.setAdgroupSeq(realtimeReportParam.getAdgroupSeq());
            param.setAdSeq(realtimeReportParam.getAdSeq());
            param.setAdcontentSeq(realtimeReportParam.getAdcontentSeq());
            param.setAreatype(realtimeReportParam.getAreatype());
            param.setDt(dt);
            realtimeReportData.setData(realtimeReportApiDao.getRealtimeReportGroupByAreaType(param));
        } else {
            throw new Exception("ERROR");
        }

        realtimeReportData.setRealtimeReportParam(realtimeReportParam);
        realtimeReportData.setCachedKey(cacheKey);
        return realtimeReportData;
    }

    public void setRealtimeReportApiDao(RealtimeReportApiDao realtimeReportApiDao) {
        this.realtimeReportApiDao = realtimeReportApiDao;
    }
}
