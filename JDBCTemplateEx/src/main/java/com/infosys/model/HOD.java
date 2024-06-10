package com.infosys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HOD {
	private Integer hod_id;
	private String hod_name;
	private String hod_experience;
	private String hod_incharge_date;
}
