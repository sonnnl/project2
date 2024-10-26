package com.java_web_test.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.java_web_test.model.BuildingDTO;
import com.java_web_test.reponsitory.BuildingReponsitory;
import com.java_web_test.reponsitory.entity.BuildingEntity;
@Repository
public class BuildingReponsitoryImpl implements BuildingReponsitory{
	private static final String url = "jdbc:mysql://localhost:3306/estatebasic";
	private static final String username = "root";
    private static final String password = "son17092004";
	@Override
	public List<BuildingEntity> findAll(String name, Long district) {
		StringBuilder sqlQuery = new StringBuilder("SELECT * FROM building b where 1 = 1 ") ;
		if(name != null && !name.equals("")) {
			sqlQuery.append("and b.name like '%" + name +"%' ");
		}
		if(district != null) {
			sqlQuery.append("and b.districtid = " + district + " ");
		}
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection con = DriverManager.getConnection(url,username,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery.toString());)
		{
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString(2));
				building.setNumberOfBasement(rs.getInt(7));
				building.setStreet(rs.getString(3));
				building.setWard(rs.getString(4));
				result.add(building);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
