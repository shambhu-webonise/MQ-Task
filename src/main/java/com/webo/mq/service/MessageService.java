package com.webo.mq.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(final String text) {
		LOG.info("Message : {} ", text);
		this.jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				message.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
				return message;
			}
		});
	}
	
	public void sendText(final String text) {
		LOG.info("Message : {} ", text);
		this.jmsTemplate.convertAndSend(text);
	}
	
	public void send(final Destination destination, final String text) {
		LOG.info("Message : {} ", text);
		this.jmsTemplate.send(destination, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message = session.createTextMessage(text);
				return message;
			}
		});
	}
}
