package com.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(ServletRequestBindingException.class)
	public ResponseEntity<Object> handleHeaderError(Exception exception,WebRequest request){
		List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("OOPS.. header is missing",details);
		return new ResponseEntity<Object>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllErrors(Exception exception,WebRequest request){
		List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("OOPS.. server side error",details);
		return new ResponseEntity<Object>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
