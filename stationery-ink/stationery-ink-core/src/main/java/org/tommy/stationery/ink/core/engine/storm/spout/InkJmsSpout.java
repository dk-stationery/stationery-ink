package org.tommy.stationery.ink.core.engine.storm.spout;

import backtype.storm.contrib.jms.spout.JmsSpout;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import net.hydromatic.linq4j.Linq4j;
import org.tommy.stationery.ink.config.InkConfig;
import org.tommy.stationery.ink.core.util.LinqQuery;
import org.tommy.stationery.ink.domain.BaseMetaDef;
import org.tommy.stationery.ink.domain.meta.Source;
import org.tommy.stationery.ink.domain.meta.Stream;

import javax.jms.JMSException;
import javax.jms.Session;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016. 3. 8..
 */
public class InkJmsSpout extends JmsSpout {
    private InkConfig inkConfig;
    private Stream inkStream;
    private Source inkSource;

    public InkJmsSpout(InkConfig inkConfig, Stream inkStream, Source inkSource) {
        super();
        this.inkConfig = inkConfig;
        this.inkStream = inkStream;
        this.inkSource = inkSource;

        setJmsTupleProducer(new InkJsonTupleProducer());
        setJmsAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        setDistributed(false);
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        Map _conf = new HashMap<>();
        try {
            Object timeout = conf.get("topology.message.timeout.secs");
            Integer topologyTimeout = timeout == null ? 30 : ((Long)timeout).intValue();
            _conf.put("topology.message.timeout.secs", topologyTimeout);
            BaseMetaDef urlMeta = Linq4j.asEnumerable(inkSource.getStatement().getMetas()).where(LinqQuery.META_URL_FILTER).toList().get(0);
            BaseMetaDef topicMeta = Linq4j.asEnumerable(inkStream.getStatement().getMetas()).where(LinqQuery.META_TOPIC_FILTER).toList().get(0);
            BaseMetaDef typeMeta = Linq4j.asEnumerable(inkStream.getStatement().getMetas()).where(LinqQuery.META_TYPE_FILTER).toList().get(0);
            setJmsProvider(new InkJmsProvider(urlMeta.getValue(), topicMeta.getValue(), typeMeta.getValue()));
        } catch (JMSException e) {
        }
        super.open(_conf, context, collector);
    }
}
