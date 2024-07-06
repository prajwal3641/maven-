package com.infosys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Customer;
import com.infosys.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository crepo;
	
	public List<Customer> listAll(){
		return crepo.findAll();
	}
	
	public String insertCust(Customer customer) {
		crepo.save(customer);
		return "insert successfull";
	}
	
	public Customer getById(int id) {
		return crepo.findById(id).get();
	}
	
	public void delete(int id) {
		crepo.deleteById(id);
	}
	
	public void update(Customer cust,int id) {
		 crepo.updateCust(cust.getCust_name(), cust.getAge(), cust.getGender(), cust.getAddress(), id);
	}
	
	public List<Customer> fetchCustomer(Integer id,String name){
        return crepo.getDetails(id, name);
		 
	}
}
