package org.tommy.stationery.ink.core.storm.build.storm;

import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.IRichSpout;
import io.latent.storm.rabbitmq.RabbitMQSpout;
import net.hydromatic.linq4j.Linq4j;
import org.jsoup.helper.StringUtil;
import org.tommy.stationery.ink.core.config.CoordinateConfig;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.core.linq.LinqQuery;
import org.tommy.stationery.ink.core.provider.SimpleMetaStoreProviderImp;
import org.tommy.stationery.ink.core.storm.bolt.DumpAndLogBolt;
import org.tommy.stationery.ink.core.storm.bolt.bucket.IBucketBolt;
import org.tommy.stationery.ink.core.storm.bolt.bucket.InsertPhoenixBolt;
import org.tommy.stationery.ink.core.storm.bolt.bucket.elasticsearch.InsertElasticSearchBolt;
import org.tommy.stationery.ink.core.storm.bolt.bucket.hdfs.bolt.InsertHdfsBolt;
import org.tommy.stationery.ink.core.storm.bolt.lookup.LookupPhoenixBolt;
import org.tommy.stationery.ink.core.storm.bolt.stream.EsperBolt;
import org.tommy.stationery.ink.core.storm.bolt.stream.SpoutParserBolt;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.BaseTableDef;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.*;
import org.tommy.stationery.ink.exception.InkException;
import org.tommy.stationery.ink.util.serde.JsonSerde;
import storm.kafka.KafkaSpout;
import storm.kafka.StringScheme;

import java.util.*;

/**
 * Created by kun7788 on 15. 2. 3..
 */
public class BoltBuilder {
    private static String BOLT_LINKED_SPOUT_NAME_PREFIX = "BOLT_LINKED_SPOUT";
    private static String BOLT_NAME_PREFIX = "BOLT";
    private static String SPOUT_NAME_PREFIX = "SPOUT";

    private static String DEFAULT_STREAM = "default";

    private String previousComponentId = null;
    private List<String> previousEmitFileds = null;
    private int componentIdx = 0;

    public List<String> ListFromColumns(List<BaseColumnDef> columnDefs) {
        List<String> lists = new ArrayList<String>();
        for (BaseColumnDef baseColumnDef : columnDefs) {
            lists.add(baseColumnDef.getName());
        }
        return lists;
    }

    public String StringFromBindTablesAndSource(List<BaseTableDef> bindTables) {
        List<String> lists = new ArrayList<String>();
        for (BaseTableDef tableDef : bindTables) {
            lists.add(tableDef.getName() + "-" + tableDef.getSource());
        }
        return StringUtil.join(lists, ",");
    }

    public String generateComponentId(String target1, String target2, String target3) {
        return target1 + "-" + target2 + "-" + target3;
    }

    public String generateComponentId(String target1, String target2, String target3, String target4) {
        return target1 + "-" + target2 + "-" + target3+ "-" + target4;
    }

    public String generatePrefix(String prefix) {

        return prefix + "-" + (componentIdx++) + "-";
    }

    public String generatePrefixNoIndexId(String prefix) {

        return prefix + "-";
    }

    public List<String> removeDuplicatesEmitFileds(List<String> emitFileds) {
        Set setItems = new LinkedHashSet(emitFileds);
        emitFileds.clear();
        emitFileds.addAll(setItems);
        return emitFileds;
    }


