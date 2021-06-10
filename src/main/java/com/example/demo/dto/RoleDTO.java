package com.example.demo.dto;

import org.springframework.security.core.GrantedAuthority;

public class RoleDTO implements GrantedAuthority{
	private Integer id;
	private String level;
	private String descr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	@Override
	public String getAuthority() {
		return this.level;
	}
	
}
