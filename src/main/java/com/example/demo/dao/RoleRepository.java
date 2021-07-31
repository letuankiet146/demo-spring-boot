package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	Role findByLevel(String level);
}
