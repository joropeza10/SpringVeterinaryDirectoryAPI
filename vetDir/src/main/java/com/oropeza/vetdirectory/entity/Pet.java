package com.oropeza.vetdirectory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="breed")
	private String breed;
	
	@Column(name="owner_first")
	private String owner_firstName;
	
	@Column(name="owner_last")
	private String owner_lastName;
	
	@Column(name="owner_phone")
	private String phone;
	
	public Pet() {};
	
	public Pet(int id, String name, String breed, String owner_firstName, String owner_lastName, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.owner_firstName = owner_firstName;
		this.owner_lastName = owner_lastName;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getOwner_firstName() {
		return owner_firstName;
	}

	public void setOwner_firstName(String owner_firstName) {
		this.owner_firstName = owner_firstName;
	}

	public String getOwner_lastName() {
		return owner_lastName;
	}

	public void setOwner_lastName(String owner_lastName) {
		this.owner_lastName = owner_lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", breed=" + breed + ", owner_firstName=" + owner_firstName
				+ ", owner_lastName=" + owner_lastName + ", phone=" + phone + "]";
	}
	
	
	
	
	
	
	
}
