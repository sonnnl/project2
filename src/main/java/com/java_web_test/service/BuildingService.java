package com.java_web_test.service;

import java.util.List;

import com.java_web_test.model.BuildingDTO;

public interface BuildingService {
	public List<BuildingDTO> findAll(String name, Long district);
}
