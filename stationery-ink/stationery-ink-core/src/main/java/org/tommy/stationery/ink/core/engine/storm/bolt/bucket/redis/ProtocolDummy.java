package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.redis;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 8. 12..
 */
public class ProtocolDummy {
    public static void call(String url) {
        StringBuilder lines = new StringBuilder();
        // HttpClient 생성
        HttpClient httpclient = new DefaultHttpClient();
        try {
            // HttpGet생성
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    lines.append(line);
                }
            }
            httpget.abort();
            httpclient.getConnectionManager().shutdown();
            System.out.println(lines);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }



    public static String randString() {
        return "A";
    }

    public static String randStringChar() {
        return "A";
    }

    public static String randOSName() {
        return "iOS";
    }

    public static int ran = 0;

    public static String randEventName() {
        String[] events = new String[]{"session.start", "session.stop", "campaign.vimp", "campaign.click", "app.install", "app.update", "app.status_update", "conversion", "iap"};
        return events[0];
    }

    public static String randPromotionKey() {
        String[] events = new String[]{"0", "1", "2", "3", "4", "5e", "6", "7", "8"};
        return events[0];
    }

    public static String randRewardWhen() {
        String[] events = new String[]{"none", "immediate", "defered"};
        return events[0];
    }

    public static Map<String, Object> protocol(String userPrefix, String eventName) {
        String seedString = "asaa";

        Map<String, Object> protocol = new HashMap<String, Object>();
        protocol.put("user_key", userPrefix + /*(ran++ % 10)*/ "1");
        protocol.put("dt", "20150709");
        Map<String, String> device = new HashMap<String, String>();
        device.put("id", randIMMutableStringVal(seedString));
        device.put("ifa", randIMMutableStringVal(randIMMutableStringVal(seedString)));
        device.put("ifa", randIMMutableStringVal(randIMMutableStringVal(randIMMutableStringVal(seedString))));
        device.put("allow_ad_tracking", "Y");
        device.put("locale", "ko_KR");
        device.put("carrier", "123123");
        device.put("network_type", "123123");
        device.put("os_name", randOSName());
        device.put("os_version", "123123");
        protocol.put("device", device);

        Map<String, String> app = new HashMap<String, String>();
        app.put("id", "1l");
        app.put("user_id", "user_id1");
        app.put("package_name", "com.daumkakao.gmp.tester" + randStringChar());
        app.put("version", "1.0");
        app.put("key", "appkey_aa3");
        protocol.put("app", app);

        Map<String, String> sdk = new HashMap<String, String>();
        sdk.put("core_type", randOSName());
        sdk.put("version", "1.0.7");
        protocol.put("sdk", sdk);

        Map<String, String> session = new HashMap<String, String>();
        session.put("id", randString());
        session.put("length", "10");
        protocol.put("session", session);

        Map<String, String> profile = new HashMap<String, String>();
        profile.put("gender", "M");
        profile.put("agegrp", "2");

        Map<String, String> iap = new HashMap<String, String>();
        iap.put("price", "1000");
        iap.put("currency", "USD");
        iap.put("created_at", "03/01/2013 05:48:28");
        iap.put("os", "android");
        iap.put("country_iso", "KR");
        iap.put("platform", "Google");
        iap.put("to_krw", "100000");


        Map<String, Object> event = new HashMap<String, Object>();
        event.put("name", eventName);
        event.put("profile", profile);
        event.put("iap", iap);

        if ("campaign.vimp".equals(event.get("name")) || "campaign.click".equals(event.get("name")) || "iap".equals(event.get("name")) || "conversion".equals(event.get("name"))) {
            Map<String, String> ask = new HashMap<String, String>();
            ask.put("promotion_key", randPromotionKey());
            ask.put("creative_key", "A11");
            ask.put("reward_when", randRewardWhen());
            event.put("ask", ask);
        }


        if ("app.status_update".equals(event.get("name"))) {
            Map<String, String> userStatus = new HashMap<String, String>();
            userStatus.put("user_id", randIMMutableStringVal(seedString) + "_user_id");
            userStatus.put("dia", "5");
            event.put("user_status", userStatus);
        }

        protocol.put("event", event);




        return protocol;
    }

    public static void main(String[] args) throws Exception {

        for (int i=0;i<1000;i++) {

            ObjectMapper objectMapper1 = new ObjectMapper();
            String str1 = objectMapper1.writeValueAsString(protocol("g", "session.start"));

            //System.out.println(str1);
            ProtocolDummy.call("http://fox614.dakao.io/internal/collect/sdk_event?log=" + URLEncoder.encode(str1));

            //ProtocolDummy.call("http://localhost:8080/internal/collect/sdk_event?log="+ URLEncoder.encode(str));
        }
    }

    public static String randIMMutableStringVal(String val) {
        return "xxx555111qPdDlvRQj3ek8HA8sJKh7_Nt8I85cw3sF5-VoBmI0AQ";
    }
}
