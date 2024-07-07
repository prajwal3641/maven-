package com.infosys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@NotNull(message="empid is null")
	private Integer emp_id;
	@NotNull(message="empname is null")
	private String emp_name;
	@NotNull(message="designation is null")
	private String designation;
	@NotNull(message="salary is null")
	@Max(value=150000,message="salary should not be greater than 150000")
	private Long salary;
}
