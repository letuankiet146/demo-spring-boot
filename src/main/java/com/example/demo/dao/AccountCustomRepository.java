package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;

@Repository
public class AccountCustomRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
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
		System.out.println(query);
		List<Account> accounts = entityManager.createQuery(query).getResultList();
		return accounts;
	}
}
