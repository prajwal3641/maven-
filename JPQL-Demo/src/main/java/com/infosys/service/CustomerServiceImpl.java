package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.Customersdto;
import com.infosys.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository crepo;
	
	@Override
	public List<Customersdto> getallCustomerdetails() {
		// TODO Auto-generated method stub
		return crepo.getCustomerdetails();
	}

}
