package com.elenildo.school.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BadRequestExceptionDetails {
	private String title;
	private int status;
	private String details;
	private LocalDateTime timestamp;
	
}
