package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "demo.config")
public class PropertyConfig {
	private String defaultUser;
	private String defaultPassword;
	private String defaultRole;
	public String getDefaultUser() {
		return defaultUser;
	}
	public void setDefaultUser(String defaultUser) {
		this.defaultUser = defaultUser;
	}
	public String getDefaultPassword() {
		return defaultPassword;
	}
	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}
	public String getDefaultRole() {
		return defaultRole;
	}
	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole;
	} 	
}
