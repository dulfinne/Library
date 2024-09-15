package com.dulfinne.library_service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.dulfinne.library_service.dto.response.BookRentalResponse;
import com.dulfinne.library_service.model.BookRental;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookRentalMapper {
	BookRentalResponse toResponse(BookRental bookRental);

	List<BookRentalResponse> toBookRentalResponseList(List<BookRental> rentals);
}
