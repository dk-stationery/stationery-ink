package org.tommy.stationery.ink.core.engine.storm.bolt.bucket.rest;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.ning.http.client.providers.grizzly.GrizzlyAsyncHttpProvider;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kun7788 on 15. 7. 27..
 */
public class InsertRestBolt implements IRichBolt, IBucketBolt {
    private static final Logger LOG = LoggerFactory.getLogger(InsertRestBolt.class);

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
        private String body;
        private List<BaseBindColumnDef> columns;

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

        public List<BaseBindColumnDef> getColumns() {
            return columns;
        }

        public void setColumns(List<BaseBindColumnDef> columns) {
            this.columns = columns;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

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

        AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder().build();
        asyncHttpClient = new AsyncHttpClient(new GrizzlyAsyncHttpProvider(config), config);
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
            collector.emit(streamId, tuple.getValues());
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
            String url = restInfo.getUrl();
            String body = restInfo.getBody();
            for (BaseBindColumnDef bindColumn : restInfo.getColumns()) {
                url = url.replace("[:" + bindColumn.getName() + "]", tuple.getStringByField(bindColumn.getName()));
                if (body != null) {
                    body = body.replace("[:" + bindColumn.getName() + "]", tuple.getStringByField(bindColumn.getName()));
                }
            }

            AsyncHttpClient.BoundRequestBuilder boundRequestBuilder = null;
            if (RestCmd.PUT.equals(restInfo.getCmd())) {
                boundRequestBuilder = asyncHttpClient.preparePut(url);
            } else if (RestCmd.GET.equals(restInfo.getCmd())) {
                boundRequestBuilder = asyncHttpClient.prepareGet(url);
            } else if (RestCmd.DELETE.equals(restInfo.getCmd())) {
                boundRequestBuilder = asyncHttpClient.prepareDelete(url);
            } else if (RestCmd.POST.equals(restInfo.getCmd())) {
                boundRequestBuilder = asyncHttpClient.preparePost(url);
            } else {
                break;
            }

            if (body != null) {
                fureRet = boundRequestBuilder.setBody(body).execute();
            } else {
                fureRet = boundRequestBuilder.execute();
            }

            fureRet.get();
        }
    }

    private void preparedRest() throws Exception {
        Pattern pattern = Pattern.compile("values(\\s*)\\((.+?)\\)");
        Matcher matcher = pattern.matcher(statement.getQuery());
        String[] columnsArrys = null;
        while(matcher.find()) {
            String columnsStr = matcher.group(2).replace(" ", "");
            columnsArrys = columnsStr.split(",(?=([^\']*\'[^\']*\')*[^\']*$)", -1);
        }

        for (int i=0;i<columnsArrys.length;i++) {
            columnsArrys[i] = columnsArrys[i].substring(1, columnsArrys[i].length()-1);
        }

        if (columnsArrys.length < 3 && columnsArrys.length % 3 != 0) {
            throw new Exception("invalid rest format");
        }

        Pattern p = Pattern.compile("\\[\\:(.+?)\\]");
        for (int i=0;i<columnsArrys.length/3;i++) {
            RestInfo restInfo = new RestInfo();
            restInfo.setCmd(RestCmd.valueOf(columnsArrys[i * 3]));
            restInfo.setUrl(columnsArrys[i * 3 + 1]);
            restInfo.setBody("".equals(columnsArrys[i * 3 + 2]) ? null : columnsArrys[i * 3 + 2]);

            List<BaseBindColumnDef> columns = new ArrayList<BaseBindColumnDef>();
            String valQuery = columnsArrys[i * 3 + 1];
            Matcher m = p.matcher (valQuery);
            while (m.find())
            {
                String bindName = m.group(1);
                BaseBindColumnDef bindColumn = new BaseBindColumnDef();
                bindColumn.setName(bindName);
                columns.add(bindColumn);
            }
            restInfo.setColumns(columns);
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
