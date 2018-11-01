package com.example.camel.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void send(String msg, String queue) {
		this.jmsMessagingTemplate.convertAndSend(queue, msg);
	}

}
