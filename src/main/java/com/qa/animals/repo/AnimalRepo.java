package com.qa.animals.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.animals.domain.Animal;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {
	
	
}


