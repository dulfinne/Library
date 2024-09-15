package com.dulfinne.library_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dulfinne.library_service.model.Book;
import com.dulfinne.library_service.model.Status;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByStatus(Status status);
}
