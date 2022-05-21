package com.dragondesarrollo.restservices.exceptions;

import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//En este método se cachan los errores de validación de las entities
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		List<ObjectError> allErrors = ex.getAllErrors();
		
		String messages = "";
		for(int i = 0; i < allErrors.size(); i++) {
			messages += allErrors.get(i).getDefaultMessage() + "\n";
		}
		
		
		CustomErrorDetails customErrorDetails = new 
				CustomErrorDetails(new Date(), 
								   "From MethodArgumentNotValid Exception in GEH",
								   messages);
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		CustomErrorDetails customErrorDetails = new 
				CustomErrorDetails(new Date(), 
								   status.name(),
								   ex.getMessage());
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	// UserNameNotFoundException
	@ExceptionHandler(UserNameNotFoundException.class)
	public final ResponseEntity<Object> handleUsernameNotFoundException(UserNameNotFoundException ex,
			WebRequest request) {
		CustomErrorDetails customErrorDetails = new 
				CustomErrorDetails(new Date(), 
								   ex.getMessage(),
								   request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	// ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		CustomErrorDetails customErrorDetails = new 
				CustomErrorDetails(new Date(), 
								   ex.getMessage(),
								   request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}

}
