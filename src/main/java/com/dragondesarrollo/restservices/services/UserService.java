package com.dragondesarrollo.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dragondesarrollo.restservices.entities.User;
import com.dragondesarrollo.restservices.exceptions.UserNotFoundException;
import com.dragondesarrollo.restservices.exceptions.UsernameExistsException;
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
	public User createUser(User user) throws UsernameExistsException {
		
		User existingUser = userRepository.findUserByUsername(user.getUsername());
		
		if(existingUser != null) {
			throw new UsernameExistsException("Username already exists in repository.");
		}
		
		return userRepository.save(user);
	}
	
	public User getUserById(Long id) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found in user repository.");
		} else {
			return userOptional.get();
		}
		
	}
	
	public User updateUserById(Long id, User user) throws UserNotFoundException {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found in user repository, provide the correct user id.");
		}
		
		//user.setId(id);
		return userRepository.save(user);
	}
	
	public void deleteUserById(Long id)  {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in user repository.");
		}
		
		userRepository.deleteById(id);
		
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
}
