package org.tommy.stationery.ink.core.storm.bolt.stream;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import org.apache.hadoop.hbase.util.Bytes;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.util.TypeConversionUtil;
import org.tommy.stationery.ink.domain.BaseColumnDef;
import org.tommy.stationery.ink.domain.BaseStatement;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.ColumnDataTypeEnum;
import org.tommy.stationery.ink.enums.MessageEnum;
import org.tommy.stationery.ink.enums.SourceCatalogEnum;
import org.tommy.stationery.ink.exception.InkException;

import java.util.*;

public class SpoutParserBolt implements IRichBolt {

    private static final long serialVersionUID = -1757538850700317883L;

    public static Logger logger = LoggerFactory.getLogger(SpoutParserBolt.class);
	private ObjectMapper objectMapper;
	private OutputCollector collector;
	private String streamId = "default";
	private Stream inkStream;
    private Source inkSource;
	private String ROOT_NAME = "";
    private BaseStatement statement;

	public SpoutParserBolt(String streamId, BaseStatement statement, Stream inkStream, Source inkSource) {
		this.streamId = streamId;
        this.statement = statement;
        this.inkStream = inkStream;
        this.inkSource = inkSource;

		if (SourceCatalogEnum.KAFKA.equals(SourceCatalogEnum.valueOf(inkSource.getCatalog()))) {
			ROOT_NAME = "bytes";
		} else {
			ROOT_NAME = "str";
		}
	}

	@Override
	public void prepare(Map stormConf, TopologyContext context,
						OutputCollector collector) {
		objectMapper = new ObjectMapper();
		this.collector = collector;
	}

    public void logging(Map<String, String> mTuple, String timeKey) {
        if (mTuple != null) logger.info("*INK_TIME  : " + (mTuple.get(timeKey) != null ? mTuple.get(timeKey) : "empty"));
    }

	@Override
	public void execute(Tuple tuple) {
		try {
            Map<String, String> mTuple = null;
            if ("bytes".equals(ROOT_NAME)) {
                mTuple = getDecodedJsonTuple(Bytes.toString(tuple.getBinaryByField(ROOT_NAME)));
                logging(mTuple, "@timestamp");
            } else {
                mTuple = getDecodedJsonTuple(tuple.getStringByField(ROOT_NAME));
                logging(mTuple, "timestamp");
            }

            if (mTuple == null) {
                collector.ack(tuple);
                return;
            }

			Values valuse = new Values();

            for (BaseColumnDef columnDef : inkStream.getStatement().getColumns()) {
                String val = mTuple.get(columnDef.getName());
                ColumnDataTypeEnum type = ColumnDataTypeEnum.valueOf(columnDef.getType().getName());
                if (type == null) {
                    type = ColumnDataTypeEnum.STRING;
                }

                if (val == null || "null".equals(val) || val.length() == 0) {
                    if (ColumnDataTypeEnum.STRING.equals(type)) {
                        val = "";
                    } else {
                        val = "0";
                    }
                }

                valuse.add(TypeConversionUtil.convertion(val, type));
            }



            collector.emit(tuple, valuse);
            collector.ack(tuple);
		} catch (Exception e) {
            logger.error(e.getMessage());
            collector.fail(tuple);
		}
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
        List<String> columns = new ArrayList<String>();
        for (BaseColumnDef columnDef : inkStream.getStatement().getColumns()) {
            columns.add(columnDef.getName());
        }
		declarer.declareStream(streamId, new Fields(columns.toArray(new String[0])));
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

	private Map<String, String> getDecodedJsonTuple(String payload) throws Exception {
        if (payload == null) {
            throw new InkException(MessageEnum.EMPTY_TUPLE);
        }
        JsonNode rootNode = objectMapper.readValue(payload, JsonNode.class);
        if (rootNode == null) {
            throw new InkException(MessageEnum.INVALID_TUPLE);
        }
        Map<String, String> map = new HashMap<String, String>();
        iterateNode(rootNode, null, map);
        return map;
	}

	public void iterateNode(JsonNode node, String parentFieldName, Map<String, String> m) {
		Iterator<String> fieldNamesIter = node.getFieldNames();
		if(parentFieldName == null) parentFieldName = "";

		if (fieldNamesIter == null) {
			return;
		}

		while (fieldNamesIter.hasNext()) {
			String fieldName = fieldNamesIter.next();
			JsonNode subNode = node.get(fieldName);
			if (subNode.isValueNode()) {
				m.put(parentFieldName + fieldName, subNode.asText());
			} else if (subNode.isContainerNode()) {
				iterateNode(subNode, fieldName + ".", m);
			}
		}
	}
}

