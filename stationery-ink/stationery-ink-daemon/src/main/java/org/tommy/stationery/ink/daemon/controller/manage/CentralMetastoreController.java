package org.tommy.stationery.ink.daemon.controller.manage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kun7788 on 15. 4. 22..
 */

@RestController
@RequestMapping("/central/metastore")
public class CentralMetastoreController {

    @RequestMapping(value = "/getInkSources", method = RequestMethod.POST)
    public String getInkSources() throws Exception {
        return "SUCCEED";
    }

    @RequestMapping(value = "/getInkStreams", method = RequestMethod.POST)
    public String getInkStreams() throws Exception {
        return "SUCCEED";
    }
}