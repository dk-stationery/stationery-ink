package org.tommy.stationery.ink.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.tommy.stationery.ink.domain.cluster.Cluster;
import org.tommy.stationery.ink.domain.cluster.Topology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kun7788 on 15. 1. 29..
 */
public class NimbusParser {
    public static List<Object> getInfo(String url) {
        List<Object> info = new ArrayList<Object>();

        Cluster cluster = new Cluster();
        List<Topology> topologys = new ArrayList<Topology>();

        // HttpClient 생성
        HttpClient httpclient = new DefaultHttpClient();
        try {
            // HttpGet생성
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            String lines = "";
            if (entity != null) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent()));
                String line = "";
                while ((line = rd.readLine()) != null) {
                    lines +=line;
                }
            }
            httpget.abort();
            httpclient.getConnectionManager().shutdown();

            Document doc = Jsoup.parse(lines);
            Elements elements = doc.select("table");
            if (elements == null) {
                info.add(cluster);
                info.add(topologys);
                return info;
            }
            Elements statusElements = elements.get(0).select("tbody").select("tr").select("td");

            for (int i=0; i<statusElements.size() / 8;i++) {
                int index = i * 8;

                cluster.setVersion(statusElements.get(index).text());
                cluster.setUptime(statusElements.get(index + 1).text());
                cluster.setSupervisors(Integer.parseInt(statusElements.get(index + 2).text()));
                cluster.setUsedSlots(Integer.parseInt(statusElements.get(index + 3).text()));
                cluster.setFreeSlots(Integer.parseInt(statusElements.get(index + 4).text()));
                cluster.setTotalSlots(Integer.parseInt(statusElements.get(index + 5).text()));
                cluster.setExecutors(Integer.parseInt(statusElements.get(index + 6).text()));
                cluster.setTasks(Integer.parseInt(statusElements.get(index + 7).text()));

            }

            elements = doc.select("table[class=zebra-striped]");
            statusElements = elements.get(0).select("tbody").select("tr").select("td");

            for (int i=0; i<statusElements.size() / 7;i++) {
                int index = i * 7;

                Topology topology = new Topology();
                topology.setName(statusElements.get(index).text());
                topology.setId(statusElements.get(index + 1).text());
                topology.setStatus(statusElements.get(index + 2).text());
                topology.setUptime(statusElements.get(index + 3).text());

                topology.setNumExecutors(Integer.parseInt(statusElements.get(index + 4).text()));
                topology.setNumWorkers(Integer.parseInt(statusElements.get(index + 5).text()));
                topology.setNumTasks(Integer.parseInt(statusElements.get(index + 6).text()));

                topologys.add(topology);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

        info.add(cluster);
        info.add(topologys);

        return info;
    }

    public static Cluster getCluster(String url) {
        Cluster cluster = new Cluster();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("table");

            Elements statusElements = elements.get(0).select("tbody").select("tr").select("td");

            for (int i=0; i<statusElements.size() / 8;i++) {
                int index = i * 8;

                cluster.setVersion(statusElements.get(index).text());
                cluster.setUptime(statusElements.get(index + 1).text());
                cluster.setSupervisors(Integer.parseInt(statusElements.get(index + 2).text()));
                cluster.setUsedSlots(Integer.parseInt(statusElements.get(index + 3).text()));
                cluster.setFreeSlots(Integer.parseInt(statusElements.get(index + 4).text()));
                cluster.setTotalSlots(Integer.parseInt(statusElements.get(index + 5).text()));
                cluster.setExecutors(Integer.parseInt(statusElements.get(index + 6).text()));
                cluster.setTasks(Integer.parseInt(statusElements.get(index + 7).text()));

            }
        } catch (IOException e) {
        }
        return cluster;
    }

    public static List<Topology> getTopologies(String url) {
        List<Topology> topologys = new ArrayList<Topology>();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("table[class=zebra-striped]");

            Elements statusElements = elements.get(0).select("tbody").select("tr").select("td");


            for (int i=0; i<statusElements.size() / 7;i++) {
                int index = i * 7;

                Topology topology = new Topology();
                topology.setName(statusElements.get(index).text());
                topology.setId(statusElements.get(index + 1).text());
                topology.setStatus(statusElements.get(index + 2).text());
                topology.setUptime(statusElements.get(index + 3).text());

                topology.setNumExecutors(Integer.parseInt(statusElements.get(index + 4).text()));
                topology.setNumWorkers(Integer.parseInt(statusElements.get(index + 5).text()));
                topology.setNumTasks(Integer.parseInt(statusElements.get(index + 6).text()));

                topologys.add(topology);
            }
        } catch (IOException e) {
        }

        return topologys;
    }
}
