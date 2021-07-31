package com.example.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDTO;
import com.example.demo.security.model.SecurityAccount;
import com.example.demo.service.AccountService;

@Service
public class SecurityService implements UserDetailsService {
	@Autowired
	private AccountService accountServ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountDTO accountDTO = accountServ.findByUser(username);
		if (accountDTO == null) {
            throw new UsernameNotFoundException(username);
        }
		return new SecurityAccount(accountDTO);
	}

}
