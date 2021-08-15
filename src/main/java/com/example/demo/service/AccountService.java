package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountCustomRepository;
import com.example.demo.dao.AccountRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Role;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private AccountCustomRepository accountCustomRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public AccountDTO findByUser(String user) {
		List<Account> accounts = accountRepo.findByUser(user);
		if (accounts.isEmpty()) {
			return null;
		}
		Account account = accounts.get(0);
		AccountDTO accountDTO = migrateToAccountDTO(account);
		return accountDTO;
	}

	@Override
	public Integer insert(Account account) {
		account = accountRepo.save(account);
		return account.getId();
	}

	@Override
	public void delete(Integer accountId) {
		accountRepo.deleteById(accountId);
	}

	@Override
	public List<AccountDTO> findFans(List<String> descrKeyWord) {
		List<Account> accounts = accountCustomRepo.findFans(descrKeyWord);
		List<AccountDTO> accountDTOs = new ArrayList<AccountDTO>();
		for (Account acc : accounts) {
			accountDTOs.add(migrateToAccountDTO(acc));
		}
		return accountDTOs;
	}
	
	private AccountDTO migrateToAccountDTO (Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(account.getId());
		accountDTO.setUser(account.getUser());
		accountDTO.setPassword(account.getPassword());
		accountDTO.setBlocked(account.isBlocked());
		accountDTO.setStartDate(account.getStartDate());
		accountDTO.setEndDate(account.getEndDate());	
		accountDTO.setRoles(account.getRoles());
		return accountDTO;
	}
	
	@Override
	public Role findRoleByLevel(String level) {
		return roleRepo.findByLevel(level);
	}

	@Override
	public AccountDTO findById(Integer id) {
		return migrateToAccountDTO(accountRepo.findById(id).get());
	}

}
