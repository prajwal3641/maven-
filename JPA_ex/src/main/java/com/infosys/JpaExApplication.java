package com.infosys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.domain.Address;
import com.infosys.domain.Employee;
import com.infosys.service.EService;

@SpringBootApplication
public class JpaExApplication implements CommandLineRunner {
	
	@Autowired
	EService service;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//1. insertion 	
//		Address add1 = new Address(4,"banglore","500000");
//		Employee emp1 = new Employee(5,70000.00,"B","392309","gitak patil","SDE-2","jalgoan",add1);
//		service.insertEmployee(emp1);
		
		
		
		//2. Display
//		Iterable<Employee> eList = service.getEmp();
//		for(Employee e: eList) {
//			System.out.println(e);
//		}
		
		
		
		// 3. Search Employee
		//System.out.println(service.searchEmp(3));
		
		
		
		// 4. Delete Employee (address is not deleted)
		//service.deleteEmp(4);
		
		
		
		// 5. Update the Employee
		//service.updateEmp(5,"suhel pakjade");
		
		
		
		// 6. Retrieve Employees on the given band level
		// NOTE : we can replace the underscores(database names) to camelcasing
//		Iterable<Employee> eList = service.getByEmp_band_level("B");
//		for(Employee e:eList) {
//			System.out.println(e);
//		}
		
		
		// 7. update the emp salary based on their band levels
		service.getupdateSalary("A", 1.15);
		service.getupdateSalary("B", 1.1);
		service.getupdateSalary("C", 1.05);
		
	}

}
