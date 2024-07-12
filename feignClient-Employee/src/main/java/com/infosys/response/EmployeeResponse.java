package com.infosys.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
	private Integer id;
	private String name;
	private String email;
	private Integer age;
	
	private AddressResponse addressResponse;
}
