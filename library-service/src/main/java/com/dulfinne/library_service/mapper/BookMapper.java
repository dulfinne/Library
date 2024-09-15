package com.dulfinne.library_service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.dulfinne.library_service.dto.response.BookResponse;
import com.dulfinne.library_service.model.Book;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
	BookResponse toResponse(Book book);

	List<BookResponse> toBookResponseList(List<Book> books);
}
