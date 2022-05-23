package com.dragondesarrollo.restservices.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dragondesarrollo.restservices.entities.User;
import com.dragondesarrollo.restservices.exceptions.UserNotFoundException;
import com.dragondesarrollo.restservices.services.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping( value = "/jacksonfilter/users")
@Validated
public class UserMappingJacksonController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public MappingJacksonValue getUserById(@PathVariable("id") @Min(1) Long id) {
		
		try {
			User user = userService.getUserById(id);
			Set<String> fields = new HashSet<>();
			fields.add("id");
			fields.add("username");
			fields.add("ssn");
			fields.add("orders");
			
			FilterProvider filterProvider = new SimpleFilterProvider()
					.addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
			MappingJacksonValue mapper = new MappingJacksonValue(user);
			
			mapper.setFilters(filterProvider);
			
			return mapper;
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	
	
	// getUserByUserId - fields with @RequestParam
	@GetMapping("/params/{id}")
	public MappingJacksonValue getUserById(@PathVariable("id") @Min(1) Long id,
			@RequestParam("fields") Set<String> fields) {
		
		try {
			User user = userService.getUserById(id);
			
			FilterProvider filterProvider = new SimpleFilterProvider()
					.addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
			MappingJacksonValue mapper = new MappingJacksonValue(user);
			
			mapper.setFilters(filterProvider);
			
			return mapper;
		} catch(UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

}
