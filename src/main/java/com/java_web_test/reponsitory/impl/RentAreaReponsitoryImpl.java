package com.java_web_test.reponsitory.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.java_web_test.reponsitory.RentAreaReponsitory;
import com.java_web_test.reponsitory.entity.RentAreaEntity;
import com.java_web_test.utils.ConnectionUtil;
@Repository
public class RentAreaReponsitoryImpl implements RentAreaReponsitory{
	@Override
	public List<RentAreaEntity> getRentAreaByBuildingId(Integer id){
		String sqlQuery = "select * from rentarea where rentarea.buildingid = " + id + " ";
		List<RentAreaEntity> list = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery)){
			while(rs.next()) {
				RentAreaEntity rae = new RentAreaEntity();
				rae.setValue(rs.getString("value"));
				list.add(rae);
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return list;
		
	}
}
