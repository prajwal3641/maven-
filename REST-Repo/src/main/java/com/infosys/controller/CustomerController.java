package com.infosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Customer;
import com.infosys.exception.CustomerException;
import com.infosys.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
//	@GetMapping(produces="application/json")
//	public List<Customer> fetchCustomers(){
//		return service.listAll();
//	}
	
	@PostMapping(consumes="application/json")
	public String insertCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
		return service.insertCust(customer);
	}
	
	@GetMapping(value="/{custid}",produces="application/json")
	public ResponseEntity<Customer> getByCustId(@PathVariable("custid")int custid) throws CustomerException{
		Customer customer = service.getById(custid);
		if(customer != null) {
			
		}else {
			throw new CustomerException("customer do not exists");
		}
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{custid}")
	public String deleteCustomer(@PathVariable("custid")int id) {
		service.delete(id);
		return "deletion successfull";
	}
	
	@PutMapping(value="/{custid}",consumes="application/json")
	public String updateCustomer(@PathVariable("custid")int id,@Valid @RequestBody Customer cust) {
		Customer custy = service.getById(id);
		if(custy != null)
		     service.update(cust,id);
		else
			throw new CustomerException("id is not existing");
		return "Updation successfully";
	}
	
	@GetMapping(produces="application/json")
	public List<Customer> fetchDetails(@RequestParam("custid")int custid,@RequestParam("custname")String name){
		return service.fetchCustomer(custid, name);
	}
}
