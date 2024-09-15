package com.dulfinne.bookservice.exception;

public class BookWithSuchIsbnAlreadyExists extends RuntimeException{
	
	public BookWithSuchIsbnAlreadyExists(String message) {
		super(message);
	}
}
