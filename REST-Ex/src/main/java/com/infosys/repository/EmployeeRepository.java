package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query(value="select *from employee where emp_id=? or designation=?",nativeQuery=true)
	public List<Employee> getByBothIdDesig(int id,String desig);
	
	@Query(value="select exists(select 1 from employee where emp_name=?)",nativeQuery=true)
	public boolean existByName(String name);
}
