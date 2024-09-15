package com.dulfinne.bookservice.service;

import java.util.List;

import com.dulfinne.bookservice.model.Book;

public interface BookService {
	List<Book> getBooks();
	
	Book getBook(long id);
	
	Book getBookByIsbn(String isbn);
	
	Book saveBook(Book book);
	
	Book updateBook(long id, Book book);
	
	void deleteBook(long id);

}
