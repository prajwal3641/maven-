package com.infosys.repository;

import java.util.List;

import com.infosys.dto.Customersdto;

public interface CustomerRepository {
	
	// direct way
	//public List<Customers>getCustomerdetails();
	
	// inderictway]
	public List<Customersdto>getCustomerdetails();
}
