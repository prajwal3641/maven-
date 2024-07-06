package com.infosys.exception;

import java.net.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//The @RestControllerAdvice annotation is used to handle exceptions globally for all @RestController annotated classes.
@RestControllerAdvice(annotations=RestController.class)
public class MyRestExceptionHandler {
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders header,HttpStatus status,WebRequest webrequest){
		CustomerErrMsg er = new CustomerErrMsg();
		er.setMsg(ex.toString());
		er.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity(er,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler ({CustomerException.class})
	public ResponseEntity<CustomerErrMsg> handleException(CustomerException ce){
		CustomerErrMsg er = new CustomerErrMsg();
		er.setStatus(HttpStatus.NOT_FOUND);
		er.setMsg(ce.getMessage());
		return new ResponseEntity<>(er,er.getStatus());
	}

}
