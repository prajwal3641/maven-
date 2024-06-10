package com.infosys.DAO;

import java.util.List;

import com.infosys.model.Department;
import com.infosys.model.HOD;


public interface DAO {
	public List<Department> listDepartment();
	public boolean createDepartment(Department department);
	public boolean createHOD(HOD hod,int dept_id);
	List<HOD> listHOD();
	
	public void searchDeptHod(int dept_id);
	public Department searchDept(int dept_id);
	public HOD searchHOD(int hod_id);
	
	public int getHodIdByDeptId(int dept_id);
	
	public boolean updateDepartment(Department d);
	public boolean updateHOD(HOD h);
	
	
	public boolean removeDepartment(int dept_id);
	public boolean removeHOD(int hod_id);
	
	 
}
