package com.oropeza.vetdirectory.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oropeza.vetdirectory.entity.Pet;

@Repository
public class PetDAOImpl implements PetDAO {

	private EntityManager entityManager;
	
	// AUTOMATICALLY CREATED BY SPRING BOOT ENTITY MANAGER
	@Autowired
	public PetDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	//@Transactional
	// TO HANDLE THE TRANSACTION MANAGEMENT SO WE DONT HAVE TO MANUALLY
	// START AND COMMIT TRANSACTION
	public List<Pet> listPets() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Pet> query = session.createQuery("from Pet", Pet.class);
		
		List<Pet> pets = query.getResultList();
		
		return pets;
		
	}


	@Override
	public Pet findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Pet pet = session.get(Pet.class, id);
		
		return pet;
	}


	@Override
	public void save(Pet thePet) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(thePet);
		
	}


	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Pet> query = session.createQuery("delete from Pet where id=:petId");
		
		
		query.setParameter("petId", id);
		
		query.executeUpdate();
		
	}

}
