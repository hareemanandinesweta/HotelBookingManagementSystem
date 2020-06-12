package com.cg.hotelbookingmanagementsystem.HotelService.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
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
















//@ExceptionHandler(HotelNotFoundException.class)
//public ResponseEntity<ErrorMessage> handleException(HotelNotFoundException e) {
//	//return e.getMessage();
//	ErrorMessage error=new ErrorMessage();
//	error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
//	error.setErrorMessage(e.getMessage());
//	return new ResponseEntity<>(error,HttpStatus.OK);
//			
//}




////@ExceptionHandler(Exception.class)
//public ResponseEntity<ErrorMessage> genericException(Exception e) {
//	ErrorMessage error=new ErrorMessage();
//	error.setStatusCode(HttpStatus.BAD_REQUEST.value());
//	error.setErrorMessage(e.getMessage());
//	return new ResponseEntity<>(error,HttpStatus.OK);
//}
