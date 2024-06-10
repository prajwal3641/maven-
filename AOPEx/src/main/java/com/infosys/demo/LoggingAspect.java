package com.infosys.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution (* com.infosys.demo.Student.display(..))")
	public void beforeLogging() {
		System.out.println("hi we are here before logging");
	}
	
	@After("execution (* com.infosys.demo.Student.display(..))")
	public void afterLogging() {
		System.out.println("hi we are here after logging");
	}
	
	@AfterReturning(pointcut="execution (* com.infosys.demo.Student.checkAvg(..))" , returning="retVal")
	public void AfterReturning(int retVal) {
		System.out.println("after returning , the Avg. Val is : " + retVal);
	}
	
//	@AfterThrowing(pointcut="execution (* com.infosys.demo.Student.checkAvg(..))",throwing="retVal")
//	public void afterThrowing(int retVal) {
//		System.out.println("after " + retVal);
//	}
}
