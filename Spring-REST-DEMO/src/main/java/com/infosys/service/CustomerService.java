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
	private CustomerRepository crepository;
	
	public List<Customer> fetchCustomer(){
		return crepository.fetchCustomer();
	}
	
	public String createCustomer(Customer customer) {
		crepository.createCustomer(customer);
		return "Customer with " + customer.getPhoneNo() + " has been inserted successfully !";
	}
	
	public List<Customer> listByPhoneno(long phoneno){
		List<Customer> customerDetails = new ArrayList<>();
		for(Customer cust:crepository.fetchCustomer()) {
			if(cust.getPhoneNo() == phoneno) {
				customerDetails.add(cust);
			}
		}
		return customerDetails;
	}
	
	public String updateCustomer(long phoneNumber,Customer customer) {
		String response="";
		for(Customer cust:crepository.fetchCustomer()) {
			if(cust.getPhoneNo() == phoneNumber) {
				if(customer.getName() != null) {
					cust.setName(customer.getName());
				}
				if(customer.getEmail() != null) {
					cust.setEmail(customer.getEmail());
				}
				if(customer.getGender() != null) {
					cust.setGender(customer.getGender());
				}
				if(customer.getAge() != null) {
					cust.setAge(customer.getAge());
				}
				
				response = "Customers of phoneno " + phoneNumber + " updated successfully";
				break;
			}else {
				response = "Customer do not exists";
			}
		}
		return response;
	}
	
	public String deleteCustomer(long phoneNo) {
		String response="";
		for(Customer cust:crepository.fetchCustomer()) {
			if(cust.getPhoneNo() == phoneNo) {
				crepository.deleteCustomer(cust);
				response = "Customers of phoneno " + phoneNo + " Deleted successfully";
				break;
			}else {
				response = "Customer do not exists";
			}
		}
		return response;
	}
}
