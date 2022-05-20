package com.dragondesarrollo.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dragondesarrollo.restservices.entities.User;
import com.dragondesarrollo.restservices.repositories.UserRepository;

//
@SpringBootApplication
public class SpringbootDragondesarrolloApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDragondesarrolloApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("donDeivid", "David", "Vences", "dvences@gmail.com", "admin", "ssn00001");
		User user2 = new User("fabi", "Fabiola", "Riquelme", "f.riquelme@gmail.com", "admin", "ssn00002");
		User user3 = new User("gusgus", "Gustavo", "Gusmán", "gusgus@gmail.com", "admin", "ssn00003");
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
	}

}
