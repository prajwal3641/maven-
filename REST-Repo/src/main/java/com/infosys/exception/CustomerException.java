package com.infosys.exception;

public class CustomerException extends RuntimeException{

	public CustomerException() {
		super();
	}
	
	public CustomerException(String msg) {
		super(msg);
	}
}
