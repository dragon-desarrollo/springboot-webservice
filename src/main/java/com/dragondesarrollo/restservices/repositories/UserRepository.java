package com.dragondesarrollo.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dragondesarrollo.restservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findUserByUsername(String username);

}
