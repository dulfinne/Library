package com.dulfinne.bookservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaProducer{	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendBookCreatedId(long id) {
		kafkaTemplate.send("book_created", String.valueOf(id));
	}
}
