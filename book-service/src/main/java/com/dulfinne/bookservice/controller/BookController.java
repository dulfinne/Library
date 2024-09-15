package com.dulfinne.bookservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulfinne.bookservice.dto.request.BookRequest;
import com.dulfinne.bookservice.dto.response.BookResponse;
import com.dulfinne.bookservice.mapper.BookMapper;
import com.dulfinne.bookservice.model.Book;
import com.dulfinne.bookservice.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {

	private final BookMapper bookMapper;
	private final BookService bookService;

	@GetMapping
	public List<BookResponse> getBooks() {
		List<Book> books = bookService.getBooks();
		return bookMapper.toBookResponseList(books);
	}

	@GetMapping("/{id}")
	public BookResponse getBook(@PathVariable("id") long bookId) {
		Book book = bookService.getBook(bookId);
		return bookMapper.toResponse(book);
	}
	
	@GetMapping("/isbn/{isbn}")
	public BookResponse getBookByIsbn(@PathVariable("isbn") String isbn) {
		Book book = bookService.getBookByIsbn(isbn);
		return bookMapper.toResponse(book);
	}

	@PostMapping
	public BookResponse saveBook(@RequestBody @Valid BookRequest bookRequest) {
		Book book = bookMapper.toBook(bookRequest);
		book = bookService.saveBook(book);
		return bookMapper.toResponse(book);
	}

	@PutMapping("/{id}")
	public BookResponse updateBook(@PathVariable("id") long bookId, @RequestBody @Valid BookRequest bookRequest) {
		Book book = bookMapper.toBook(bookRequest);
		book = bookService.updateBook(bookId, book);
		return bookMapper.toResponse(book);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") long bookId) {
		bookService.deleteBook(bookId);
	}
}
