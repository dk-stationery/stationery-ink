package org.tommy.stationery.ink.core.engine.storm.spout;

import backtype.storm.contrib.jms.JmsTupleProducer;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import org.apache.activemq.command.ActiveMQBytesMessage;
import org.apache.activemq.util.ByteSequence;
import org.apache.hadoop.hbase.util.Bytes;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by tommy on 2016. 3. 8..
 */
public class InkJsonTupleProducer implements JmsTupleProducer {

    public Values toTuple(Message msg) throws JMSException {
        if(msg instanceof TextMessage){
            String json = ((TextMessage) msg).getText();
            return new Values(json);
        } else if(msg instanceof ActiveMQBytesMessage) {
            String json = "";
            ActiveMQBytesMessage bytesMessage = ((ActiveMQBytesMessage)msg);
            if (bytesMessage != null){
                byte []bt = new byte[(int) bytesMessage.getBodyLength()];
                bytesMessage.readBytes(bt);
                json = new String(bt);
            }
            return new Values(json);
        } else {
            return new Values((msg != null ? msg.toString() : ""));
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("str"));
    }

}
