package org.tommy.stationery.ink.core.engine.storm.spout;

import backtype.storm.contrib.jms.JmsProvider;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;

import javax.jms.*;

/**
 * Created by tommy on 2016. 3. 8..
 */
public class InkJmsProvider implements JmsProvider {
    private ActiveMQConnectionFactory connectionFactory;
    private Destination destination;

    public InkJmsProvider(String url, String topic, String destinationBean) throws JMSException {
        connectionFactory = new ActiveMQConnectionFactory(url);//"tcp://localhost:61616";
        connectionFactory.setWatchTopicAdvisories(false);

        Connection connection = connectionFactory.createConnection();
        connection.start();
        ActiveMQSession session = (ActiveMQSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        if ("queue".equals(destinationBean)) {
            destination = session.createQueue(topic);
        } else if ("topic".equals(destinationBean)){
            destination = (Destination)session.createTopic(topic);
        } else {
            throw new JMSException("not supported - a DestinationBean must be queue or topic.");
        }
    }

    public ConnectionFactory connectionFactory() throws Exception {
        return this.connectionFactory;
    }

    public Destination destination() throws Exception {
        return this.destination;
    }

}
