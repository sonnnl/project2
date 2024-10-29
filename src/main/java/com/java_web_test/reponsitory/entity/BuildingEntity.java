package com.java_web_test.reponsitory.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="street")
	private String street;
	@Column(name="ward")
	private String ward;
	@Column(name="managername")
	private String nameManager;
	@Column(name="managerphonenumber")
	private String phoneManager;
	@Column(name="floorarea")
	private Integer floorArea;
	@Column(name="rentprice")
	private Integer rentPrice;
	@Column(name="servicefee")
	private Integer serviceFee;
	@Column(name="brokeragefee")
	private Integer brokerageFee;
	
	@ManyToOne
	@JoinColumn(name="districtid")
	private DistrictEntity district;

	@OneToMany(mappedBy = "building",fetch = FetchType.LAZY)
	private List<RentAreaEntity> listRentArea = new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getNameManager() {
		return nameManager;
	}
	public void setNameManager(String nameManager) {
		this.nameManager = nameManager;
	}
	public String getPhoneManager() {
		return phoneManager;
	}
	public void setPhoneManager(String phoneManager) {
		this.phoneManager = phoneManager;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Integer getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Integer getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(Integer brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public List<RentAreaEntity> getListRentArea() {
		return listRentArea;
	}
	public void setListRentArea(List<RentAreaEntity> listRentArea) {
		this.listRentArea = listRentArea;
	}
}
