package com.example.demo.entity;

public enum UserRole {
	ADMIN("ROLE_ADMIN","Admin user"),
	MOD("ROLE_MOD","Mod user"),
	USER("ROLE_USER","Normal user");
	private String level;
	private String descr;
	private UserRole(String level, String descr) {
		this.level = level;
		this.descr = descr;
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
}
