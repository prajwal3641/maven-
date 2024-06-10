package com.infosys.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class HODmapper implements RowMapper<HOD> {

	@Override
	public HOD mapRow(ResultSet rs, int rowNum) throws SQLException {
		HOD hod = new HOD();
		hod.setHod_id(rs.getInt("hod_id"));
		hod.setHod_name(rs.getString("hod_name"));
		hod.setHod_experience(rs.getString("hod_experience"));
		hod.setHod_incharge_date(rs.getString("hod_incharge_date"));
		return hod;
	}
	
}
