package com.infosys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.domain.Customers;
import com.infosys.dto.Customersdto;
import com.infosys.service.CustomerService;

@SpringBootApplication
public class JpqlDemoApplication implements CommandLineRunner{
	@Autowired
	CustomerService service;
	public static void main(String[] args) {
		SpringApplication.run(JpqlDemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		getCustomerDetails();
	}
	
	public void getCustomerDetails() {
		List<Customersdto> clist = service.getallCustomerdetails();
		for(Customersdto c:clist) {
			System.out.println(c);
		}
	}

}
