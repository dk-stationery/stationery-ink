package org.tommy.stationery.ink.udf.support;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URLEncoder;

/**
 * Created by kun7788 on 15. 2. 16..
 */
public class InkKakaoAlert {

    public static String kakaoAlert(String group, String msg) {
        String result = "succeed";
        HttpClient client = new DefaultHttpClient();
        try {
            HttpGet request = new HttpGet("http://wt.iwilab.com/wt/send?group=" + group + "&msg=" + URLEncoder.encode(msg, "UTF-8"));
            client.execute(request);
        } catch (Exception e) {
            result = e.getMessage();
        }

        if (client != null) {
            client.getConnectionManager().shutdown();
        }
        return result;
    }

}
