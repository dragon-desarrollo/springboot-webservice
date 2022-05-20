package com.dragondesarrollo.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragondesarrollo.restservices.entities.User;
import com.dragondesarrollo.restservices.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// getAllUsers
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	// createUser
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUserById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(userOptional.isPresent()) {
			return userOptional.get();
		}
		
		return null;
	}
	
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
}
