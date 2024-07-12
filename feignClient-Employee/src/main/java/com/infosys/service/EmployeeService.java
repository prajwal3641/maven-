package com.infosys.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.entity.Employee;
import com.infosys.feignclient.AddressClient;
import com.infosys.repository.EmployeeRepository;
import com.infosys.response.AddressResponse;
import com.infosys.response.EmployeeResponse;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository erepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AddressClient aclient;
	
	public EmployeeResponse getEmp(int id){
		Employee emp = erepo.findById(id).get();
		EmployeeResponse eRes = mapper.map(emp, EmployeeResponse.class);
		ResponseEntity<AddressResponse> addRes = aclient.getAddressByEmployeeId(id);
		eRes.setAddressResponse(addRes.getBody());
		return eRes ;
	}
}
