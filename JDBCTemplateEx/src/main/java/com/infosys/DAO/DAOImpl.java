package com.infosys.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.infosys.model.Department;
import com.infosys.model.DepartmentMapper;
import com.infosys.model.HOD;
import com.infosys.model.HODmapper;

@Component
public class DAOImpl implements DAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String SQL_ADD_DEPARTMENT = "insert into Department(dept_id,dept_name,dept_intake,dept_duration) values(?,?,?,?)";
	private final String SQL_GET_DEPARTMENT = "select *from Department";
	private final String SQL_GET_HOD = "select *from HOD";
	private final String SQL_ADD_HOD = "insert into HOD(hod_id,hod_name,hod_experience,hod_incharge_date) values(?,?,?,?)";
	private final String SQL_ADD_DEPT_HOD = "insert into Dept_Hod(dept_Id,hod_Id) values(?,?)";
	
	private final String SQL_UPDATE_DEPT_HOD = "update Dept_Hod set hod_Id=? where dept_Id=?";
	
	
	
	private final String SQL_FIND_DEPT = "select *from Department where dept_id=?";
	private final String SQL_FIND_HOD = "select *from HOD where hod_id=?";
	
	
	private final String SQL_GET_HOD_ID = "select hod_Id from Dept_Hod where dept_Id=?";
	private final String SQL_UPDATE_DEPARTMENT = "update Department set dept_name=? where dept_id=?";
	private final String SQL_UPDATE_HOD = "update HOD set hod_name=? where hod_id=?";
	
	private final String SQL_DELETE_DEPARTMENT = "delete from Department where dept_id=?";
	private final String SQL_DELETE_HOD = "delete from HOD where hod_id=?";
	
	public boolean createDepartment(Department dept) {
		boolean a = jdbcTemplate.update(SQL_ADD_DEPARTMENT,dept.getDept_id(),dept.getDept_name(),dept.getDept_intake(),dept.getDept_duration()) > 0;
		boolean c = jdbcTemplate.update(SQL_ADD_DEPT_HOD,dept.getDept_id(),-1) > 0;
		return a && c;
	}
	public List<Department> listDepartment(){
		List<Department> d =  jdbcTemplate.query(SQL_GET_DEPARTMENT, new DepartmentMapper());
		return d;
	}
	public List<HOD> listHOD(){
		return jdbcTemplate.query(SQL_GET_HOD, new HODmapper());
	}
	@Override
	public boolean createHOD(HOD hod,int dept_id) {
		boolean b = jdbcTemplate.update(SQL_ADD_HOD,hod.getHod_id(),hod.getHod_name(),hod.getHod_experience(),hod.getHod_incharge_date()) > 0;
		boolean c = jdbcTemplate.update(SQL_UPDATE_DEPT_HOD,hod.getHod_id(),dept_id) > 0;
		return b && c;
	}
	
	
	
	
	
	
	@Override
	public void searchDeptHod(int dept_id) {
		Department dept = searchDept(dept_id);
		System.out.println(dept.toString());
		
		int hod_id = getHodIdByDeptId(dept_id);
		HOD hod = searchHOD(hod_id);
		System.out.println(hod.toString());
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Department searchDept(int dept_id) {
		return jdbcTemplate.queryForObject(SQL_FIND_DEPT, new Object[]{dept_id} , new DepartmentMapper());
	}
	@SuppressWarnings("deprecation")
	@Override
	public HOD searchHOD(int hod_id) {
		return jdbcTemplate.queryForObject(SQL_FIND_HOD, new Object[]{hod_id} , new HODmapper());
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public int getHodIdByDeptId(int dept_id) {
		return jdbcTemplate.queryForObject(SQL_GET_HOD_ID, new Object[] {dept_id}, int.class);
	}
	
	
	
	
	
	
	@Override
	public boolean updateDepartment(Department d) {
		return jdbcTemplate.update(SQL_UPDATE_DEPARTMENT,d.getDept_name(),d.getDept_id()) > 0;
	}
	@Override
	public boolean updateHOD(HOD h) {
		return jdbcTemplate.update(SQL_UPDATE_HOD,h.getHod_name(),h.getHod_id()) > 0;
	}
	
	
	
	
	
	
	@Override
	public boolean removeDepartment(int dept_id) {
		// TODO Auto-generated method stub
	    return jdbcTemplate.update(SQL_DELETE_DEPARTMENT,dept_id) > 0;
	}
	@Override
	public boolean removeHOD(int hod_id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_DELETE_HOD,hod_id) > 0;
	}
}
