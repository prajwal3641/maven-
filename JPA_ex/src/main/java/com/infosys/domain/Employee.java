package com.infosys.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 // directly communicating with the database

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
	
	@Id
	@Column
	private Integer emp_id;
	@Column
	private double emp_salary;
	@Column
	// NOTE : we can replace the underscores(database names) to camelcasing
	private String empBandLevel;
	@Column
	private String emp_contact;
	@Column
	private String emp_name;
	@Column
	private String department;
	@Column
	private String base_location;
	
	@ManyToOne
	@JoinColumn(name = "address")
	private Address address;
}
