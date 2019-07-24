package com.oropeza.vetdirectory.service;

import java.util.List;

import com.oropeza.vetdirectory.entity.Pet;


public interface PetService {

	public List<Pet> listPets();
	
	public Pet findById(int id);
	
	public void save(Pet thePet);
	
	public void deleteById(int id);
	
}
