package com.cg.hbms.hotelservice.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(HotelNotFoundException.class)
	public String handleException(HotelNotFoundException e) {

		return e.getMessage();
	}

	@ExceptionHandler(HotelNameNotFoundException.class)
	public String handleNameException(HotelNameNotFoundException e) {

		return e.getMessage();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getConstraintViolations().forEach(cv -> {
			errors.put("message", cv.getMessage());
			errors.put("path", (cv.getPropertyPath()).toString());
		});

		return errors;
	}

}
