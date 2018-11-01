package com.example.camel.mq;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

public abstract class Consumer {
	
	public abstract void onMessage(String message);
	
	public abstract void errorHandle(Throwable e);
	
	public void handle(Exchange exchange) {
		
		try {
			Message in = exchange.getIn();
			String body = in.getBody(String.class);
			onMessage(body);
		} catch (Exception e) {
			// TODO: handle exception
			errorHandle(e);
		}
		
	}
	
}
