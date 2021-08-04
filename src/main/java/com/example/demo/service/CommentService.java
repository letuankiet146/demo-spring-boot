package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommentRepository;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.CommentDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Comment;

@Service
public class CommentService implements ICommentService {
	@Autowired
	CommentRepository commentRepo;
	
	@Override
	public List<CommentDTO> findCommentByAccountId (Integer accounId) {
		List<Comment> comments = commentRepo.findByAccountId(accounId);
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for (Comment comment : comments) {
			Account account = comment.getAccount();
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setId(account.getId());
			accountDTO.setUser(account.getUser());
			accountDTO.setPassword(account.getPassword());
			accountDTO.setStartDate(account.getStartDate());
			accountDTO.setEndDate(account.getEndDate());
			
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setId(comment.getId());
			commentDTO.setAccount(accountDTO);
			commentDTO.setAccountId(comment.getAccountId());
			commentDTO.setContent(comment.getContent());
			
			commentsDTO.add(commentDTO);
		}
		return commentsDTO;
	}

	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAllComments() {
		System.out.println("You have deleted all comments");
	}
}
