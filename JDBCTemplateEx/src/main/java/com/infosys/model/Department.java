package com.infosys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	private Integer dept_id;
	private String dept_name;
	private Integer dept_intake;
	private Integer dept_duration;
}
