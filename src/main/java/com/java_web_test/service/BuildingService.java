package com.java_web_test.service;

import java.util.List;
import java.util.Map;

import com.java_web_test.builder.BuildingSearchBuilder;
import com.java_web_test.model.BuildingDTO;

public interface BuildingService {
	public List<BuildingDTO> findAll(Map<String,Object> params,List<String> typeCode);
}
