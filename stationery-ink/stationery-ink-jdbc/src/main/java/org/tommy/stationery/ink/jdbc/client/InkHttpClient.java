package org.tommy.stationery.ink.jdbc.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 30..
 */
public class InkHttpClient {

    private static String API_SUB_PATH = "/sql/run";
    private static String API_SQL_PARAM = "sql";

    private static final Logger logger = LoggerFactory.getLogger(InkHttpClient.class);


    private String url;

    public InkHttpClient(String url) {
        this.url = url;
    }

    public void close() {

    }

    public String send(String sql) {
        String result = "succeed";
        StringBuilder sb = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        try {
            HttpPost post = new HttpPost(url + API_SUB_PATH);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair(API_SQL_PARAM, sql));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    sb.append(line);
                }
            }
            post.abort();

            result = sb.toString();

        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            if (client != null) {
                client.getConnectionManager().shutdown();
            }
        }
        return result;
    }

    public String getUrl() {
        return url;
    }
}
