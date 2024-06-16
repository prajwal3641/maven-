package com.infosys;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infosys.entity.Employee;
import com.infosys.entity.EmployeeDTO;
import com.infosys.service.EmployeeService;

@SpringBootApplication
public class OrMexApplication implements CommandLineRunner{
	
	@Autowired
	ApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(OrMexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		EmployeeService employeService  = context.getBean("EmployeeService",EmployeeService.class);
		//1. Add Employee
		
		EmployeeDTO emp1 = new EmployeeDTO(3,"prajwal","mech","bangalore",3);
		employeService.insertEmp(emp1);
		
		//2. Search Employee
		
//		EmployeeDTO emp2 = employeService.searchEmp(2);
//		System.out.println(emp2);
		
		//3. view all employees
		
//		System.out.println("viewing all Employee Details");
//		ArrayList<EmployeeDTO> eList = (ArrayList<EmployeeDTO>)employeService.getAll();
//		for(EmployeeDTO employee : eList) {
//			System.out.println(employee);
//		}
		
		
		
		//4. Edit Employee
		
		//employeService.updateEmp(1, "prasad");
		
		//5. Remove Employee
		
		//employeService.removeEmp(2);
	}

}
