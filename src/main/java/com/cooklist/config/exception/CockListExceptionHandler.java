package com.cooklist.config.exception;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CockListExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CockListException.class)
	protected ResponseEntity<String> handleException (CockListException exc, WebRequest request) {
		
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		String message = "¡Error desconocido!";
		
		if (Objects.nonNull(exc.getExceptionType())) {
			httpStatus = exc.getExceptionType().httpStatus;
		}
		if (StringUtils.isNoneBlank(exc.getMessage())) {
			message = exc.getMessage();
		}
		
		return ResponseEntity.status(httpStatus).body(message);
		
	}
	
}
