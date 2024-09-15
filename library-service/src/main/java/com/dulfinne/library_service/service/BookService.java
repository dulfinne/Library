package com.dulfinne.library_service.service;

import java.util.List;

import com.dulfinne.library_service.model.Book;
import com.dulfinne.library_service.model.BookRental;

public interface BookService {
	List<Book> getBooks();
	
	Book getBook(long id);
	
	Book saveBook(Book book);
	
	List<Book> getAvailableBooks();
}
