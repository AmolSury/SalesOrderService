package com.main.services;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.util.Customer;

@Service
public class MessageReceiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

	
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "helloworld.t", groupId = "cust")
	public void receive(String payload) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("-------------------"+payload);
		LOGGER.info("received payload='{}'", payload);
		latch.countDown();
		//Payload to POJO
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = mapper.readValue(payload, Customer.class);
		System.out.println("-=-=-=-=-=-=-=-=-"+customer.toString());
		
	}
	
	
}
