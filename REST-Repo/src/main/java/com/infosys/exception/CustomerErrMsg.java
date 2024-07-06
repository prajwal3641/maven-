package com.infosys.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class CustomerErrMsg {
	HttpStatus status;
	String msg;
}
