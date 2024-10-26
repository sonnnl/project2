package com.java_web_test.reponsitory;

import java.util.ArrayList;
import java.util.List;

import com.java_web_test.reponsitory.entity.BuildingEntity;

public interface BuildingReponsitory {
		List<BuildingEntity> findAll(String name, Long district);
}

