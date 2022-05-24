package com.dragondesarrollo.restservices.controllers;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragondesarrollo.restservices.dto.UserDtoV1;
import com.dragondesarrollo.restservices.dto.UserDtoV2;
import com.dragondesarrollo.restservices.entities.User;
import com.dragondesarrollo.restservices.exceptions.UserNotFoundException;
import com.dragondesarrollo.restservices.services.UserService;

@RestController
@RequestMapping("/versioning/mediatype/users")
public class UserMediaTypeVersioningController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/{id}", produces = "application/vnd.dragondesarrollo.app-v1+json")
	public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		
		User user = userService.getUserById(id);
		
		UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);
		
		return userDtoV1;
	}
	
	@GetMapping(value = "/{id}", produces = "application/vnd.dragondesarrollo.app-v2+json")
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		
		User user = userService.getUserById(id);
		
		UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);
		
		return userDtoV2;
	}

}
