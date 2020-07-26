package com.pknu.test.di;

public class PetOwner {
	private AnimalType animal;

	public PetOwner(AnimalType animal) {
		this.animal = animal;
	}
	
	public void play() {
		animal.sound();
	}
	
}
