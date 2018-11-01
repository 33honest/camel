package com.example.camel.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.camel.mq.Producer;

@RestController
@RequestMapping("/test")
public class IndexController {
	
	private static final String QUEUE= "rms.account";
	
	@Autowired
	Producer producer;
	
	@RequestMapping(value = "/sendHello", method=RequestMethod.GET)
	public String sendHello() {
		
		Map<String, String> orderInfo = new HashMap<>();
		orderInfo.put("orderId", "100035330-1");
		orderInfo.put("amount", "110");
		orderInfo.put("create_time", Calendar.getInstance().getTime().toString());
		
		try {
			producer.send(orderInfo.toString(), QUEUE);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "fail";
	}
	
}
