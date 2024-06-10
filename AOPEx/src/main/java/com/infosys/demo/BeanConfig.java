package com.infosys.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class BeanConfig {
	
	@Bean
	public Student student() {
		return new Student();
	}
	
	@Bean
	public LoggingAspect logAspect() {
		return new LoggingAspect();
	}
}
