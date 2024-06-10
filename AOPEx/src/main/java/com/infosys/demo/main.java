package com.infosys.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		Student student = context.getBean("student",Student.class);
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(51, 62, 43, 37, 75));
		student.setMarks(list);
		student.setReg_no(1);
		student.display();
		
		student.checkAvg();
	}

}
