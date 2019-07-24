package com.oropeza.vetdirectory.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oropeza.vetdirectory.entity.Pet;
import com.oropeza.vetdirectory.service.PetService;


@RestController
@RequestMapping("/api")
public class PetsController {

	
	private PetService petService;
	
	@Autowired
	public PetsController(PetService thePetService) {
		petService = thePetService;
	}
	
	@GetMapping("/pets")
	public List<Pet> getPets() {
		return petService.listPets();
	}
	
	@GetMapping("/pets/{petId}")
	public Pet getPet(@PathVariable int petId)  {
		
		
		Pet pet = petService.findById(petId);
		
		if(pet == null) {
			throw new RuntimeException("PET ID NOT FOUND!");
		}
		
		return pet;
	}
	
	@PostMapping("/pets")
	public Pet addPet(@RequestBody Pet thePet) {
		
		thePet.setId(0);
		
		petService.save(thePet);
		
		return thePet;
		
	}
	
	@PutMapping("/pets")
	public Pet updatePet(@RequestBody Pet thePet) {
		
		petService.save(thePet);
		
		return thePet;
		
	}
	
	@DeleteMapping("/pets/{petId}")
	public String deletePet(@PathVariable int petId) {
		
		Pet pet = petService.findById(petId);
		
		if(pet == null) {
			throw new RuntimeException("PET ID NOT FOUND!");
		}
		
		petService.deleteById(petId);
		
		return "Pet deleted with id: " + petId;
	}
}
