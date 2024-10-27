package com.java_web_test.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java_web_test.customexception.RequiredFieldException;
import com.java_web_test.model.BuildingDTO;
import com.java_web_test.model.UserDTO;
import com.java_web_test.service.BuildingService;
import com.java_web_test.service.impl.BuildingServiceImpl;

@RestController
public class BuildingAPI {	
	@Autowired
	private BuildingService buildingService;
	@GetMapping("/buildings")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String,String> params,
			@RequestParam(name="typeCode",required = false) List<String> typeCode
			){
			List<BuildingDTO> result = buildingService.findAll(params,typeCode);
		return result;
	}
   @DeleteMapping("/users/{id}")
   public void deleteUser(@PathVariable Integer id) {
	   System.out.println("Deleted id: " + id );
   }	
   
   
   public void validate(UserDTO uDTO) throws RequiredFieldException {
	   if(uDTO.getName()==null||uDTO.getName()==""||uDTO.getAge()==null||uDTO.getAddress()==""||uDTO.getAddress()==null) {
		   throw new RequiredFieldException("DMM ko dc de trong");
	   }
   }
   
}
