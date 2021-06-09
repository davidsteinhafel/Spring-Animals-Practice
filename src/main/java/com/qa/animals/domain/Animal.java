package com.qa.animals.domain;

public class Animal {
	private String name;
	private String species;
	private String type;
	
public Animal() {
	}
	
	public Animal(String name, String species, String type) {
		super();
		this.name = name;
		this.species = species;
		this.type = type;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
