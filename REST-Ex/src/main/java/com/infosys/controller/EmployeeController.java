package com.infosys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entity.Employee;
import com.infosys.exception.EmployeeAllReadyExistsException;
import com.infosys.exception.EmployeeNotFoundException;
import com.infosys.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Emp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping(value="/getAll", produces="application/json")
	public ResponseEntity getAll() {
		return new ResponseEntity<>(service.getAllEmp(),HttpStatus.OK);
	}
	
	
	//1. ADD NEW EMPLOYEE
	
	@PostMapping(consumes="application/json")
	public String insertEmp(@Valid @RequestBody Employee e) throws EmployeeAllReadyExistsException {
		service.insertEmp(e);
		return "inserted successfully";
	}
	
	
	//2. Display list of Employees based on empid and designation
	@GetMapping(produces="application/json")
	public ResponseEntity getEmpBy(@RequestParam("empid")int id,@RequestParam("desig")String desig) {
		return new ResponseEntity<>(service.getEmpByIdAndDesig(id,desig),HttpStatus.OK);
	}
	
	
	//3. Get Employee details based on empid
	@GetMapping(value="/{empid}",produces="application/json")
	public ResponseEntity getEmpById(@PathVariable("empid")int id) throws EmployeeNotFoundException {
		return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
	}
	
	
	//4. Update Employee Details Based on Empid
	@PutMapping(value="/{empid}",consumes="application/json")
	public String updateEmp(@PathVariable("empid")int id,@Valid @RequestBody Employee e)throws EmployeeNotFoundException {
		service.update(id,e);
		return "updated successfully";
	}
	
	//5. Delete Employee
	@DeleteMapping(value="/{empid}")
	public String deleteEmp(@PathVariable("empid")int id)throws EmployeeNotFoundException {
		service.delete(id);
		return "deleted successfully";
	}
	
	
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
		return new ResponseEntity<>("ERROR:++++ :: Employee not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=EmployeeAllReadyExistsException.class)
	public ResponseEntity handleEmployeeAllReadyExistsException(EmployeeAllReadyExistsException ex) {
		return new ResponseEntity<>("ERROR:++++ :: Employee already exists",HttpStatus.CONFLICT);
	}
}
