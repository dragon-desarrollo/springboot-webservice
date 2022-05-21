package com.dragondesarrollo.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragondesarrollo.restservices.entities.Order;
import com.dragondesarrollo.restservices.entities.User;
import com.dragondesarrollo.restservices.exceptions.UserNotFoundException;
import com.dragondesarrollo.restservices.repositories.OrderRepository;
import com.dragondesarrollo.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrders(@PathVariable("userId") Long userId) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		return userOptional.get().getOrders();
	}
	
	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		
		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
	}
	
	@GetMapping("/{userId}/orders/{orderId}")
	public Order findOrderById(@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		
		User user = userOptional.get();
		
		for(Order order : user.getOrders()) {
			if(order.getOrderid() == orderId) {
				return order;
			}
		}
		
		return null;
	}

}
