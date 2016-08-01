package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties(ConferenceProperties.class)
public class ConferenceRestController {
	
	@Autowired
	private ConferenceProperties properties;

	@GetMapping("/conference")
	public ConferenceProperties properties() {
		return this.properties;
	}
	
}
