package com.example.demo.dto;

import java.io.Serializable;

public class RoleLinkedDTO implements Serializable {
	private Integer id;
	private RoleDTO role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RoleDTO getRole() {
		return role;
	}
	public void setRole(RoleDTO role) {
		this.role = role;
	}
	
}
