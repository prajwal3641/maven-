package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.domain.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	List<Employee> findByEmpBandLevel(String emp_band_level);
	
	@Modifying
	@Transactional
	@Query("update Employee e set e.emp_salary = e.emp_salary * :percent where e.empBandLevel = :empbandlevel")
	void updateSalary(String empbandlevel,double percent);
}
