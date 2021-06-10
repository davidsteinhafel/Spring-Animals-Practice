package com.qa.animals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.animals.domain.Animal;
import com.qa.animals.repo.AnimalRepo;

@Service
public class AnimalService {
	
	private AnimalRepo repo;
	
	public AnimalService(AnimalRepo repo) {
		super();
		this.repo = repo;
	}
	
	//CREATE
	
	public Animal addAnimal(Animal animal) {
		return this.repo.save(animal);
	}
	
	//READ
	
	public List<Animal> getAllAnimals(){
		return this.repo.findAll();
	}
	
	//READ ONE
	
	public Optional<Animal> getOneAnimal(Long id) {
		return this.repo.findById(id);
	}
	
	//UPDATE
	
	public Animal updateAnimal(Long id, Animal newAnimal) {
		Optional<Animal> existingOptional = this.repo.findById(id);
		Animal existing = existingOptional.get();
		
		existing.setName(newAnimal.getName());
		existing.setSpecies(newAnimal.getSpecies());
		existing.setType(newAnimal.getType());
		
		return this.repo.save(existing);
	}
	
	//DELETE
	
	public boolean removeAnimal(Long id) {
		// removes the entity
		this.repo.deleteById(id);
		// checks to see if it still exists
		boolean exists = this.repo.existsById(id);
		// returns true if entity no longer exists
		return !exists;
	}
	
	
	
	

}
