package com.infosys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	private DepartmentsDto departmentsDto;
	private UserInfoDto userInfoDto;

}
