package com.java_web_test.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.java_web_test.model.BuildingDTO;
import com.java_web_test.reponsitory.BuildingReponsitory;
import com.java_web_test.reponsitory.entity.BuildingEntity;
import com.java_web_test.utils.ConnectionUtil;
import com.java_web_test.utils.NumberUtil;
import com.java_web_test.utils.StringUtil;
@Repository
public class BuildingReponsitoryImpl implements BuildingReponsitory{
    public static void joinTable(Map<String,String> params,List<String> typeCode,StringBuilder sql) {
    	String staffID =  params.get("staffID");
    	if(!StringUtil.isEmptyString(staffID)) {
    		sql.append(" Inner join assignmentbuilding ab on ab.buildingid = b.id ");
    	}
    	if(typeCode!=null&&!typeCode.isEmpty()) {
    		sql.append(" Inner join buildingrenttype brt on brt.buildingid = b.id join renttype rt on rt.id = brt.renttypeid ");
    	}
    	String rentAreaMin = params.get("rentAreaMin");
    	String rentAreaMax = params.get("rentAreaMax");
    	if(!StringUtil.isEmptyString(rentAreaMin) || !StringUtil.isEmptyString(rentAreaMax) ) {
    		sql.append(" Inner join rentare r on r.buildingid = b.id");
    	}
    }
    
    public static void normalQuery(Map<String,String> params,List<String> typeCode,StringBuilder where) {
    	for(Map.Entry<String, String> entry : params.entrySet()) {
    		if(!entry.getKey().equals("staffID") && !entry.getKey().equals("typeCode") && !entry.getKey().contains("rentArea") && !entry.getKey().contains("rentPrice")) {
    			String value = entry.getKey().toString();
    			if(NumberUtil.isNumber(value)) {
    				where.append(" AND b." + entry.getKey() + "=" + value);
    			}
    			else {
    				where.append(" AND b." + entry.getKey() +" like '%" + value +"%' ");
    			}
    		}
    	}
    }
    public static void specialQuery(Map<String,String> params,List<String> typeCode,StringBuilder where) {
    	String staffID =  params.get("staffID");
    	if(!StringUtil.isEmptyString(staffID)) {
    		where.append(" AND ab.buildingid = " + staffID );
    	}
    	if(!StringUtil.isEmptyString(staffID)) {
    		where.append(" AND ab.buildingid = " + staffID );
    	}
    	String rentAreaMin = params.get("rentAreaMin");
    	String rentAreaMax = params.get("rentAreaMax");
    	if(!StringUtil.isEmptyString(rentAreaMin) ) {
    		where.append(" AND r.value >= " + rentAreaMin );
    	}
    	if(!StringUtil.isEmptyString(rentAreaMax) ) {
    		where.append(" AND r.value <= " + rentAreaMax );
    	}
    	String rentPriceMin = params.get("rentPriceMin");
    	String rentPriceMax = params.get("rentPriceMax");
    	if(!StringUtil.isEmptyString(rentPriceMin) ) {
    		where.append(" AND b.rentprice >= " + rentPriceMin );
    	}
    	if(!StringUtil.isEmptyString(rentPriceMax) ) {
    		where.append(" AND b.rentprice <= " + rentPriceMax );
    	}
    	if(typeCode!=null&&!typeCode.isEmpty()) {
    		List<String> result = new ArrayList<>();
    		for(String item : typeCode) {
    			result.add("'"+item+"'");
    		}
    		where.append(" AND rt.code IN (" + String.join(",", result)+") " );
    	}
    }
	@Override
	public List<BuildingEntity> findAll(Map<String,String> params,List<String> typeCode){
		StringBuilder sqlQuery = new StringBuilder("select b.id, b.name, b.districtid, b.street, b.ward, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphonenumber, b.servicefee,b.brokeragefee from building b ") ;
		joinTable(params,typeCode,sqlQuery);
		StringBuilder where = new StringBuilder("Where 1=1 ");
		normalQuery(params,typeCode,where);
		specialQuery(params, typeCode, where);
		sqlQuery.append(where);
		List<BuildingEntity> result = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery.toString());)
		{
			while(rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setDistrictId(rs.getInt("districtid"));
				building.setFloorArea(rs.getInt("floorarea"));
				building.setNameManager(rs.getString("managername"));
				building.setPhoneManager(rs.getString("managerphonenumber"));
				building.setRentPrice(rs.getInt("rentprice"));
				building.setEmptyArea(0);
				building.setBrokerageFee(1);
				building.setId(rs.getInt("id"));
				building.setServiceFee(0);
				
				result.add(building);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
