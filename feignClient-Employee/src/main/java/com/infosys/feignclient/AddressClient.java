package com.infosys.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infosys.response.AddressResponse;

@FeignClient(name="feignClient-Address",url = "http://localhost:8081",path = "/address-service")
public interface AddressClient {
	
	@GetMapping("/address/{id}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("id")int id);
}
