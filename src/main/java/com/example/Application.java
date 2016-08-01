package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private SpeakerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner loadSpeakers() {
		return (args) -> {
			Stream<Speaker> speakers = Stream.of(new Speaker("Josh Long"), new Speaker("Stephane Nicoll"), new Speaker("Phil Webb"));
			speakers.forEach(repository::save);
			
			repository.findAll().forEach(System.out::println);
		};
	}
	
	@Bean
	public HealthIndicator springoneHealthIndicator() {
		return () -> Health.up().withDetail("message", "Up and running").build();
	}
	
}
