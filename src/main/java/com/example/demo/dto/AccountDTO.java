package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AccountDTO implements Serializable{
	private Integer id;
	private String user;
	private String password;
	private boolean isBlocked;
	private Date startDate;
	private Date endDate;
	private List<CommentDTO> comments;
	private List<RoleLinkedDTO> roleLinkedDTOs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}

	public List<RoleLinkedDTO> getRoleLinkedDTOs() {
		return roleLinkedDTOs;
	}

	public void setRoleLinkedDTOs(List<RoleLinkedDTO> roleLinkedDTOs) {
		this.roleLinkedDTOs = roleLinkedDTOs;
	}
	
}
