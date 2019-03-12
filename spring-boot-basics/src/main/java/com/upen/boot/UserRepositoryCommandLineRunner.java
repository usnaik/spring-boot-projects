package com.upen.boot;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.upen.boot.entity.User;
import com.upen.boot.entity.Service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			 LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {

		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("A new User has been created : " + user);
		
		Optional<User> userIdone = userRepository.findById(1L);
		log.info("User retrieved : " + userIdone);
		
		Long count = userRepository.count();
		log.info("User Count : " + count);
		
		List<User> users = userRepository.findAll();
		log.info("All users retrieved : " + users);
	}
}
