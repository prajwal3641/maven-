package com.infosys.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@NotNull(message="cust_id is null")
	private Integer cust_id;
	@NotNull(message="cust_name is null")
	private String cust_name;
	@NotNull(message="customer age is null")
	@Min(value=18,message="age should not be less than 18")
	private Integer age;
	@NotNull(message="gender is null")
	private Character gender;
	@NotNull(message="address is null")
	@Size(min=5,max=12,message="address range should be in 5 to 12")
	private String address;
	@Email(message="email not valid")
	private String email;
}
