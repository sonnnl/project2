package com.java_web_test.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.java_web_test.builder.BuildingSearchBuilder;
import com.java_web_test.utils.MapUtil;
@Component
public class BuildingSearchBuilderConverter {

	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String,Object> params, List<String> typeCode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
																				.setName(MapUtil.getObject(params, "name", String.class))
																				.setFloorArea(MapUtil.getObject(params, "floorArea", Integer.class))
																				.setDistrictId(MapUtil.getObject(params, "districtId", Integer.class))
																				.setNumberOfBasement(MapUtil.getObject(params, "numberOfBasement", Integer.class))
																				.setManagerName(MapUtil.getObject(params, "nameManager", String.class))
																				.setManagerPhoneNumber(MapUtil.getObject(params, "phoneManager", String.class))
																				.setRentAreaMax(MapUtil.getObject(params, "rentAreaMax", Integer.class))
																				.setRentAreaMin(MapUtil.getObject(params, "rentAreaMin", Integer.class))
																				.setRentPriceMin(MapUtil.getObject(params, "rentPriceMin", Integer.class))
																				.setRentPriceMax(MapUtil.getObject(params, "rentPriceMax", Integer.class))
																				.setStaffId(MapUtil.getObject(params, "staffId", Integer.class))
																				.setStreet(MapUtil.getObject(params, "street", String.class))
																				.setWard(MapUtil.getObject(params, "ward", String.class))
																				.setTypeCode(typeCode)
																				.build()
																				;
		return buildingSearchBuilder;
	}

}
