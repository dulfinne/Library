package com.dulfinne.library_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dulfinne.library_service.model.BookRental;

public interface BookRentalRepository extends JpaRepository<BookRental, Long> {

}
