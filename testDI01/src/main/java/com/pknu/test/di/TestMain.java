package com.pknu.test.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/pknu/test/di/beans/animal.xml");
		PetOwner person = (PetOwner) context.getBean("petOwner");
		person.play();
		context.close();
	}
}
