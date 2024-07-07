package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.entity.Employee;
import com.infosys.exception.EmployeeAllReadyExistsException;
import com.infosys.exception.EmployeeNotFoundException;
import com.infosys.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository erepo;
	
	public List<Employee> getAllEmp(){
		return erepo.findAll();
	}
	
	
	public void insertEmp(Employee e) throws EmployeeAllReadyExistsException{
		if(erepo.existsById(e.getEmp_id())) {
			throw new EmployeeAllReadyExistsException("Employee already exists");
		}else {
			erepo.save(e);
		}
	}
	
	public List<Employee> getEmpByIdAndDesig(int id,String desig){
//		if(erepo.existsById(id) && erepo.existByName(desig) == true) {
			return erepo.getByBothIdDesig(id, desig);
//		}else {
//			throw new EmployeeNotFoundException("Employee with this condition do not exists");
//		}
	}
	
	public Employee getById(int id) throws EmployeeNotFoundException {
		if(erepo.existsById(id)) {
			return erepo.findById(id).get();
		}else {
			throw new EmployeeNotFoundException("Employee id do not exists getById");
		}
		
	}
	
	public void update(int id,Employee e) {
		if(erepo.existsById(id)) {
			Employee emp = erepo.findById(id).get();
			emp.setEmp_name(e.getEmp_name());
			emp.setDesignation(e.getDesignation());
			emp.setSalary(e.getSalary());
			erepo.save(emp);
		}else {
			throw new EmployeeNotFoundException("Employee id do not exists update");
		}
	}
	
	public void delete(int id) {
		if(erepo.existsById(id)) {
			erepo.deleteById(id);
		}else {
			throw new EmployeeNotFoundException("Employee id do not exists delete");
		}
		
	}
}
