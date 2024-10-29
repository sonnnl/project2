package com.java_web_test.reponsitory.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="district")
public class DistrictEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	@OneToMany(mappedBy="district",fetch = FetchType.LAZY)
	private List<BuildingEntity> listBuilding = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<BuildingEntity> getListBuilding() {
		return listBuilding;
	}

	public void setListBuilding(List<BuildingEntity> listBuilding) {
		this.listBuilding = listBuilding;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
