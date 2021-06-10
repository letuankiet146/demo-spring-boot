package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_linked")
public class RoleLinked {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_linked_id")
	private Integer id;
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name="account_id")
	private Integer accountId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id", insertable = false, updatable = false)
	private Account account;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id", insertable = false, updatable = false)
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
