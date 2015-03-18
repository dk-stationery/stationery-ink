package org.tommy.stationery.ink.core.storm.bolt;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tommy.stationery.ink.core.config.InkConfig;
import org.tommy.stationery.ink.core.util.LogUtil;

import java.util.Map;

public class LogConsoleBolt extends GenericBoltUtils implements IRichBolt {

	public static Logger logger = LoggerFactory.getLogger(LogConsoleBolt.class);
	private OutputCollector collector;
	private String streamId;
	private InkConfig inkConfig;

	public LogConsoleBolt(String streamId, InkConfig inkConfig) {
		this.streamId = streamId;
        this.inkConfig = inkConfig;
	}
	
	@Override
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		LogUtil.LOG("Displayer :: execute", input.toString(), true);

        //dump result data
        //dump(inkConfig, input);

		collector.ack(input);
	}

	@Override
	public void cleanup() {
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
