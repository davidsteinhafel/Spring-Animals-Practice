package com.qa.animals.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
		this.animals.add(animal);
		Animal added = this.animals.get(this.animals.size() - 1);
		// Now we return the created animal and the appropriate status code
		return new ResponseEntity<Animal>(added, HttpStatus.CREATED);
	}
	
	//ReadAll

	@GetMapping("/getAll")
	public ResponseEntity<List<Animal>> getAllAnimals() {
		//return new ResponseEntity<List<Animal>>(this.animals, HttpStatus.OK);
		
		// builder pattern
		return ResponseEntity.ok(this.animals);
	}
	
	//READ ONE
	
	@GetMapping("/getOne/{index}")
		public ResponseEntity<Animal> getAnimal(@PathVariable int index) {
			return this.animals.get(index) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	

	//DELETE ONE
	
	@DeleteMapping("/remove/{index}")
	public ResponseEntity<Animal> removeAnimal(@PathVariable int index) {
		return this.animals.remove(index) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//Update
	
	@PutMapping("/replace/{index}")
	public Animal replace(@PathParam("name") String name, @PathParam("species") String species,
			@PathParam("type") String type) {
		return null;
	}
	
	//UPDATE ONE
	
	@PutMapping("/replace/{index}")
	public ResponseEntity<Animal> updateAnimal(@PathVariable int index, @RequestBody Animal newAnimal){
		this.animals.set(index, newAnimal);
		return new ResponseEntity<Animal>(newAnimal,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/update/{index}")
	public ResponseEntity<Animal> changeSpecies(@PathParam("species") String species, @PathVariable int index){
		Animal updatedAnimal = this.animals.get(index);
		updatedAnimal.setSpecies(species);
		return new ResponseEntity<Animal>(updatedAnimal, HttpStatus.ACCEPTED);
	}

}
