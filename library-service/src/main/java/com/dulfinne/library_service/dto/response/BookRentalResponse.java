package com.dulfinne.library_service.dto.response;

import java.time.ZonedDateTime;

import com.dulfinne.library_service.model.Book;

public record BookRentalResponse(Long id,

		Book book,

		ZonedDateTime borrowedAt,

		ZonedDateTime returnBy
) {
}
