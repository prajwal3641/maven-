package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.entity.Customer;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	@Transactional
	@Modifying
	@Query(value="update customer set cust_name=?,age=?,gender=?,address=? where cust_id=?",nativeQuery = true)
	public void updateCust(String name,int age,Character gender,String address,int cust_id);
	
	@Query(value="select * from customer where cust_id=? or cust_name=?",nativeQuery=true)
	public List<Customer> getDetails(int id,String name);
}
