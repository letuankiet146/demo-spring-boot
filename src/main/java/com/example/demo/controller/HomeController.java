package com.example.demo.controller;

import java.security.Principal;

import javax.annotation.Resource;
import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.AccountDTO;
import com.example.demo.security.model.SecurityAccount;
import com.example.demo.service.IAccountService;
import com.example.demo.view.model.LoginModel;

@Controller
public class HomeController {	
	@Autowired
	private IAccountService accountServ;
	
	@Resource
	Filter springSessionRepositoryFilter;
	
	@GetMapping("/index")
	public String index(@RequestParam (value = "name", required = false, defaultValue = "boos") String name, Model model, Principal principal) {
		SecurityAccount account = (SecurityAccount) ((UsernamePasswordAuthenticationToken)principal).getPrincipal();
		AccountDTO accountDTO = account.getAccount();
		name = accountDTO.getUser();
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/login")
	public String login (Model model) {
		model.addAttribute("loginForm",new LoginModel());
		return "login";
	}
	
	@GetMapping("/vip")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String vip() {
		return "admin-only";
	}
}
