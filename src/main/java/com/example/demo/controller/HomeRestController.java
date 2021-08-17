package com.example.demo.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.CommentDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Comment;
import com.example.demo.security.model.SecurityAccount;
import com.example.demo.service.IAccountService;
import com.example.demo.service.ICommentService;
import com.example.demo.view.model.FindAccountReq;

@RestController
public class HomeRestController {
	@Autowired
	ICommentService commentServ;
	
	@Autowired
	IAccountService accountServ;
	
	@GetMapping("/hello")
	public String hello( Principal account) {
		String accountUser = account.getName();
		AccountDTO accountDTO = accountServ.findByUser(accountUser);
		if (accountDTO == null) {
			return String.format("Opps! you have not registered yet");
		} 
		List<CommentDTO> commentsDTO =  commentServ.findCommentByAccountId(accountDTO.getId());
		StringBuilder sb = new StringBuilder();
		for (CommentDTO commentDTO : commentsDTO) {
			sb.append(commentDTO.getContent());
			sb.append("\n");
		}
		return String.format("Your comment \n %s!", sb.toString());
	}
	
	@GetMapping("/fans")
	public String fans (@RequestParam (value = "keyword",defaultValue = "good,greate") String descrKeyword) {
		List<String> descrKeyWords = Arrays.asList(descrKeyword.split(","));
		List<AccountDTO> accountDTOs = accountServ.findFans(descrKeyWords);
		
		StringBuilder sb = new StringBuilder();
		for (AccountDTO accountDTO : accountDTOs) {
			sb.append(accountDTO.getUser());
			sb.append("\n");
		}
		return String.format("Your fans: %s ", sb.toString());
	}
	
	@PostMapping("/account")
	@PostAuthorize ("returnObject.user == authentication.name")
	public AccountDTO getAccountInfo(@RequestBody FindAccountReq body, Principal principal) {
		
		String type = body.getType();
		String value = body.getValue();
		switch (type) {
		case "id" :
			return accountServ.findById(Integer.valueOf(value));
		case "name":
			return accountServ.findByUser(value);
		default :
			return new AccountDTO();
		}
	}
}
