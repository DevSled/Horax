package com.horax.timeManagement.controller.exception;

import java.time.LocalDate;
import java.time.LocalTime;

import com.horax.timeManagement.api.error.ErrorMessageDto;
import com.horax.timeManagement.api.error.MultipleErrorMessageDto;
import com.horax.timeManagement.controller.exception.exceptions.InputValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageFactory {

	public ErrorMessageDto simpleErrorMessageDto(HttpStatus status, Throwable ex) {
		String errorIdentifier = ex.hashCode() + "";
		return new ErrorMessageDto(LocalDate.now(), LocalTime.now(), status.toString(), errorIdentifier,
				ex.getMessage());
	}

	public ErrorMessageDto simpleErrorMessageDto(HttpStatus status, String errorCode, Throwable ex) {
		String errorIdentifier = ex.hashCode() + "";
		return new ErrorMessageDto(LocalDate.now(), LocalTime.now(), status.toString(), errorIdentifier,
				ex.getMessage(), errorCode);
	}

	public MultipleErrorMessageDto multipleErrorMessageDto(HttpStatus status, InputValidationException ex) {
		String errorIdentifier = ex.hashCode() + "";
		return new MultipleErrorMessageDto(LocalDate.now(), LocalTime.now(), status.toString(), errorIdentifier,
				ex.getMessage(), ex.getMessages());
	}

	public MultipleErrorMessageDto multipleErrorMessageDto(HttpStatus status, String errorCode,
			InputValidationException ex) {
		String errorIdentifier = ex.hashCode() + "";
		return new MultipleErrorMessageDto(LocalDate.now(), LocalTime.now(), status.toString(), errorIdentifier,
				ex.getMessage(), errorCode, ex.getMessages());
	}
}
