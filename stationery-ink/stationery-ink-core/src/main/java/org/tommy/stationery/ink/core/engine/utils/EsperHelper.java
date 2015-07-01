package org.tommy.stationery.ink.core.engine.utils;

import com.espertech.esper.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.exception.InkException;
import org.tommy.stationery.ink.util.serde.JsonSerde;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kun7788 on 15. 7. 1..
 */
public class EsperHelper implements UpdateListener {
    public static Logger logger = LoggerFactory.getLogger(EsperHelper.class);
    private Configuration configuration;
    private EsperEventCallback esperEventCallback;
    private transient EPServiceProvider esperSink;
    private transient EPRuntime runtime;
    private transient EPAdministrator admin;
    private EPStatement epStatement;
    private BaseStatement statement;
    private Source inkSource;
    private Stream inkStream;

    private void setupEventTypes(BaseStatement statement, SimpleMetaStoreProviderImp simpleMetaStoreProvider) throws IOException, InkException {

        for (BaseTableDef tableDef : statement.getBindTables()) {
            JsonSerde jsonSerde = new JsonSerde();
            inkSource = simpleMetaStoreProvider.getOnlyInkSourceByName(new Source(tableDef.getSource()));
            inkSource.setStatement(jsonSerde.deserialize(inkSource.getMeta()));

            inkStream = simpleMetaStoreProvider.getOnlyInkStreamByName(new Stream(tableDef.getName()));
            inkStream.setStatement(jsonSerde.deserialize(inkStream.getMeta()));

            Map<String, Object> properties = new HashMap<String, Object>();
            for (BaseColumnDef columnDef : inkStream.getStatement().getColumns()) {
                properties.put(columnDef.getName(), columnDef.getType().getZlass());
            }
            configuration.addEventType(inkStream.getName(), properties);
        }
    }

    public EsperHelper(EsperEventCallback esperEventCallback, BaseStatement statement, SimpleMetaStoreProviderImp simpleMetaStoreProvider) throws SQLException, IOException, InkException {
        this.statement = statement;
        this.esperEventCallback = esperEventCallback;

        configuration = new Configuration();
        configuration.configure("/esper-configuration.xml");
        setupEventTypes(statement, simpleMetaStoreProvider);

        this.esperSink = EPServiceProviderManager.getProvider(runtime.toString(), configuration);
        this.esperSink.initialize();
        this.runtime = esperSink.getEPRuntime();
        this.admin = esperSink.getEPAdministrator();

        EPStatement epStatement = admin.createEPL(statement.getDressQuery());
        epStatement.addListener(this);
    }

    public void start() {
        epStatement.start();
    }

    public synchronized void sendEvent(Map<String, Object> data, String streamName) {
        runtime.sendEvent(data, streamName);
    }

    @Override
    public void update(EventBean[] eventBeans, EventBean[] newEvents) {
        if (newEvents != null) {
            for (EventBean newEvent : newEvents) {
                Map<String, Object> tuple = new HashMap<String, Object>();
                for (BaseColumnDef columnDef : inkStream.getStatement().getColumns()) {
                    tuple.put(columnDef.getName(), newEvent.get(columnDef.getName()));
                }
                esperEventCallback.onEventReceive(statement.getTable().getName(), tuple);
            }
        }
    }
}
