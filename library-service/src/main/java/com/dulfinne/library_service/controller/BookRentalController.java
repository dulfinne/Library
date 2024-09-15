package com.dulfinne.library_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulfinne.library_service.dto.response.BookRentalResponse;
import com.dulfinne.library_service.mapper.BookRentalMapper;
import com.dulfinne.library_service.model.BookRental;
import com.dulfinne.library_service.service.BookRentalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/library/book-rentals")
@RequiredArgsConstructor
public class BookRentalController {
	
	private final BookRentalService rentalService;
	private final BookRentalMapper rentalMapper;
	
	@GetMapping
	public List<BookRentalResponse> getBookRentals(){
		List<BookRental> rentals = rentalService.getBookRentals();
		return rentalMapper.toBookRentalResponseList(rentals);
	}
}
