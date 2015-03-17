package org.tommy.stationery.ink.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tommy.stationery.ink.api.component.CacheDataUtil;
import org.tommy.stationery.ink.api.component.ParallelPhoenixScanUtil;

/**
 * Created by kun7788 on 15. 3. 10..
 */

@RestController
@RequestMapping("/manage/api")
public class ManageApiController {

    @Autowired
    CacheDataUtil cacheDataUtil;

    @RequestMapping("/expireGlobalCache")
    public String expireGlobalCache(@RequestParam(value = "val", required = true) String val) throws Exception {
        String GLOBAL_CACHED_KEY = cacheDataUtil.generateKey(ParallelPhoenixScanUtil.GLOBALCACHED_PREFIX_KEY, "", null);
        cacheDataUtil.put(GLOBAL_CACHED_KEY, val, 60 * 60 * 24 * 1000);

        if (cacheDataUtil.exist(GLOBAL_CACHED_KEY)) {
            String GLOBAL_CACHED_VAL = cacheDataUtil.get(GLOBAL_CACHED_KEY);
            return "GLOBAL_CACHED_KEY : " + GLOBAL_CACHED_KEY + " : VALUE : " + GLOBAL_CACHED_VAL + " changed.";
        }
        return "FAILED";
    }
}
