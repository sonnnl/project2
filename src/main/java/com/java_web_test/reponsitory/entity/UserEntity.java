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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username",unique = true,nullable = false)
	private String username;
	@Column(name ="password")
	private String password;
	@Column(name ="fullname")
	private String fullname;
	@Column(name ="phone")
	private String phone;
	@Column(name ="email")
	private String email;
	@Column(name="status")
	private Boolean status;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_role",
			joinColumns = @JoinColumn(name="userid",nullable = false),
			inverseJoinColumns = @JoinColumn(name="roleid",nullable = false))
	private List<RoleEntity> listRoles = new ArrayList<>();
	
	public List<RoleEntity> getListRoles() {
		return listRoles;
	}
	public void setListRoles(List<RoleEntity> listRoles) {
		this.listRoles = listRoles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