    public StormTopologyBuilder addInstance(StormTopologyBuilder stormTopologyBuilder, SimpleMetaStoreProviderImp simpleMetaStoreProvider, BaseStatement statement, InkConfig inkConfig, boolean isLast) throws Exception {

        JsonSerde jsonSerde = new JsonSerde();

        String componenetId = null;
        List<String> emitFileds = new ArrayList<String>();

        if (StatementTypeEnum.SubGroupTypeEnum.ESPER.equals(statement.getType().getSubGroup())) {

            EsperBolt.Builder builder = new EsperBolt.Builder();
            EsperBolt.InputsBuilder inputsBuilder = builder.inputs();
            EsperBolt.AliasedInputBuilder aliasedInputBuilder = null;

            componenetId = generateComponentId(generatePrefix(BOLT_NAME_PREFIX), statement.getType().getSubGroup().getName(), StringFromBindTablesAndSource(statement.getBindTables()));

            //inputs
            for (BaseTableDef tableDef : statement.getBindTables()) {

                Source inkSource = simpleMetaStoreProvider.getOnlyInkSourceByName(new Source(tableDef.getSource()));
                inkSource.setStatement(jsonSerde.deserialize(inkSource.getMeta()));

                Stream inkStream = simpleMetaStoreProvider.getOnlyInkStreamByName(new Stream(tableDef.getName()));
                inkStream.setStatement(jsonSerde.deserialize(inkStream.getMeta()));

                //add spout
                IRichSpout spout = null;
                String spoutComponentId = generateComponentId(generatePrefixNoIndexId(SPOUT_NAME_PREFIX), statement.getType().getSubGroup().getName(), inkSource.getName(), inkSource.getCatalog());
                String parserComponentId = null;

                boolean isRegistAlready = stormTopologyBuilder.isRegistAlready(spoutComponentId);
                if (isRegistAlready == false) {
                    if (SourceCatalogEnum.KAFKA.getName().equals(inkSource.getCatalog())) {
                        //spout
                        spout = new KafkaSpout(CoordinateConfig.KafkaSpoutConfig(inkStream, inkSource));
                    } else if (SourceCatalogEnum.RABBITMQ.getName().equals(inkSource.getCatalog())) {
                        //spout
                        spout = new RabbitMQSpout(new StringScheme());
                        stormTopologyBuilder.addConfigurations(spoutComponentId, CoordinateConfig.RabbitMqSpoutConfig(inkStream, inkSource).asMap());
                    } else {
                        throw new InkException(MessageEnum.CATALOG_INVALID);
                    }
                    stormTopologyBuilder.addSpout(spoutComponentId, spout, inkConfig.getInteger(SettingEnum.SPOUT_THREAD_CNT));

                    //add parser bolt
                    parserComponentId = generateComponentId(generatePrefix(BOLT_LINKED_SPOUT_NAME_PREFIX), statement.getType().getSubGroup().getName(), inkSource.getName(), inkSource.getCatalog());
                    SpoutParserBolt SpoutParser = new SpoutParserBolt(DEFAULT_STREAM, statement, inkStream, inkSource);
                    stormTopologyBuilder.addBolt(parserComponentId, SpoutParser, inkConfig.getInteger(SettingEnum.ESPER_THREAD_CNT));

                    //add esper bolt
                    aliasedInputBuilder = inputsBuilder.aliasComponent(parserComponentId);
                    //column
                    for (BaseColumnDef columnDef : inkStream.getStatement().getColumns()) {
                        if (columnDef == null || columnDef.getType() == null || columnDef.getType().getZlass() == null) {
                            throw new InkException(MessageEnum.DATA_TYPE_INVALID);
                        }
                        aliasedInputBuilder.withField(columnDef.getName()).ofType(columnDef.getType().getZlass());
                    }
                    inputsBuilder = aliasedInputBuilder.toEventType(tableDef.getName());

                    //connect bolt to bolt or spout
                    List<BaseColumnDef> partitionKeys = Linq4j.asEnumerable(inkStream.getStatement().getColumns()).where(LinqQuery.PARTITIONKEY_COLUMN_GROUP_FILTER).toList();
                    stormTopologyBuilder.connect(spoutComponentId, DEFAULT_STREAM, parserComponentId, partitionKeys);
                    stormTopologyBuilder.connect(parserComponentId, DEFAULT_STREAM, componenetId, partitionKeys);
                } else {
                    //add esper bolt
                    aliasedInputBuilder = inputsBuilder.aliasComponent(previousComponentId);

                    //column
                    for (BaseColumnDef columnDef : inkStream.getStatement().getColumns()) {
                        if (columnDef == null || columnDef.getType() == null || columnDef.getType().getZlass() == null) {
                            throw new InkException(MessageEnum.DATA_TYPE_INVALID);
                        }
                        aliasedInputBuilder.withField(columnDef.getName()).ofType(columnDef.getType().getZlass());
                    }

                    if (previousEmitFileds != null) {
                        for (String name : previousEmitFileds) {
                            aliasedInputBuilder.withField(name).ofType(ColumnDataTypeEnum.OBJECT.getZlass());
                        }
                    }

                    inputsBuilder = aliasedInputBuilder.toEventType(tableDef.getName());

                    //connect bolt to bolt or spout
                    List<BaseColumnDef> partitionKeys = Linq4j.asEnumerable(inkStream.getStatement().getColumns()).where(LinqQuery.PARTITIONKEY_COLUMN_GROUP_FILTER).toList();
                    stormTopologyBuilder.connect(previousComponentId, DEFAULT_STREAM, componenetId, null);
                }
            }

            EsperBolt.OutputsBuilder outputsBuilder = inputsBuilder.outputs();

            if (previousEmitFileds != null) {
                emitFileds.addAll(previousEmitFileds);
            }
            emitFileds.addAll(ListFromColumns(statement.getColumns()));
            emitFileds = removeDuplicatesEmitFileds(emitFileds);

            //outputs
            outputsBuilder = outputsBuilder.onStream(DEFAULT_STREAM).emit(emitFileds.toArray(new String[0]));
            EsperBolt esperBolt = outputsBuilder.statements().add(statement.getDressQuery()).build();

            stormTopologyBuilder.addBolt(componenetId, esperBolt, inkConfig.getInteger(SettingEnum.ESPER_THREAD_CNT));

        } else if (StatementTypeEnum.SubGroupTypeEnum.BUCKET.equals(statement.getType().getSubGroup())) {
            BaseTableDef tableDef = statement.getBindTables().get(0);

            Source inkSource = simpleMetaStoreProvider.getOnlyInkSourceByName(new Source(tableDef.getSource()));
            inkSource.setStatement(jsonSerde.deserialize(inkSource.getMeta()));

            Stream inkStream = simpleMetaStoreProvider.getOnlyInkStreamByName(new Stream(tableDef.getName()));
            inkStream.setStatement(jsonSerde.deserialize(inkStream.getMeta()));

            //previousEmit
            if (previousEmitFileds != null) {
                emitFileds.addAll(previousEmitFileds);
            }
            emitFileds.addAll(ListFromColumns(statement.getColumns()));
            emitFileds = removeDuplicatesEmitFileds(emitFileds);

            componenetId = generateComponentId(generatePrefix(BOLT_NAME_PREFIX), statement.getType().getSubGroup().getName(), StringFromBindTablesAndSource(statement.getBindTables()));

            //bucket selection.
            IRichBolt bolt = null;
            if (SourceCatalogEnum.PHOENIX.getName().equals(inkSource.getCatalog())) {
                bolt = new InsertPhoenixBolt();
            } else if (SourceCatalogEnum.HDFS.getName().equals(inkSource.getCatalog())) {
                bolt = new InsertHdfsBolt();
            } else if (SourceCatalogEnum.ELASTICSEARCH.getName().equals(inkSource.getCatalog())) {
                bolt = new InsertElasticSearchBolt();
            } else {
                throw new InkException(MessageEnum.CATALOG_INVALID);
            }

            ((IBucketBolt)bolt).setting(DEFAULT_STREAM, inkConfig, previousEmitFileds, statement, inkStream, inkSource);
            stormTopologyBuilder.addBolt(componenetId, bolt, inkConfig.getInteger(SettingEnum.OUTPUT_THREAD_CNT));

        } else if (StatementTypeEnum.SubGroupTypeEnum.LOOKUP.equals(statement.getType().getSubGroup())) {

            BaseTableDef tableDef = statement.getBindTables().get(0);

            Source inkSource = simpleMetaStoreProvider.getOnlyInkSourceByName(new Source(tableDef.getSource()));
            inkSource.setStatement(jsonSerde.deserialize(inkSource.getMeta()));

            Stream inkStream = simpleMetaStoreProvider.getOnlyInkStreamByName(new Stream(tableDef.getName()));
            inkStream.setStatement(jsonSerde.deserialize(inkStream.getMeta()));

            //previousEmit
            if (previousEmitFileds != null) {
                emitFileds.addAll(previousEmitFileds);
            }
            emitFileds.addAll(ListFromColumns(statement.getColumns()));
            emitFileds = removeDuplicatesEmitFileds(emitFileds);

            componenetId = generateComponentId(generatePrefix(BOLT_NAME_PREFIX), statement.getType().getSubGroup().getName(), StringFromBindTablesAndSource(statement.getBindTables()));

            LookupPhoenixBolt lookupPhoenixBolt = new LookupPhoenixBolt();
            lookupPhoenixBolt.setting(DEFAULT_STREAM, inkConfig, previousEmitFileds, statement, inkStream, inkSource);

            stormTopologyBuilder.addBolt(componenetId, lookupPhoenixBolt, inkConfig.getInteger(SettingEnum.LOOKUP_THREAD_CNT));


        } else {
            throw new InkException(MessageEnum.DONT_CREATE_BOLT);
        }

        if (previousComponentId != null) {
            stormTopologyBuilder.connect(previousComponentId, componenetId, null);
        }
        previousComponentId = componenetId;
        previousEmitFileds = emitFileds;

        //last add debug bolt if isDebug = true
        if (isLast == true) {
            String debugComponenetId = generateComponentId(generatePrefix(BOLT_NAME_PREFIX), "DEBUG", "CONSOLE");;
            DumpAndLogBolt logConsoleBolt = new DumpAndLogBolt(DEFAULT_STREAM, inkConfig);
            stormTopologyBuilder.addBolt(debugComponenetId, logConsoleBolt, 5);
            stormTopologyBuilder.connect(previousComponentId, debugComponenetId, null);
        }
        return stormTopologyBuilder;
    }
}
