package com.cg.hbms.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

public ResponseEntity<ErrorMessage> handleException(UserNotFoundException e) {
		
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
				
	}
	
	public ResponseEntity<ErrorMessage> genericException(Exception e) {
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	
	
}
