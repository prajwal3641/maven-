package com.infosys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsDto {
	private Long id;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}
