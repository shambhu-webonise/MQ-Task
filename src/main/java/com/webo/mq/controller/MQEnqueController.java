package com.webo.mq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webo.mq.broker.JmsMessageSender;

@Controller
public class MQEnqueController {
	private static final Logger LOG = LoggerFactory.getLogger(MQEnqueController.class);
	
	@Autowired
	private JmsMessageSender jmsMessageSender;
	
	private String defaultQueueName = "Send2Recv";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		LOG.info("Welcome to Message Queue POC");
		return "index";
	}
	
	@RequestMapping(value = "/enque", method = RequestMethod.POST)
	public String enque(@RequestParam("enqueText") String text, Model model) {
		LOG.info("Message for queue {} is: {}", text);
		
		model.addAttribute("link", defaultQueueName);
		model.addAttribute("queueName", defaultQueueName );
		model.addAttribute("queueMessages", text );
		jmsMessageSender.send(text);
		
		return "index";
	}
	
}
