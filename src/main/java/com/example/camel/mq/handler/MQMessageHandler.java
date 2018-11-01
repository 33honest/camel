package com.example.camel.mq.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.camel.mq.Consumer;

@Component(value="mqMessageHandler")
public class MQMessageHandler extends Consumer {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
		logger.debug("消息输出 : " + message);
	}

	@Override
	public void errorHandle(Throwable e) {
		// TODO Auto-generated method stub
		logger.debug(e.getMessage());
	}

}
