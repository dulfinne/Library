package com.dulfinne.bookservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dulfinne.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<Book> findByIsbn(String isbn);
}

