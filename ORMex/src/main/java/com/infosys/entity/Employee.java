package com.infosys.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	@Id
	@Column
	private Integer emp_id;
	private String emp_name;
	private String department;
	private String base_location;
	private Integer address;
	
	public static EmployeeDTO prepareDTO(Employee emp) {
		EmployeeDTO empdto = new EmployeeDTO();
		empdto.setEmp_id(emp.getEmp_id());
		empdto.setEmp_name(emp.getEmp_name());
		empdto.setDepartment(emp.getDepartment());
		empdto.setBase_location(emp.getBase_location());
		empdto.setAddress(emp.getAddress());
		return empdto;
	}
}
