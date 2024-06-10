package com.infosys;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.DAO.DAO;
import com.infosys.config.jdbcConfig;
import com.infosys.model.Department;
import com.infosys.model.HOD;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
		DAO obj = context.getBean(DAO.class);
		
		
		// #1 add department
		
//		System.out.println("showing departments !!");
//		
//		for(Department D : obj.listDepartment()) {
//			System.out.println(D);
//		}
//		Department dept1 = new Department(6,"ecet",15,2);
//		obj.createDepartment(dept1);
//		System.out.println("Adding Department");
//		for(Department D : obj.listDepartment()) {
//			System.out.println(D);
//		}
//		HOD hod1 = new HOD(105,"ramesh","3","26/08/2016");
//		obj.createHOD(hod1,5);
//		for(HOD h:obj.listHOD()) {
//			System.out.println(h);
//		}
		
		
		
		// #2 search Department and Hod details based on the Dept_id
		
		
//		obj.searchDeptHod(3);
// 		
		
		// #3 view department
		
//		for(Department d:obj.listDepartment()) {
//			System.out.println(d);
//		}
		
		
		// #4 Update Department and HOD details :  i.e. Dept_name and Hod_name
		
		

//		Department dept = obj.searchDept(4);
//		int hod_id = obj.getHodIdByDeptId(4);
//		HOD hod = obj.searchHOD(hod_id);
//		
//		System.out.println(dept.toString());
//		System.out.println(hod.toString());
//		System.out.println();
//		System.out.println("updating Department and HOD");
//		System.out.println();
//		// update the names
//		
//		dept.setDept_name("geoPolitics");
//		hod.setHod_name("prajwal");;
//		
//		obj.updateDepartment(dept);
//		obj.updateHOD(hod);
//		
//		System.out.println(dept.toString());
//		System.out.println(hod.toString());
		
		
		// #5 Remove the Department
		
		
//		int hod_id = obj.getHodIdByDeptId(3);
//		
		obj.removeDepartment(3);
//		
//		obj.removeHOD(hod_id);
//		
		for(Department D : obj.listDepartment()) {
			System.out.println(D);
		}
		for(HOD h:obj.listHOD()) {
			System.out.println(h);
		}
		
	}

}
