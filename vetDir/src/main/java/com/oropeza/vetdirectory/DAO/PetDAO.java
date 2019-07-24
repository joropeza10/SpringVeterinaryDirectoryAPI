package com.oropeza.vetdirectory.DAO;

import java.util.List;

import com.oropeza.vetdirectory.entity.Pet;

public interface PetDAO {
	
	public List<Pet> listPets();
	
	public Pet findById(int id);
	
	public void save(Pet thePet);
	
	public void deleteById(int id);
	
	
}
