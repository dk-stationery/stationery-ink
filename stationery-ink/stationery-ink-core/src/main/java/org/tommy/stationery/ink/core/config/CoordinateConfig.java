package org.tommy.stationery.ink.core.config;

import backtype.storm.Config;
import io.latent.storm.rabbitmq.config.ConnectionConfig;
import io.latent.storm.rabbitmq.config.ConsumerConfig;
import io.latent.storm.rabbitmq.config.ConsumerConfigBuilder;
import net.hydromatic.linq4j.Linq4j;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.linq.LinqQuery;
import org.tommy.stationery.ink.domain.BaseMetaDef;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;
import org.tommy.stationery.ink.enums.SettingEnum;
import storm.kafka.BrokerHosts;
import storm.kafka.SpoutConfig;
import storm.kafka.ZkHosts;
import storm.trident.spout.RichSpoutBatchExecutor;

import java.util.HashMap;
import java.util.Map;

public class CoordinateConfig {

	public static Config topologyConfig(InkConfig inkConfig) {
		//setup topology config
		Config topologyConfig = new Config();
		topologyConfig.setDebug(false);
		topologyConfig.setMessageTimeoutSecs(inkConfig.getInteger(SettingEnum.STORM_MESSAGE_TIMEOUT_SEC));
		topologyConfig.put(RichSpoutBatchExecutor.MAX_BATCH_SIZE_CONF, inkConfig.getInteger(SettingEnum.STORM_BATCH_SIZE));
        //topologyConfig.put(Config.TOPOLOGY_RECEIVER_BUFFER_SIZE, inkConfig.getInteger(SettingEnum.TOPOLOGY_RECEIVER_BUFFER_SIZE));
        //topologyConfig.put(Config.TOPOLOGY_TRANSFER_BUFFER_SIZE, inkConfig.getInteger(SettingEnum.TOPOLOGY_TRANSFER_BUFFER_SIZE));
        topologyConfig.put(Config.TOPOLOGY_EXECUTOR_SEND_BUFFER_SIZE, inkConfig.getInteger(SettingEnum.TOPOLOGY_EXECUTOR_SEND_BUFFER_SIZE));
        topologyConfig.put(Config.TOPOLOGY_EXECUTOR_RECEIVE_BUFFER_SIZE, inkConfig.getInteger(SettingEnum.TOPOLOGY_EXECUTOR_RECEIVE_BUFFER_SIZE));
		topologyConfig.setNumWorkers(inkConfig.getInteger(SettingEnum.WORKER_CNT));
		topologyConfig.setMaxSpoutPending(inkConfig.getInteger(SettingEnum.STORM_MAXSPOUTPENDING_NUM));
        topologyConfig.setNumAckers(inkConfig.getInteger(SettingEnum.SPOUT_THREAD_CNT)); //equal = SPOUT_THREAD_CNT
		return topologyConfig;
	}

	public static ConsumerConfig RabbitMqSpoutConfig(Stream inkStream, Source inkSource) throws Exception {

		BaseMetaDef urlMeta = Linq4j.asEnumerable(inkSource.getStatement().getMetas()).where(LinqQuery.META_URL_FILTER).toList().get(0);
		BaseMetaDef topicMeta = Linq4j.asEnumerable(inkStream.getStatement().getMetas()).where(LinqQuery.META_TOPIC_FILTER).toList().get(0);
		BaseMetaDef portMeta = Linq4j.asEnumerable(inkSource.getStatement().getMetas()).where(LinqQuery.META_PORT_FILTER).toList().get(0);
		BaseMetaDef idMeta = Linq4j.asEnumerable(inkSource.getStatement().getMetas()).where(LinqQuery.META_ID_FILTER).toList().get(0);
		BaseMetaDef pwMeta = Linq4j.asEnumerable(inkSource.getStatement().getMetas()).where(LinqQuery.META_PW_FILTER).toList().get(0);
		BaseMetaDef vHostMeta = Linq4j.asEnumerable(inkSource.getStatement().getMetas()).where(LinqQuery.META_VHOST_FILTER).toList().get(0);

		//setup spout config
		ConnectionConfig connectionConfig = new ConnectionConfig(
				urlMeta.getValue()
				, Integer.valueOf(portMeta.getValue())
				, idMeta.getValue()
				, pwMeta.getValue()
				, vHostMeta.getValue()
				, 10); // host, port, username, password, virtualHost, heartBeat

		ConsumerConfig consumerConfig = new ConsumerConfigBuilder().connection(connectionConfig)
		                                                        .queue(topicMeta.getValue())
		                                                        .prefetch(1048576)
		                                                        .requeueOnFail()
		                                                        .build();
		return consumerConfig;
	}
	
	public static  SpoutConfig KafkaSpoutConfig(InkConfig inkConfig, Stream inkStream, Source inkSource) throws Exception {
		//kafka zookeeper config
		Map conf = new HashMap();
        conf.put(Config.STORM_ZOOKEEPER_SESSION_TIMEOUT, 10000l);
        conf.put(Config.STORM_ZOOKEEPER_RETRY_TIMES, 4);
        conf.put(Config.STORM_ZOOKEEPER_RETRY_INTERVAL, 2000);

		BaseMetaDef urlMeta = Linq4j.asEnumerable(inkSource.getStatement().getMetas()).where(LinqQuery.META_URL_FILTER).toList().get(0);
		BaseMetaDef topicMeta = Linq4j.asEnumerable(inkStream.getStatement().getMetas()).where(LinqQuery.META_TOPIC_FILTER).toList().get(0);

        ZkHosts brokerConf = new ZkHosts(urlMeta.getValue());
        
        //setup spout config
		BrokerHosts brokerHost = brokerConf;
		SpoutConfig spoutConfig = new SpoutConfig(
				brokerHost
				, topicMeta.getValue()
				, "/brokers"
				, inkConfig.getString(SettingEnum.JOB_NAME)+"_"+topicMeta.getValue()/*+ "_VERSION_" + System.currentTimeMillis()*/
		);
		
		spoutConfig.bufferSizeBytes = 10485760;
		spoutConfig.fetchSizeBytes= 10485760;
        //spoutConfig.forceFromStart = false;
        //spoutConfig.startOffsetTime = kafka.api.OffsetRequest.LatestTime();
		return spoutConfig;
	}
}
