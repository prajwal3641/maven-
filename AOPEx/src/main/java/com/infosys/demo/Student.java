package com.infosys.demo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Student {
	int reg_no;
	ArrayList<Integer> marks;
	
	public void display() {
	  System.out.println("RegNo : " + reg_no);
	  for(int num:marks) {
		  System.out.println(num);
	  }
	}
	
	public int checkAvg() {
		int sum =0 ;
		for(int num:marks) {
			sum += num;
		}
		return sum/marks.size();
				
	}

}
