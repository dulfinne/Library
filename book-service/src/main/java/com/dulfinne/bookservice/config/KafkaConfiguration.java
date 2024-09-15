package com.dulfinne.bookservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {
	@Bean
	NewTopic bookCreatedTopic() {
		return new NewTopic("book_created", 1, (short) 1);
	}
}
