package com.dulfinne.library_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulfinne.library_service.dto.response.BookRentalResponse;
import com.dulfinne.library_service.dto.response.BookResponse;
import com.dulfinne.library_service.mapper.BookMapper;
import com.dulfinne.library_service.mapper.BookRentalMapper;
import com.dulfinne.library_service.model.Book;
import com.dulfinne.library_service.model.BookRental;
import com.dulfinne.library_service.service.BookRentalService;
import com.dulfinne.library_service.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/library/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	private final BookMapper bookMapper;
	private final BookRentalService bookRentalService;
	private final BookRentalMapper bookRentalMapper;

	@GetMapping
	public List<BookResponse> getBooks() {
		List<Book> books = bookService.getBooks();
		return bookMapper.toBookResponseList(books);
	}

	@GetMapping("/{id}")
	public BookResponse getBook(@PathVariable long id) {
		Book book = bookService.getBook(id);
		return bookMapper.toResponse(book);
	}

	@GetMapping("/available")
	public List<BookResponse> getAvailableBooks() {
		List<Book> books = bookService.getAvailableBooks();
		return bookMapper.toBookResponseList(books);
	}

	@PostMapping("/{id}/borrow")
	public BookRentalResponse borrowBookById(@PathVariable long id) {
		BookRental bookRental = bookRentalService.borrowBookById(id);
		return bookRentalMapper.toResponse(bookRental);
	}
}
