package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{
	
}
