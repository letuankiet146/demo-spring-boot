package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	List<Account> findByUser(String user);
}
