package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{
	public List<Comment> findByAccountId(Integer accounId);
	
}
