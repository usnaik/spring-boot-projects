package com.upen.boot.security.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

	@GetMapping("/all")
	public String hello() {
		return "Hello User!";
	}
	
	@GetMapping("/secured/all")
	public String securedHello() {
		return "Hello Secured User!";		
	}
}
