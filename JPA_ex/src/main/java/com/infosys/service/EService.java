package com.infosys.service;

import java.util.List;

import com.infosys.domain.Address;
import com.infosys.domain.Employee;

 
public interface EService {
	public void insertEmployee(Employee emp);
	public void insertAddress(Address add);
	public Iterable<Employee> getEmp();
	public Employee searchEmp(int emp_id);
	public void deleteEmp(int emp_id);
	public void updateEmp(int emp_id,String name);
	public List<Employee> getByEmp_band_level(String emp_band_level);
	public void getupdateSalary(String empbandlevel,double per);
}