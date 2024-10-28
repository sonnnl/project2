package com.java_web_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_web_test.builder.BuildingSearchBuilder;
import com.java_web_test.converter.BuildingDTOConverter;
import com.java_web_test.converter.BuildingSearchBuilderConverter;
import com.java_web_test.model.BuildingDTO;
import com.java_web_test.reponsitory.BuildingReponsitory;
import com.java_web_test.reponsitory.DistrictReponsitory;
import com.java_web_test.reponsitory.RentAreaReponsitory;
import com.java_web_test.reponsitory.entity.BuildingEntity;
import com.java_web_test.reponsitory.entity.DistrictEntity;
import com.java_web_test.reponsitory.entity.RentAreaEntity;
import com.java_web_test.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingReponsitory buildingReponsitory;
	@Autowired
	private BuildingDTOConverter buildingDTOConverter;
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
	@Override
	public List<BuildingDTO> findAll(Map<String,Object> params,List<String> typeCode) {
		BuildingSearchBuilder bsb = buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeCode);
		List<BuildingEntity> buildingEntities = buildingReponsitory.findAll(bsb);
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = buildingDTOConverter.toBuildingDTO(item);
			result.add(building);
		}
		return result;
	}
	
}
