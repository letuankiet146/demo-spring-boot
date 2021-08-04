package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CommentDTO;

public interface ICommentService {
	List<CommentDTO> findCommentByAccountId(Integer accounId);
	void deleteAllComments();
}
