package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.config.PropertyConfig;
import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import com.example.demo.entity.UserRole;
import com.example.demo.service.IAccountService;

@Configuration
public class PostProcess {
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private PropertyConfig conf;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public PostProcess intitDefaultAccount() {
		Account account = new Account();
		account.setUser(conf.getDefaultUser());
		account.setPassword(encoder.encode(conf.getDefaultPassword()));;
		account.setStartDate(new Date());
		Role role = accountService.findRoleByLevel(UserRole.valueOf(conf.getDefaultRole()).getLevel());
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		account.setRoles(roles);
		accountService.insert(account);
		return this;
	}
	
	public PostProcess validateSchema() throws Exception {
		Persistence.createEntityManagerFactory( "test_unit" );
		return this;
	}
}
