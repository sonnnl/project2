package com.java_web_test.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java_web_test.model.BuildingDTO;
import com.java_web_test.reponsitory.DistrictReponsitory;
import com.java_web_test.reponsitory.RentAreaReponsitory;
import com.java_web_test.reponsitory.entity.BuildingEntity;
import com.java_web_test.reponsitory.entity.DistrictEntity;
import com.java_web_test.reponsitory.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DistrictReponsitory districtReponsitory;
	@Autowired
	private RentAreaReponsitory rentAreaReponsitory;
	@Autowired
	private ModelMapper modelMapper;
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		DistrictEntity de = districtReponsitory.findNameById(item.getDistrictId());
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
//		building.setName(item.getName());
//		building.setBrokerageFee(item.getBrokerageFee());
//		building.setEmtpyArea(item.getEmptyArea());
//		building.setNameManager(item.getNameManager());
//		building.setPhoneManager(item.getPhoneManager());
//		building.setRentPrice(item.getRentPrice());
//		building.setFloorArea(item.getFloorArea());
//		building.setServiceFee(item.getServiceFee());
		building.setAddress(item.getStreet() + ", " + item.getWard() + ", " + de.getName());
		List<RentAreaEntity> lRAE = rentAreaReponsitory.getRentAreaByBuildingId(item.getId());
		building.setRentArea(lRAE.stream()
                .map(RentAreaEntity::getValue) // Lấy giá trị từ RentAreaEntity
                .collect(Collectors.joining(","))); // Nối bằng dấu phẩy
		return building;
	}
}
