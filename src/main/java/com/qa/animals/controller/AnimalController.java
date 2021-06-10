package com.qa.animals.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.animals.domain.Animal;
import com.qa.animals.service.AnimalService;


@RestController
@RequestMapping("/animal")
public class AnimalController {

	private AnimalService service;

	
	
	@Autowired
	public AnimalController(AnimalService service) {
		this.service = service;
	}
	
	
	//CREATE
	
	
	@PostMapping("/create")
	public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {

		return new ResponseEntity<Animal>(this.service.addAnimal(animal), HttpStatus.CREATED);
	}
	

	// READ ALL

	@GetMapping("/getAll")
	public ResponseEntity<List<Animal>> getAllAnimals() {

		return ResponseEntity.ok(this.service.getAllAnimals());
	}

	// READ ONE

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Optional<Animal>> getAnimal(@PathVariable long id) {
		return ResponseEntity.ok(this.service.getOneAnimal(id));
		
	}

	// DELETE ONE

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Animal> removeAnimal(@PathVariable long id) {
		return this.removeAnimal(id) != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Update

	/*
	 * @PutMapping("/replace/{id}") public Animal replace(@PathParam("name") String
	 * name, @PathParam("species") String species,
	 * 
	 * @PathParam("type") String type) { return null; }
	 */

	// UPDATE ONE

	@PutMapping("/replace/{id}")
	public ResponseEntity<Animal> updateAnimal(@PathVariable long id, @RequestBody Animal newAnimal) {
		this.service.updateAnimal(id, newAnimal);
		return new ResponseEntity<Animal>(newAnimal, HttpStatus.ACCEPTED);
	}

	/*
	 * @PatchMapping("/update/{id}") public ResponseEntity<Animal>
	 * changeSpecies(@PathParam("species") String species, @PathVariable long id) {
	 * Animal updatedAnimal = this.service.updateAnimal(id, Animal newAnimal).
	 * updatedAnimal.setSpecies(species); return new
	 * ResponseEntity<Animal>(updatedAnimal, HttpStatus.ACCEPTED); }
	 */
}
