package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Account;

public interface IAccountService {
	AccountDTO findByUser(String user);
	Integer insert(Account account);
	void delete(Integer accountId);
	List<AccountDTO> findFans(List<String> descrKeyWord);
}
