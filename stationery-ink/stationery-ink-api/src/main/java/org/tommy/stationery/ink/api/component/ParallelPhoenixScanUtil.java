package org.tommy.stationery.ink.api.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tommy.stationery.ink.api.dao.RealtimeMarketerReportApiDao;
import org.tommy.stationery.ink.api.dao.RealtimeMemberReportApiDao;
import org.tommy.stationery.ink.api.domain.RealtimeReportData;
import org.tommy.stationery.ink.api.domain.RealtimeReportParam;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by kun7788 on 15. 3. 10..
 */
@Component
public class ParallelPhoenixScanUtil {

    private static final Logger logger = LoggerFactory.getLogger(ParallelPhoenixScanUtil.class);

    private ExecutorService phoenixScanThreadPool = Executors.newFixedThreadPool(10);

    public static String GLOBALCACHED_PREFIX_KEY = "GLOBAL_CACHED_KEY";

    public static int OLD_REPORT_DATA_CACHE_EXPIRE_TIME = 60*60*24;

    @Autowired
    CacheDataUtil cacheDataUtil;

    @Autowired
    RealtimeMemberReportApiDao realtimeMemberReportApiDao;

    @Autowired
    RealtimeMarketerReportApiDao realtimeMarketerReportApiDao;


    public List<Long> getBetweenDt(RealtimeReportParam realtimeReportParam) {
        Long current = DateUtil.getCurrentDate();
        if (current < realtimeReportParam.getEndDt()) {
            logger.info("RESETTING because enddt is over current : " + current);
            realtimeReportParam.setEndDt(current);
        }
        if (current < realtimeReportParam.getBeginDt()) {
            logger.info("RESETTING because begindt is over current : " + current);
            realtimeReportParam.setBeginDt(current);
        }

        List<Long> dtList = DateUtil.getBetweenDateList(realtimeReportParam.getBeginDt(), realtimeReportParam.getEndDt());
        return dtList;
    }

    public List<Long> getBetweenCachedDt(RealtimeReportParam realtimeReportParam) {
        List<Long> dtList = getBetweenDt(realtimeReportParam);
        List<Long> cachedDtList = dtList.size() > 1 ? dtList.subList(0, dtList.size() - 1) : new ArrayList<Long>();
        return cachedDtList;
    }

    public List<Long> getBetweenFreshedDt(RealtimeReportParam realtimeReportParam) {
        List<Long> dtList = getBetweenDt(realtimeReportParam);
        List<Long> freshDtList = dtList.size() > 1 ? dtList.subList(dtList.size() - 1, dtList.size()) : dtList;
        return freshDtList;
    }

    public List<HashMap<String, String>> getRealtimeReportForParallels(List<Long> dtList, RealtimeReportParam realtimeReportParam, int cacheExpireTime) throws ExecutionException, InterruptedException, IOException {
        List<HashMap<String, String>> reports = new ArrayList<HashMap<String, String>>();

        if (dtList.size() <= 0) return reports;
        Set<Future<RealtimeReportData>> cachedSet = new HashSet<Future<RealtimeReportData>>();

        //global cache val
        String GLOBAL_CACHED_KEY = cacheDataUtil.generateKey(GLOBALCACHED_PREFIX_KEY, "", null);
        String GLOBAL_CACHED_VAL = GLOBALCACHED_PREFIX_KEY;
        if (cacheDataUtil.exist(GLOBAL_CACHED_KEY)) {
            GLOBAL_CACHED_VAL = cacheDataUtil.get(GLOBAL_CACHED_KEY);
            logger.info("GLOBAL_CACHED_KEY HIT : " + GLOBAL_CACHED_KEY + " : " + GLOBAL_CACHED_VAL);
        } else {
            logger.info("GLOBAL_CACHED_KEY CACHE MAKE : " + GLOBAL_CACHED_KEY + " : " + GLOBAL_CACHED_VAL);
            cacheDataUtil.put(GLOBAL_CACHED_KEY, GLOBALCACHED_PREFIX_KEY, 60 * 60 * 24 * 1000);
        }

        //old
        for (Long dt : getBetweenCachedDt(realtimeReportParam)) {
            String cachedKey = cacheDataUtil.generateKey("REALTIMEREPORT_DATA" + GLOBAL_CACHED_VAL + "_" + dt, realtimeReportParam.toRenewString(), null);
            if (cacheDataUtil.exist(cachedKey)) {
                logger.info("DT_CACHED_CACHE HIT : " + cachedKey + " : getRealtimeCachedReportForParallels");
                reports.addAll((List<HashMap<String, String>>)cacheDataUtil.getObject(cachedKey));
            } else {
                Callable<RealtimeReportData> callable = new PhoenixScanCallable(realtimeMarketerReportApiDao, realtimeMemberReportApiDao, dt, cachedKey, realtimeReportParam);
                Future<RealtimeReportData> future = phoenixScanThreadPool.submit(callable);
                cachedSet.add(future);
            }
        }

        for (Future<RealtimeReportData> future : cachedSet) {
            reports.addAll(future.get().getData());
            logger.info("DT_CACHED_CACHE MAKE : " + future.get().getCachedKey() + " : getRealtimeCachedReportForParallels : " + future.get().getData().size());
            cacheDataUtil.putObject(future.get().getCachedKey(), future.get().getData(), cacheExpireTime);
        }

        //fresh -1hr
        Set<Future<RealtimeReportData>> freshSet = new HashSet<Future<RealtimeReportData>>();

        for (Long dt : getBetweenFreshedDt(realtimeReportParam)) {
            String cachedKey = cacheDataUtil.generateKey("REALTIMEREPORT_DATA" + GLOBAL_CACHED_VAL + "_" + dt, realtimeReportParam.toRenewString(), null);
            if (cacheDataUtil.exist(cachedKey)) {
                logger.info("DT_FRESHED_CACHE HIT : " + cachedKey + " : getRealtimeCachedReportForParallels");
                reports.addAll((List<HashMap<String, String>>)cacheDataUtil.getObject(cachedKey));
            } else {
                Callable<RealtimeReportData> callable = new PhoenixScanCallable(realtimeMarketerReportApiDao, realtimeMemberReportApiDao, dt, cachedKey, realtimeReportParam);
                Future<RealtimeReportData> future = phoenixScanThreadPool.submit(callable);
                freshSet.add(future);
            }
        }

        for (Future<RealtimeReportData> future : freshSet) {
            logger.info("DT_FRESHED_CACHE MAKE : " + future.get().getCachedKey() + " : getRealtimeCachedReportForParallels");
            reports.addAll(future.get().getData());
            cacheDataUtil.putObject(future.get().getCachedKey(), future.get().getData(), CacheDataUtil.EXPIRE_SECONDS);
        }

        //sort
        Collections.sort(reports, new DtAscCompare());
        return reports;
    }

    static class DtAscCompare implements Comparator<HashMap<String, String>> {
        @Override
        public int compare(HashMap<String, String> o1, HashMap<String, String> o2) {
            Integer target1 = Integer.valueOf(String.valueOf(o1.get("DT")));
            Integer target2 = Integer.valueOf(String.valueOf(o2.get("DT")));
            return target1 < target2 ? -1 : target1 > target2 ? 1:0;
        }
    }
}
