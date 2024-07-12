package com.infosys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.response.AddressResponse;
import com.infosys.service.AddressService;

@RestController
public class AddressController {
		
	@Autowired
	private AddressService service;
	
	@GetMapping("/address/{empId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("empId")int id){
		AddressResponse addressResponse = service.findAddressByEmployeeId(id);
		return new ResponseEntity<AddressResponse>(addressResponse,HttpStatus.OK);
	}
}
