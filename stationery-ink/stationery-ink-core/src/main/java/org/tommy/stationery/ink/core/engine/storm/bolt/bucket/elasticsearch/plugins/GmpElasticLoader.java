package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.elasticsearch.plugins;

import backtype.storm.tuple.Tuple;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 13..
 */
public class GmpElasticLoader implements ElasticPlugin {
    private static final Logger LOG = LoggerFactory.getLogger(GmpElasticLoader.class);

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

    private static String APP_INDEX_NAME = "test-apps2";
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
        if (eventName == null) return false;

        String dt = log.dt;
        if (dt == null) return false;


        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();

        if (log.user_key != null) {
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                    .setDoc("user_key", log.user_key).setDocAsUpsert(true));
        }

        if (log.user_key != null && log.device != null) {
            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                    .setDoc("device", log.device).setDocAsUpsert(true));
        }

        if ("app.install".equals(eventName) && log.user_key != null && dt != null) {
            String appKey = log.app.get("key");

            Map<String, Map<String, Object>> root = new HashMap<String, Map<String, Object>>();
            Map<String, Object> v = new HashMap<>();
            v.put(appKey, dt);
            root.put("installed_apps", v);

            bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                    .setDoc(root).setDocAsUpsert(true));
        }

        if ("profile".equals(eventName)) {
            if (log.event.profile == null) return false;
            String gender = log.event.profile.get("gender") == null ? null : log.event.profile.get("gender").toString();
            String agegrp = log.event.profile.get("agegrp") == null ? null : log.event.profile.get("agegrp").toString();

            if (gender != null && agegrp != null) {

                Map<String, Map<String, Object>> root = new HashMap<String, Map<String, Object>>();
                Map<String, Object> v = new HashMap<>();
                v.put("gender", gender);
                v.put("agegrp", agegrp);
                root.put("profile", v);

                bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                        .setDoc(root).setDocAsUpsert(true));
            }
        }

        if ("app.status_update".equals(eventName) && log.app != null && log.event != null && log.event.user_status != null) {

            String appKey = log.app.get("key")  == null ? null : log.app.get("key");
            Object user_status = log.event.user_status;

            if (appKey != null && user_status != null) {

                Map<String, Map<String, Object>> root = new HashMap<String, Map<String, Object>>();
                Map<String, Object> v = new HashMap<>();
                v.put("user_status", user_status);
                root.put(appKey, v);

                bulkRequestBuilder.add(client.prepareUpdate(APP_INDEX_NAME, APP_INDEX_TYPE, log.user_key)
                        .setDoc(root).setDocAsUpsert(true));
            }
        }

        bulkRequestBuilder.execute();
        return true;
    }
}
