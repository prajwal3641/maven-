package com.infosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.domain.Address;
import com.infosys.domain.Employee;
import com.infosys.repository.AddressRepository;
import com.infosys.repository.EmployeeRepository;

@Service
public class ServiceImpl  implements EService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	AddressRepository addRepo;
	
	 
	
	@Override
	public void insertEmployee(Employee emp) {
		this.insertAddress(emp.getAddress());
		empRepo.saveAndFlush(emp);
	}
	
	@Override
	public void insertAddress(Address add) {
		addRepo.saveAndFlush(add);
	}

	@Override
	public Iterable<Employee> getEmp() {
		return (List<Employee>)empRepo.findAll();
	}

	@Override
	public Employee searchEmp(int emp_id) {
		Optional<Employee> oshipper = empRepo.findById(emp_id);
		return  oshipper.get();
	}

	@Override
	public void deleteEmp(int emp_id) {
		empRepo.deleteById(emp_id);
	}

	@Override
	public void updateEmp(int emp_id, String name) {
		Optional<Employee> oshipper = empRepo.findById(emp_id);
		Employee e = oshipper.get();
		e.setEmp_name(name);
		empRepo.save(e);
		System.out.println("updated successfully");
		
	}

	 

	@Override
	public List<Employee> getByEmp_band_level(String emp_band_level) {
		return empRepo.findByEmpBandLevel(emp_band_level);
	}

	@Override
	public void getupdateSalary(String empbandlevel, double per) {
		empRepo.updateSalary(empbandlevel, per);
	}

 

}
