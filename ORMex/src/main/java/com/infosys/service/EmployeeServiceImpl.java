package com.infosys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dao.EmployeeDAO;
import com.infosys.entity.Employee;
import com.infosys.entity.EmployeeDTO;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO employeeDAO;
	@Override
	public List<EmployeeDTO> getAll() {
		List<EmployeeDTO> empList = new ArrayList<>();
		List<Employee> EmpEntityList = employeeDAO.getAll();
		for(Employee empEntity : EmpEntityList) {
			EmployeeDTO empDTO  = Employee.prepareDTO(empEntity);
			empList.add(empDTO);
		}
		return empList;
	}
	@Override
	public void insertEmp(EmployeeDTO empdto) {
		employeeDAO.insertEmp(EmployeeDTO.prepareEmployee(empdto));
	}
	@Override
	public EmployeeDTO searchEmp(int id) {
		
		return Employee.prepareDTO(employeeDAO.searchEmp(id));
	}
	@Override
	public void updateEmp(int id, String name) {
		employeeDAO.updateEmp(id, name);
	}
	@Override
	public void removeEmp(int id) {
		employeeDAO.removeEmp(id);
	}

}
