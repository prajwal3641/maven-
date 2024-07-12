package com.infosys.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.infosys.repository.AddressRepository;
import com.infosys.response.AddressResponse;

public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse findAddressByEmployeeId(int empid) {
		return new AddressResponse();
	}
}
