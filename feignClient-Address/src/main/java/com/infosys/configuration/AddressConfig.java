package com.infosys.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class AddressConfig {
	
	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}
}
