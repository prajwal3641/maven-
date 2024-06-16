package com.infosys.dao;

import java.util.List;

import com.infosys.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> getAll();
	public void insertEmp(Employee emp);
	public Employee searchEmp(int id);
	public void updateEmp(int id,String name);
	public void removeEmp(int id);
}
