package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountCustomRepository;
import com.example.demo.dao.AccountRepository;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.RoleDTO;
import com.example.demo.dto.RoleLinkedDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import com.example.demo.entity.RoleLinked;

@Service
public class AccountService implements IAccountService {
	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	AccountCustomRepository accountCustomRepo;
	
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
	
	@Override
	public List<RoleLinkedDTO> findRoleLinked(Integer accountId) {
		List<RoleLinked> roleLinkeds = accountCustomRepo.findRoleLinked(accountId);
		List<RoleLinkedDTO> roleLinkedDTOs = new ArrayList<RoleLinkedDTO>();
		for (RoleLinked roleLinked : roleLinkeds) {
			RoleLinkedDTO roleLinkedDTO = new RoleLinkedDTO();
			roleLinkedDTO.setId(roleLinked.getId());
			roleLinkedDTO.setRole(migrateToRoleDTO(roleLinked.getRole()));
		}
		return roleLinkedDTOs;
	}
	
	private AccountDTO migrateToAccountDTO (Account account) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(account.getId());
		accountDTO.setUser(account.getUser());
		accountDTO.setPassword(account.getPassword());
		accountDTO.setBlocked(account.isBlocked());
		accountDTO.setStartDate(account.getStartDate());
		accountDTO.setEndDate(account.getEndDate());		
		accountDTO.setRoleLinkedDTOs(migrateToRoleLinkedList(account.getRoleLinked()));
		return accountDTO;
	}
	
	private List<RoleLinkedDTO> migrateToRoleLinkedList(List<RoleLinked> roleLinkeds) {
		List<RoleLinkedDTO> roleLinkedDTOs = new ArrayList<RoleLinkedDTO>();
		for (RoleLinked roleLinked : roleLinkeds) {
			roleLinkedDTOs.add(migrateToRoleLinkedDTO(roleLinked));
		}
		return roleLinkedDTOs;
	}

	private RoleLinkedDTO migrateToRoleLinkedDTO(RoleLinked roleLinked) {
		RoleLinkedDTO roleLinkedDTO = new RoleLinkedDTO();
		roleLinkedDTO.setId(roleLinked.getId());
		roleLinkedDTO.setRole(migrateToRoleDTO(roleLinked.getRole()));
		return roleLinkedDTO;
	}

	private RoleDTO migrateToRoleDTO (Role role) {
		RoleDTO roleDto = new RoleDTO();
		roleDto.setId(role.getId());
		roleDto.setLevel(role.getLevel());
		roleDto.setDescr(role.getDescr());
		return roleDto;
	}

}
