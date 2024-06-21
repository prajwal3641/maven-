package com.infosys.service;

import java.util.List;

import com.infosys.dto.Customersdto;

public interface CustomerService {
	// dircet wAY
	//public List<Customers>getallCustomerdetails();
	
	public List<Customersdto> getallCustomerdetails();
}
