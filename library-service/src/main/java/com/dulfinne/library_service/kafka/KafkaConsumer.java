package com.dulfinne.library_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.dulfinne.library_service.model.Book;
import com.dulfinne.library_service.model.Status;
import com.dulfinne.library_service.service.BookService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
	private final BookService bookService;
	
	@KafkaListener(topics = "book_created", groupId = "library_group")
	public void listen (String message) {
		long id = Long.parseLong(message);

		Book book = new Book();
		book.setId(id);
		book.setStatus(Status.AVAILABLE);
		
		bookService.saveBook(book);
	}
}
