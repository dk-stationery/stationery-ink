package org.tommy.stationery.ink.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tommy.stationery.ink.api.service.DynamicApiService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 9..
 */
@RestController
@RequestMapping("/dynamic/api")
public class DynamicApiController {

    @Autowired
    DynamicApiService dynamicApiService;


    @RequestMapping("/{apiName}")
    public List<HashMap<String, String>> getDynamicApi(@PathVariable("apiName") String apiName, HttpServletRequest request) throws Exception {

        List<HashMap<String, String>> info = dynamicApiService.getDynamicApi(apiName, request);
        return info;
    }
}
