package com.oropeza.vetdirectory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oropeza.vetdirectory.entity.Pet;
import com.oropeza.vetdirectory.service.PetService;

@Controller
public class VetController {
	
	@Autowired
	private PetService petService;

	
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/pets")
	public String homePage(Model theModel) {
		
		List<Pet> pets = petService.listPets();
		
		theModel.addAttribute("pets", pets);
		
		return "pets";
		
	}
	
	@GetMapping("/pets/new")
	public String addPet(Model theModel) {
		
		Pet pet = new Pet();
		
		theModel.addAttribute("pet", pet);
		
		return "showForm";
	}
	
	@GetMapping("/pets/edit")
	public String editpet(@RequestParam("petId") int petId, Model theModel) {
		
		Pet pet = petService.findById(petId);
		
		theModel.addAttribute("pet", pet);
		
		return "showEditForm";
	
	}
	
	@GetMapping("/pets/delete")
	public String deletePet(@RequestParam("petId") int petId) {
		
		petService.deleteById(petId);
		
		return "redirect:/pets";
		
	}
	
	@PostMapping("/pets/save")
	public String savePet(@ModelAttribute("pet") Pet pet) {
		petService.save(pet);
		
		return "redirect:/pets";
	}
	
	
	
	
	
}
