package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@GetMapping("/")
	public String hi() {
		return "Welcome to S1P";
	}

}
