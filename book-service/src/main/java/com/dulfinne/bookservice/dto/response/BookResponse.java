package com.dulfinne.bookservice.dto.response;

public record BookResponse(
		long id,
		String isbn,
		String name,
		String genre,
		String info,
		String author
) {
}
