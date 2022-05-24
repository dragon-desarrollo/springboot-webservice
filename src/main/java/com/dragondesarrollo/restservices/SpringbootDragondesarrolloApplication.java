package com.dragondesarrollo.restservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.dragondesarrollo.restservices.entities.Order;
import com.dragondesarrollo.restservices.entities.User;
import com.dragondesarrollo.restservices.repositories.OrderRepository;
import com.dragondesarrollo.restservices.repositories.UserRepository;

//
@SpringBootApplication
public class SpringbootDragondesarrolloApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDragondesarrolloApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("donDeivid", "David", "Vences", "dvences@gmail.com", "admin", "ssn00001", "Campeche");
		User user2 = new User("fabi", "Fabiola", "Riquelme", "f.riquelme@gmail.com", "admin", "ssn00002", "Veracruz");
		User user3 = new User("gusgus", "Gustavo", "Gusmán", "gusgus@gmail.com", "admin", "ssn00003", "Michoacan");
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		
		Order order1 = new Order("Order11", user1);
		orderRepository.save(order1);
		Order order2 = new Order("Order12", user1);
		orderRepository.save(order2);
		Order order3 = new Order("Order13", user1);
		orderRepository.save(order3);
		
		Order order4 = new Order("Order21", user2);
		orderRepository.save(order4);
		Order order5 = new Order("Order22", user2);
		orderRepository.save(order5);
		
		Order order6 = new Order("Order31", user3);
		orderRepository.save(order6);
		
		List<Order> ordersUser1 = new ArrayList<>();
		ordersUser1.add(order1);
		ordersUser1.add(order2);
		ordersUser1.add(order3);
		//user1.setOrders(ordersUser1);
		
		List<Order> ordersUser2 = new ArrayList<>();
		ordersUser2.add(order4);
		ordersUser2.add(order5);
		//user2.setOrders(ordersUser2);
		
		List<Order> ordersUser3 = new ArrayList<>();
		ordersUser3.add(order6);
		//user3.setOrders(ordersUser3);
		
//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

}
