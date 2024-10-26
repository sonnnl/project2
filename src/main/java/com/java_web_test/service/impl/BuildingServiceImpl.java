package com.java_web_test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java_web_test.model.BuildingDTO;
import com.java_web_test.reponsitory.BuildingReponsitory;
import com.java_web_test.reponsitory.entity.BuildingEntity;
import com.java_web_test.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingReponsitory buildingReponsitory;
	@Override
	public List<BuildingDTO> findAll(String name, Long district) {
		List<BuildingEntity> buildingEntities = buildingReponsitory.findAll(name,district);
		List<BuildingDTO> result = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setNumberOfBasement(item.getNumberOfBasement());
			building.setAddress(item.getStreet() + "," + item.getWard());
			result.add(building);
		}
		return result;
	}
	
}
