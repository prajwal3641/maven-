package com.infosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientEmployeeApplication.class, args);
	}

}
