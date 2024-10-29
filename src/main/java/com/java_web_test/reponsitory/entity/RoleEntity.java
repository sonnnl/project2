package com.java_web_test.reponsitory.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "role")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name",nullable = false)
	private String name;
	@Column(name ="code")
	private String code;
	@ManyToMany(mappedBy = "listRoles",fetch = FetchType.LAZY)
	private List<UserEntity> listUsers = new ArrayList<>();
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<UserEntity> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<UserEntity> listUsers) {
		this.listUsers = listUsers;
	}
	
}
