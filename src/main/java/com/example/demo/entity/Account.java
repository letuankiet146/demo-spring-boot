package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Integer id;
	
	@Column(name = "account_user")
	private String user;
	
	@Column(name = "account_password")
	private String password;
	
	@Column(name = "account_block")
	private boolean isBlocked;
	
	@Column(name = "account_startdate")
	private Date startDate;
	
	@Column(name = "account_enddate")
	private Date endDate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "account_id")
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="role_linked"
				,joinColumns = @JoinColumn(name="account_id",referencedColumnName = "account_id")
				,inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "role_id"))
	private List<Role> roles;

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
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean compare(Account account) {
		return  this.id.equals(account.getId())
				&& this.user.equals(account.getUser())
				&& this.password.equals(account.getPassword())
				&& this.startDate.equals(account.getStartDate())
				&& this.endDate.equals(account.getEndDate());
	}

}
