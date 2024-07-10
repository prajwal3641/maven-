package com.infosys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
	private Long id;
	private String Name;
	private String lastName;
	private String email;
	private String departmentid;
}
