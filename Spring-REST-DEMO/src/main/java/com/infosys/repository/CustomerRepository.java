package com.infosys.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infosys.entity.Customer;

import jakarta.annotation.PostConstruct;

@Repository
public class CustomerRepository {
	
	List<Customer> customers = null;
	
	// creating a static repo , i.e.data is not stored(not connected to the database)
	@PostConstruct
	public void initializer() {
		Customer customer = new Customer();
		customer.setPhoneNo(189483439L);
		customer.setName("Sachin");
		customer.setAge(45);
		customer.setEmail("sachin@gmail.com");
		customer.setGender('M');
		customers = new ArrayList<>();
		customers.add(customer);
	}
	
	public List<Customer> fetchCustomer(){
		return customers;
	}
	
	public void createCustomer(Customer customer) {
		customers.add(customer);
	}
	public void deleteCustomer(Customer customer) {
		customers.remove(customer);
	}
}
