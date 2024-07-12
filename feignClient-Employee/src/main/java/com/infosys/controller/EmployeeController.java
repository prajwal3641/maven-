package com.infosys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.response.EmployeeResponse;
import com.infosys.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeResponse> getEmpById(@PathVariable("id")int id){
		return new ResponseEntity<EmployeeResponse>(service.getEmp(id),HttpStatus.OK);
	}
}
