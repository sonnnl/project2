package com.java_web_test.reponsitory.entity;

public class BuildingEntity {
	private Integer id;
	private String name;
	private Integer districtId;
	private String street;
	private String ward;
	private String nameManager;
	private String phoneManager;
	private Integer floorArea;
	private Integer rentPrice;
	private Integer serviceFee;
	private Integer brokerageFee;
	private Integer emptyArea;
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
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtID) {
		this.districtId = districtID;
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
	public Integer getEmptyArea() {
		return emptyArea;
	}
	public void setEmptyArea(Integer emptyArea) {
		this.emptyArea = emptyArea;
	}
	
	
}
