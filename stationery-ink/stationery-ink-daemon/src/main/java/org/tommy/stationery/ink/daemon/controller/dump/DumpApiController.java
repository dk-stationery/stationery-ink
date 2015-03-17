package org.tommy.stationery.ink.daemon.controller.dump;

import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tommy.stationery.ink.util.domain.Dump;
import org.tommy.stationery.ink.util.serde.JsonSerde;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kun7788 on 15. 3. 12..
 */
@RestController
@RequestMapping("/dump/api")
public class DumpApiController {

    private static final Logger logger = LoggerFactory.getLogger(DumpApiController.class);

    private JsonSerde jsonSerde = new JsonSerde();
    private Map<String, List<Dump>> localDump = new HashMap<String, List<Dump>>(1000);

    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public String clear(@RequestParam(value = "jobName", required = true) String jobName) throws Exception {
        localDump.put(jobName, new ArrayList<Dump>());
        logger.info("dump clear : " + jobName);
        return "SUCCEED";
    }

    @RequestMapping(value = "/flush", method = RequestMethod.POST)
    public String flush(@RequestParam(value = "jobName", required = true) String jobName, @RequestParam(value = "dump", required = true) String dump) throws Exception {
        List<Dump> deserializedDump = (List<Dump>)jsonSerde.deserialize(dump, new TypeReference<List<Dump>>() {});

        List<Dump> dumps = localDump.get(jobName);
        if (dumps == null || dumps.size() == 0) {
            localDump.put(jobName, deserializedDump);
        } else {
            dumps.addAll(deserializedDump);
            localDump.put(jobName, dumps);
        }

        logger.info("dump flush : " + dumps.toString());
        return "SUCCEED";
    }

    @RequestMapping(value = "/dump", method = RequestMethod.POST)
    public List<Dump> dump(@RequestParam(value = "jobName", required = true) String jobName) throws Exception {
        logger.info("dump dump : " + jobName);
        return localDump.get(jobName);
    }
}
