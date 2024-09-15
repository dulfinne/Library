package com.dulfinne.library_service.dto.response;

import com.dulfinne.library_service.model.Status;

public record BookResponse(

		Long id,

		Status status
){
}
