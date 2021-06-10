package com.example.demo.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.RoleLinkedDTO;

public class SecurityAccount implements UserDetails{
	private static final long serialVersionUID = 1L;
	private AccountDTO account ;
	
	public SecurityAccount(AccountDTO account) {
		this.account = account;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<RoleLinkedDTO> roleLinkedDTOs =  account.getRoleLinkedDTOs();
		List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
		for(RoleLinkedDTO roleLinkedDTO : roleLinkedDTOs) {
			roleDTOs.add(roleLinkedDTO.getRole());
		}
		return roleDTOs;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUser();
	}

	@Override
	public boolean isAccountNonExpired() {
		return account.getEndDate() == null || account.getEndDate().after(new Date());
	}

	@Override
	public boolean isAccountNonLocked() {
		return !account.isBlocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return account.getStartDate().before(new Date()) && (account.getEndDate() == null || account.getEndDate().after(new Date()));
	}

}
