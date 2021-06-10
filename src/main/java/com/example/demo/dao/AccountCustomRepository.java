package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.RoleLinked;

@Repository
public class AccountCustomRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private AccountRepository accountRepo;
	
	public List<Account> findFans(List<String> descrKeyWord) {
		String query = "SELECT acc FROM Account acc JOIN acc.comments com WHERE ";
		StringBuilder sb = new StringBuilder();
		for (String keyword : descrKeyWord) {
			String condition = String.format("com.content LIKE '%%%s%%'", keyword);
			sb.append(condition);
			sb.append(" OR ");
		}
		sb.delete(sb.length()-3, sb.length());
		query = query.concat(sb.toString());
		List<Account> accounts = entityManager.createQuery(query).getResultList();
		return accounts;
	}
	
	public List<RoleLinked> findRoleLinked(Integer accountId){
		if(!accountRepo.existsById(accountId)) {
			return Collections.emptyList();
		}
		List<RoleLinked> roleLinkeds = new ArrayList<RoleLinked>();
		String query = "SELECT roleLinkeds FROM Role role WHERE role.account_id = :accountId";
		roleLinkeds = entityManager.createQuery(query).setParameter("accountId", accountId).getResultList();
		return roleLinkeds;
	}
}
