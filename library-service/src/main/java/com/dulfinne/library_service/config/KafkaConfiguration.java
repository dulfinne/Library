package com.dulfinne.library_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {
	@Bean
	NewTopic yanaTopic() {
		return new NewTopic("book_added", 1, (short) 1);
	}
}
