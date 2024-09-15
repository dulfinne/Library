package com.dulfinne.bookservice.dto.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record BookRequest(

		@NotNull(message = "Isbn can't be null")
		@Pattern(regexp = "\\d{3}-\\d-\\d{5}-\\d{3}-\\d", message = "Invalid ISBN format")
		String isbn,

		@NotNull(message = "Name can't be null")
		@Length(max = 70, message = "Book name must be under {max} characters")
		String name,

		@NotNull(message = "Genre can't be null")
		@Length(max = 30, message = "Genre must be under {max} characters")
		String genre,

		@NotNull(message = "Description can't be null")
		@Length(max = 250, message = "Description must be under {max} characters")
		String info,

		@NotNull(message = "Author can't be null")
		@Length(max = 50, message = "Author name must be under {max} characters")
		String author
) {
}
