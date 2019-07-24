package com.oropeza.vetdirectory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oropeza.vetdirectory.DAO.PetDAO;
import com.oropeza.vetdirectory.entity.Pet;

@Service
public class PetServiceImpl implements PetService {

	private PetDAO petDAO;
	
	public PetServiceImpl(PetDAO thePetDAO) {
		
		petDAO = thePetDAO;
	}
	
	@Override
	@Transactional
	public List<Pet> listPets() {
		
		return petDAO.listPets();
	}

	@Override
	public Pet findById(int id) {
		
		return petDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Pet thePet) {
		
		petDAO.save(thePet);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		petDAO.deleteById(id);

	}

}
