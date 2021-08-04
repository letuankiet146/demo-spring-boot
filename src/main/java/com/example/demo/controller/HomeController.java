package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.AccountDTO;
import com.example.demo.security.model.SecurityAccount;
import com.example.demo.service.ICommentService;
import com.example.demo.view.model.LoginModel;

@Controller
public class HomeController {	
	@Autowired
	private ICommentService commentServ;
	
	@GetMapping("/index")
	public String index(Model model, Principal principal) {
		AccountDTO accountDTO = new AccountDTO();
		if (principal instanceof OAuth2AuthenticationToken) {
			OAuth2AuthenticationToken new_name = (OAuth2AuthenticationToken) principal;
			OAuth2User user = new_name.getPrincipal();
			accountDTO.setUser(user.getAttribute("name"));
			
		}else if (principal instanceof UsernamePasswordAuthenticationToken) {
			UsernamePasswordAuthenticationToken new_name = (UsernamePasswordAuthenticationToken) principal;
			SecurityAccount account = (SecurityAccount)new_name.getPrincipal();
			accountDTO = account.getAccount();
		}
		
		String name = accountDTO.getUser();
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/login")
	public String login (Model model,  Principal principal) {
		if (principal == null) {
			return "login";
		}
		SecurityAccount account = (SecurityAccount) ((UsernamePasswordAuthenticationToken)principal).getPrincipal();
		if(account.isAccountNonExpired()) {
			return String.format("redirect:/index?name=%s", account.getUsername());
		}
		model.addAttribute("loginForm",new LoginModel());
		return "login";
	}
	
	@GetMapping("/vip")
	public String vip() {
		return "admin-only";
	}
	
	@GetMapping("/terminate")
	public String terminate(HttpServletRequest req) {
		commentServ.deleteAllComments();
		return "terminate";
	}
}
