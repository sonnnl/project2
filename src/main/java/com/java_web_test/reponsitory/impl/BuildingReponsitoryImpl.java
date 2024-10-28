package com.java_web_test.reponsitory.impl;

import java.lang.reflect.Field;
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

import com.java_web_test.builder.BuildingSearchBuilder;
import com.java_web_test.model.BuildingDTO;
import com.java_web_test.reponsitory.BuildingReponsitory;
import com.java_web_test.reponsitory.entity.BuildingEntity;
import com.java_web_test.utils.ConnectionUtil;
import com.java_web_test.utils.NumberUtil;
import com.java_web_test.utils.StringUtil;
@Repository
public class BuildingReponsitoryImpl implements BuildingReponsitory{
    public static void joinTable(BuildingSearchBuilder bsb,StringBuilder sql) {
    	Integer staffId = bsb.getStaffId();
    	if(staffId!=null) {
    		sql.append(" Inner join assignmentbuilding ab on ab.buildingid = b.id ");
    	}
    	if(bsb.getTypeCode()!=null&&!bsb.getTypeCode().isEmpty()) {
    		sql.append(" Inner join buildingrenttype brt on brt.buildingid = b.id join renttype rt on rt.id = brt.renttypeid ");
    	}
    	Integer rentAreaMin = bsb.getRentAreaMin();
    	Integer rentAreaMax = bsb.getRentAreaMax();
    	if(rentAreaMin!=null || rentAreaMax!=null ) {
    		sql.append(" Inner join rentarea r on r.buildingid = b.id");
    	}
    }
    
    public static void normalQuery(BuildingSearchBuilder bsb,StringBuilder where) {
    	
    	try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field item: fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
	    		if(!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.contains("rentArea") && !fieldName.contains("rentPrice")) {
	    			
	    			Object fieldValue = item.get(bsb);
	    			String value = fieldValue != null ? fieldValue.toString() : "";
	    			if(NumberUtil.isNumber(value)) {
	    				where.append(" AND b." + fieldName + "=" + value);
	    			}
	    			else {
	    				where.append(" AND b." + fieldName +" like '%" + value +"%' ");
	    			}
	    		}
			}
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void specialQuery(BuildingSearchBuilder bsb,StringBuilder where) {
    	Integer staffId = bsb.getStaffId();
    	if(staffId!=null) {
    		where.append(" AND ab.staffid = " + staffId );
    	}
    	Integer rentAreaMin = bsb.getRentAreaMin();
    	Integer rentAreaMax = bsb.getRentAreaMax();
    	if(rentAreaMin!=null ) {
    		where.append(" AND r.value >= " + rentAreaMin );
    	}
    	if(rentAreaMax!=null ) {
    		where.append(" AND r.value <= " + rentAreaMax );
    	}
    	Integer rentPriceMin = bsb.getRentPriceMin();
    	Integer rentPriceMax = bsb.getRentPriceMax();
    	if(rentPriceMin!=null ) {
    		where.append(" AND b.rentprice >= " + rentPriceMin );
    		System.out.println(rentPriceMin);
    	}
    	if(rentPriceMax!=null ) {
    		where.append(" AND b.rentprice <= " + rentPriceMax );
    	}
    	if(bsb.getTypeCode()!=null&&!bsb.getTypeCode().isEmpty()) {
    		List<String> result = new ArrayList<>();
    		for(String item : bsb.getTypeCode()) {
    			result.add("'"+item+"'");
    		}
    		where.append(" AND rt.code IN (" + String.join(",", result)+") " );
    	}
    }
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder bsb){
		StringBuilder sqlQuery = new StringBuilder("select b.id, b.name, b.districtid, b.street, b.ward, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphonenumber, b.servicefee,b.brokeragefee from building b ") ;
		joinTable(bsb,sqlQuery);
		StringBuilder where = new StringBuilder(" Where 1=1 ");
		normalQuery(bsb,where);
		specialQuery(bsb, where);
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
