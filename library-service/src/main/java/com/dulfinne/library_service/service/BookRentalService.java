package com.dulfinne.library_service.service;

import java.util.List;

import com.dulfinne.library_service.model.BookRental;

public interface BookRentalService {
	List<BookRental> getBookRentals();

	BookRental borrowBookById(long id);
}
