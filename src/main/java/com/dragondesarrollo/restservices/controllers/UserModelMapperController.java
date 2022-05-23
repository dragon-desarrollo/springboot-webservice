package com.dragondesarrollo.restservices.controllers;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragondesarrollo.restservices.dtos.UserMmDto;
import com.dragondesarrollo.restservices.entities.User;
import com.dragondesarrollo.restservices.exceptions.UserNotFoundException;
import com.dragondesarrollo.restservices.services.UserService;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/{id}")
	public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		
		
		User user = userService.getUserById(id);
		
		UserMmDto userMmDto = modelMapper.map(user, UserMmDto.class);
		
		return userMmDto;
		
	}

}
