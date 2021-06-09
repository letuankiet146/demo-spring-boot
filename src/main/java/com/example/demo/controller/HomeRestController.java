package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.CommentDTO;
import com.example.demo.service.IAccountService;
import com.example.demo.service.ICommentService;

@RestController
public class HomeRestController {
	@Autowired
	ICommentService commentServ;
	
	@Autowired
	IAccountService accountServ;
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String accountUser) {
		
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
}
