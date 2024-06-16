package com.infosys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private Integer emp_id;
	private String emp_name;
	private String department;
	private String base_location;
	private Integer address;
	
	public static Employee prepareEmployee(EmployeeDTO empdto) {
		Employee emp = new Employee();
		emp.setEmp_id(empdto.getEmp_id());
		emp.setEmp_name(empdto.getEmp_name());
		emp.setDepartment(empdto.getDepartment());
		emp.setBase_location(empdto.getBase_location());
		emp.setAddress(empdto.getAddress());
		return emp;
	}
}
