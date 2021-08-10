package com.elenildo.school.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.elenildo.school.exception.BadRequestException;
import com.elenildo.school.exception.BadRequestExceptionDetails;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
		return new ResponseEntity<>(
				BadRequestExceptionDetails.builder()
				.timestamp(LocalDateTime.now())
				.title("Bad request exception. Check the documentation.")
				.details(bre.getMessage())
				.status(HttpStatus.BAD_REQUEST.value())
				.build(), HttpStatus.BAD_REQUEST);
	}
}
