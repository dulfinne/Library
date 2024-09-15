package com.dulfinne.bookservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dulfinne.bookservice.exception.BookNotFoundException;
import com.dulfinne.bookservice.exception.BookWithSuchIsbnAlreadyExists;
import com.dulfinne.bookservice.kafka.KafkaProducer;
import com.dulfinne.bookservice.model.Book;
import com.dulfinne.bookservice.repository.BookRepository;
import com.dulfinne.bookservice.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepository;
	private final KafkaProducer producer;
	
	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBook(long id) {
		return getBookIfExists(id);
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn)
				.orElseThrow(() -> new BookNotFoundException("Book with ISBN = " + isbn +" not found"));
	}
	
	@Override
	public Book saveBook(Book book) {
		String isbn = book.getIsbn();
		if(bookRepository.findByIsbn(isbn).isPresent())
		{
			throw new BookWithSuchIsbnAlreadyExists("Book with ISBN = " + isbn + " alreadyExists");
		}
		
		bookRepository.save(book);
		
		producer.sendBookCreatedId(book.getId());
		
		return book;
	}
	
	@Override
	public Book updateBook(long id, Book updatedBook) {
		Book book = getBookIfExists(id);

		String isbn = updatedBook.getIsbn();

		if(!book.getIsbn().equals(isbn) && bookRepository.findByIsbn(isbn).isPresent())
		{
			throw new BookWithSuchIsbnAlreadyExists("Book with ISBN = " + isbn + " alreadyExists");
		}
				
		String name = updatedBook.getName();
		String genre = updatedBook.getGenre();
		String info = updatedBook.getInfo();
		String author = updatedBook.getAuthor();
		
		book.setIsbn(isbn);
		book.setName(name);
		book.setGenre(genre);
		book.setInfo(info);
		book.setAuthor(author);
		
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(long id) {
		if (!bookRepository.existsById(id)){
			throw new BookNotFoundException("Book with id = " + id + " not found");
		}
		
		bookRepository.deleteById(id);
	}

	private Book getBookIfExists(long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book with id = " + id + " not found"));
	}
}
