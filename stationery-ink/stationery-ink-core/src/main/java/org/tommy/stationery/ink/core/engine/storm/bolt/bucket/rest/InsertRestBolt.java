package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.rest;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.engine.storm.bolt.GenericBoltUtils;
import org.tommy.stationery.ink.core.engine.storm.bolt.bucket.IBucketBolt;
import org.tommy.stationery.ink.domain.BaseBindColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by kun7788 on 15. 7. 27..
 */
public class InsertRestBolt implements IRichBolt, IBucketBolt {

    private static enum RestCmd {
        PUT("PUT"),
        GET("GET"),
        DELETE("DELETE"),
        POST("POST");

        private String name;
        private RestCmd(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private static class RestInfo {
        private RestCmd cmd;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public RestCmd getCmd() {
            return cmd;
        }

        public void setCmd(RestCmd cmd) {
            this.cmd = cmd;
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(InsertRestBolt.class);
    private OutputCollector collector;
    private Source inkSource;
    private Stream inkStream;
    private InkConfig inkConfig;
    private String streamId;
    private List<String> previousEmitFileds;
    private BaseStatement statement;
    private AsyncHttpClient asyncHttpClient;
    private List<RestInfo> restInfos = new ArrayList<RestInfo>();

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
        try {
            preparedRest();
        } catch (Exception e) {

        }
        asyncHttpClient = new AsyncHttpClient();
    }

    @Override
    public void execute(Tuple tuple) {
        try {
            restCall(tuple);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            collector.ack(tuple);
        }
    }

    @Override
    public void cleanup() {
        if (!asyncHttpClient.isClosed()) {
            asyncHttpClient.close();
        }
    }

    private void restCall(Tuple tuple) throws ExecutionException, InterruptedException {
        Future<Response> fureRet = null;
        for (RestInfo restInfo : restInfos) {
            if (RestCmd.PUT.equals(restInfo.getCmd())) {
                fureRet = asyncHttpClient.preparePut(restInfo.getUrl()).execute();
            } else if (RestCmd.GET.equals(restInfo.getCmd())) {
                fureRet = asyncHttpClient.prepareGet(restInfo.getUrl()).execute();
            } else if (RestCmd.DELETE.equals(restInfo.getCmd())) {
                fureRet = asyncHttpClient.prepareDelete(restInfo.getUrl()).execute();
            } else if (RestCmd.POST.equals(restInfo.getCmd())) {
                fureRet = asyncHttpClient.preparePost(restInfo.getUrl()).execute();
            } else {
                break;
            }
            fureRet.get();
        }
    }

    private void preparedRest() throws Exception {
        List<BaseBindColumnDef> baseBindColumnDefs = statement.getBindColumns();
        if (baseBindColumnDefs.size() < 2) {
            throw new Exception("invalid rest format");
        }

        for (int i=0;i<baseBindColumnDefs.size();i++) {
            RestInfo restInfo = new RestInfo();
            restInfo.setCmd(RestCmd.valueOf(baseBindColumnDefs.get(i*2).getName()));
            restInfo.setUrl(baseBindColumnDefs.get(i * 2 + 1).getName());
            restInfos.add(restInfo);
        }
    }

    @Override
    public void setting(String streamId, InkConfig inkConfig, List<String> previousEmitFileds, BaseStatement statement, Stream inkStream, Source inkSource) {
        this.streamId = streamId;
        this.inkConfig = inkConfig;
        this.previousEmitFileds = previousEmitFileds;
        this.statement = statement;
        this.inkStream = inkStream;
        this.inkSource = inkSource;
    }

    @Override
    public String generateQuery(Tuple input) {
        return null;
    }

    @Override
    public Object settingCommunicator() throws PropertyVetoException {
        return null;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        GenericBoltUtils genericBoltUtils = new GenericBoltUtils();
        outputFieldsDeclarer.declareStream(streamId, genericBoltUtils.getDeclareOutputFields(previousEmitFileds, statement.getColumns()));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
