package com.java_web_test.reponsitory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java_web_test.reponsitory.entity.BuildingEntity;

public interface BuildingReponsitory {
		List<BuildingEntity> findAll(Map<String,String> params,List<String> typeCode);
}

