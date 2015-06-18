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

    private static String API_AUTH_PATH = "/auth/check";
    private static String API_SUB_PATH = "/sql/run";
    private static String API_SQL_PARAM = "sql";
    private static String API_SESSION_PARAM = "sessionId";
    private static String API_USER_PARAM = "user";
    private static String API_PASSWORD_PARAM = "password";

    private static final Logger logger = LoggerFactory.getLogger(InkHttpClient.class);


    private String url;

    public InkHttpClient(String url) {
        this.url = url;
    }

    public void close() {

    }

    public String authCheck(String user, String password) {
        String result = "succeed";
        StringBuilder sb = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        try {
            HttpPost post = new HttpPost(url + API_AUTH_PATH);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair(API_USER_PARAM, user));
            nameValuePairs.add(new BasicNameValuePair(API_PASSWORD_PARAM, password));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = client.execute(post);
            return response.getStatusLine().getStatusCode() + "";
        } catch (Exception e) {
            result = e.getMessage();
        } finally {
            if (client != null) {
                client.getConnectionManager().shutdown();
            }
        }
        return result;
    }

    public String send(String sessionId, String user, String password, String sql) {
        String result = "succeed";
        StringBuilder sb = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        try {
            HttpPost post = new HttpPost(url + API_SUB_PATH);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair(API_SESSION_PARAM, sessionId));
            nameValuePairs.add(new BasicNameValuePair(API_SQL_PARAM, sql));
            nameValuePairs.add(new BasicNameValuePair(API_USER_PARAM, user));
            nameValuePairs.add(new BasicNameValuePair(API_PASSWORD_PARAM, password));
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
