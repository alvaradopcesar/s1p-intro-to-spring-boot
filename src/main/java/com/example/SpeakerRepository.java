package com.example;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
	
	Collection<Speaker> findByName(String speakerName);

}
