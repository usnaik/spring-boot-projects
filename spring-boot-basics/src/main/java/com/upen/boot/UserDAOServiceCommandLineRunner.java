package com.upen.boot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.upen.boot.entity.User;
import com.upen.boot.entity.Service.UserDAOService;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			 LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDaoService;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jack", "Admin");
		Long userId = userDaoService.insert(user);
		log.info("A new User has been created : " + user);
		
	}
}
