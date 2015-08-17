package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.elasticsearch.plugins;

import backtype.storm.tuple.Tuple;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;

import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 13..
 */
public class GmpElasticLoader implements ElasticPlugin {
    private static class Event {
        public String name;
        public Map<String, Object> ask;
        public Map<String, Object> user_status;
        public Map<String, Object> iap;
        public Map<String, Object> profile;
    }

    private static class Log {
        public String user_key;
        public String ts;
        public String dt;
        public Map<String, String> device;
        public Map<String, String> app;
        public Map<String, String> sdk;
        public Map<String, Object> session;
        public Event event;
    }

    Client client;

    private static String APP_INDEX_NAME = "test-apps";
    private static String APP_INDEX_TYPE = "user";
    private static String CTX_SOURCE = "ctx._source.";
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void prepare(Client client) {
        this.client = client;
    }


    @Override
    public synchronized boolean execute(Tuple tuple) throws Exception {
        String payload = tuple.getStringByField("_PAYLOAD_");
        Log log = objectMapper.readValue(payload, new TypeReference<Log>() {
        });

        String eventName = log.event.name;
        String dt = log.dt;

        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();

        if (log.user_key != null) {
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("user_key", log.user_key)
                    .setScript(CTX_SOURCE + "user_key=user_key;").setUpsert("user_key", log.user_key));
        }

        if (log.device != null) {
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("device", log.device)
                    .setScript(CTX_SOURCE + "device=device;").setUpsert("device", log.device));
        }

        if ("app.install".equals(log.event)) {
            String appKey = log.app.get("key");
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("dt", dt)
                    .setScript(CTX_SOURCE + appKey + "=dt;").setUpsert("dt", dt));
        }

        String gender = log.event.profile.get("gender").toString();
        String agegrp = log.event.profile.get("agegrp").toString();
        if (gender != null && agegrp != null) {
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("gender", gender)
                    .addScriptParam("agegrp", agegrp)
                    .setScript(CTX_SOURCE + "gender=gender;" + CTX_SOURCE + "agegrp=agegrp;").setUpsert("gender", gender, "agegrp", agegrp));
        }


        String appKey = log.app.get("key");
        Object user_status = log.event.user_status;

        if (appKey != null && user_status != null) {
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                    .addScriptParam("user_status", user_status)
                    .setScript(CTX_SOURCE + appKey + ".user_status=user_status;").setUpsert(appKey + ".user_status", user_status));

            String user_id = log.app.get("user_id");
            if (user_id != null) {
                bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, "user", log.user_key)
                        .addScriptParam("user_id", user_id)
                        .setScript(CTX_SOURCE + appKey + ".user_id=user_id;").setUpsert(appKey + ".user_id", user_id));
            }
        }

        bulkRequestBuilder.execute();
        return true;
    }
}
