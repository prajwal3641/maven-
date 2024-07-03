package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Customer;
import com.infosys.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping(produces="application/json")
	public List<Customer> fetchCustomers(){
		return service.listAll();
	}
	
	@PostMapping(consumes="application/json")
	public String insertCustomer(@RequestBody Customer customer){
		return service.insertCust(customer);
	}
	
	@GetMapping(value="/{custid}",produces="application/json")
	public ResponseEntity<Customer> getByCustId(@PathVariable("custid")int custid) {
		Customer customer = service.getById(custid);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{custid}")
	public String deleteCustomer(@PathVariable("custid")int id) {
		service.delete(id);
		return "deletion successfull";
	}
}
