package com.example.demo.controlleradvice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ControllerAdviceException extends ResponseEntityExceptionHandler{
	
	@RequestMapping(produces="application/json")
	//@ExceptionHandler(ResourceNotFoundException.class)
	@ExceptionHandler(value= {EmployeeServiceException.class, ResourceNotFoundException.class})
	protected ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request){
		System.out.println("Inside Controller Advice");
		return handleExceptionInternal(ex, "Cannot process the request", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
}
