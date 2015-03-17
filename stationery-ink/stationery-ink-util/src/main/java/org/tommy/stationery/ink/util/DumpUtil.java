package org.tommy.stationery.ink.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.type.TypeReference;
import org.tommy.stationery.ink.util.domain.Dump;
import org.tommy.stationery.ink.util.serde.JsonSerde;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 2. 27..
 */
public class DumpUtil {

    private static String DUMP_FLUSH_API_PARAM = "dump";
    private JsonSerde jsonSerde = new JsonSerde();

    public String flush(String jobName, String url, List<Dump> cachedDumps) {

        String result = "succeed";
        StringBuilder sb = new StringBuilder();
        HttpClient client = new DefaultHttpClient();

        try {
            HttpPost post = new HttpPost("http://" + url);

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("jobName", jobName));
            nameValuePairs.add(new BasicNameValuePair(DUMP_FLUSH_API_PARAM, jsonSerde.serialize(cachedDumps)));
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

    public String clear(String jobName, String url) {
        String result = "succeed";
        StringBuilder sb = new StringBuilder();
        HttpClient client = new DefaultHttpClient();

        try {
            HttpPost post = new HttpPost("http://" + url);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("jobName", jobName));
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

    public List<Dump> dump(String jobName, String url) throws IOException {
        String result = "succeed";
        StringBuilder sb = new StringBuilder();
        HttpClient client = new DefaultHttpClient();

        try {
            HttpPost post = new HttpPost("http://" + url);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("jobName", jobName));
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

        List<Dump> dump = (List<Dump>)jsonSerde.deserialize(result, new TypeReference<List<Dump>>() {
        });

        return dump;
    }
}
