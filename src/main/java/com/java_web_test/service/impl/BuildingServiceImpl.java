package com.java_web_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_web_test.converter.BuildingDTOConverter;
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
	@Override
	public List<BuildingDTO> findAll(Map<String,String> params,List<String> typeCode) {
		List<BuildingEntity> buildingEntities = buildingReponsitory.findAll(params, typeCode);
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = buildingDTOConverter.toBuildingDTO(item);
			result.add(building);
		}
		return result;
	}
	
}
