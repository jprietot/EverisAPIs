package com.everis.jms;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.log4j.Logger;

@Singleton
public class Producer {

	private static final Logger LOG = Logger.getLogger(Producer.class);

    @Resource(mappedName = "jms/cars")
    private Queue jmsQueue;

    @Resource(mappedName = "jms/connectionFactory")
    private ConnectionFactory jmsFactory;

    public void send(String id) {
        try {
            Connection conn = jmsFactory.createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(jmsQueue);
            producer.send(session.createTextMessage(id));
            
            LOG.info("Producer sent: " + id);

        } 
        catch (JMSException e) {
            LOG.info(e);
        }
    }


}
