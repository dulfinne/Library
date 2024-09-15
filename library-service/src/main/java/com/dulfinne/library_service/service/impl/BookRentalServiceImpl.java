package com.dulfinne.library_service.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dulfinne.library_service.exception.BookNotAvailableException;
import com.dulfinne.library_service.exception.BookNotFoundException;
import com.dulfinne.library_service.model.Book;
import com.dulfinne.library_service.model.BookRental;
import com.dulfinne.library_service.model.Status;
import com.dulfinne.library_service.repository.BookRentalRepository;
import com.dulfinne.library_service.repository.BookRepository;
import com.dulfinne.library_service.service.BookRentalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookRentalServiceImpl implements BookRentalService {

	private final BookRentalRepository rentalRepository;
	private final BookRepository bookRepository;
	private static final String CURRENT_TIMEZONE = "Europe/Minsk";

	@Override
	public List<BookRental> getBookRentals() {
		return rentalRepository.findAll();
	}

	@Override
	public BookRental borrowBookById(long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new BookNotFoundException("Book with id = " + id + " not found"));

		if (!book.getStatus().equals(Status.AVAILABLE))
		{
			throw new BookNotAvailableException("Book with id = " + id + " is already borrowed");
		}
		
		ZonedDateTime borrowedAt = ZonedDateTime.now(ZoneId.of(CURRENT_TIMEZONE));
		ZonedDateTime returnBy = borrowedAt.plusDays(7);
		
		book.setStatus(Status.BORROWED);

		BookRental rental = new BookRental();
		rental.setBook(book);
		rental.setBorrowedAt(borrowedAt);
		rental.setReturnBy(returnBy);

		return rentalRepository.save(rental);
	}
}
