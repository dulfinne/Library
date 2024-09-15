package com.dulfinne.bookservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.dulfinne.bookservice.dto.request.BookRequest;
import com.dulfinne.bookservice.dto.response.BookResponse;
import com.dulfinne.bookservice.model.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
	
	Book toBook(BookRequest request);
	
	BookResponse toResponse(Book book);
	
	List<BookResponse> toBookResponseList(List<Book> books);
}
