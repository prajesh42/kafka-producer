package com.example.kafka.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessageToTopic(String message) {
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("kafka-test","Hello, Kafka!");
	    future.whenComplete((result,ex)->{
	    	if(ex == null) {
	    		System.out.println("Sent message=["+ message +"] with offset=["+result.getRecordMetadata().offset()+"]");
	    	} else {
	    		System.out.println("Unable to send message=["+ message +"] de to : "+ ex.getMessage());
	    	}
	    });
	}
}
