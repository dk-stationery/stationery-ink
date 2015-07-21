package org.tommy.stationery.ink.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.tommy.stationery.ink.domain.cluster.Cluster;
import org.tommy.stationery.ink.domain.cluster.Topology;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 29..
 */
public class NimbusParser {
    private static String getApiBody(String url) {
        String lines = "";
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
                    lines += line;
                }
            }
            httpget.abort();
            httpclient.getConnectionManager().shutdown();
        } catch (Exception ex) {

        }
        return lines;
    }

    public static List<Object> getInfo(String url) {
        List<Object> info = new ArrayList<Object>();

        Cluster cluster = new Cluster();
        Topology topologys = new Topology();

        String topologyRet = getApiBody(url + "/api/v1/topology/summary");
        String cluesterRet = getApiBody(url + "/api/v1/cluster/summary");

        cluster.setInfo(cluesterRet);
        topologys.setInfo(topologyRet);
        info.add(cluster);
        info.add(topologys);
        return info;
    }
}
