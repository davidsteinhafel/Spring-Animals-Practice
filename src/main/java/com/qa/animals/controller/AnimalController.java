package com.qa.animals.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.animals.domain.Animal;

@RestController
public class AnimalController {
	
	@GetMapping("/hello")
	public String sayHi() {
		return "Hello, World";
	}
	private List<Animal> animals = new ArrayList<>();

	
	@PostMapping("/create")
	public String addAnimal(@RequestBody Animal animal){
		this.animals.add(animal);
		return "Successfully Added an Animal";
	}
	
	
	
	@GetMapping("/getAll")
	private List<Animal> getAllAnimals(){
		return this.animals;
		
	}
	
	@DeleteMapping("/remove/{index}")
	public Animal removeAnimal(@PathVariable int index) {
		return this.animals.remove(index);
	}

	@PutMapping
	public Animal replace(@PathParam("name") String name, @PathParam ("species")String species, @PathParam ("type") String type) {
		return null;
	}
	
	

}
