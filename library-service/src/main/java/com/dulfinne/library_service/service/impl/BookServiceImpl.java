package com.dulfinne.library_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dulfinne.library_service.exception.BookNotFoundException;
import com.dulfinne.library_service.model.Book;
import com.dulfinne.library_service.model.Status;
import com.dulfinne.library_service.repository.BookRepository;
import com.dulfinne.library_service.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBook(long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book with id = " + id + " not found"));
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	@Override
	public List<Book> getAvailableBooks() {
		return bookRepository.findByStatus(Status.AVAILABLE);
	}
}
