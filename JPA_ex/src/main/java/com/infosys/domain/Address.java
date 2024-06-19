package com.infosys.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 // directly communicating with the database

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
	@Id
	@Column
	private Integer address_id;
	@Column
	private String city;
	@Column
	private String pincode;
}
