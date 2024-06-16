package com.infosys.service;

import java.util.List;

import com.infosys.entity.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> getAll();
	public void insertEmp(EmployeeDTO empdto);
	public EmployeeDTO searchEmp(int id);
	public void updateEmp(int id,String name);
	public void removeEmp(int id);
}
