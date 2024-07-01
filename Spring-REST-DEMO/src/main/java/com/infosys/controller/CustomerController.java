package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Customer;
import com.infosys.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService cservice;
	
	@GetMapping(produces="application/json")
	public List<Customer> fetchCustomer(){
		return cservice.fetchCustomer();
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
		String response = cservice.createCustomer(customer);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="/{phoneNumber}",produces="application/json")
	public List<Customer> fetchCustomerByPhoneno(@PathVariable("phoneNumber")long Phoenumber){
		return cservice.listByPhoneno(Phoenumber);
	}
	
	@PutMapping(value="/{phone}",consumes="application/json")
	public String updateCustomerByPhone(@PathVariable("phone")long phoneNumber,@RequestBody Customer customer) {
		return cservice.updateCustomer(phoneNumber, customer);
	}
	
	@DeleteMapping(value="/{phone}")
	public String deleteCustomerByPhone(@PathVariable("phone")long phoneNo) {
		return cservice.deleteCustomer(phoneNo);
	}
}
