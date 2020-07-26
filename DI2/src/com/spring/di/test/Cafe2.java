package com.spring.di.test;

import org.springframework.beans.factory.annotation.Autowired;

public class Cafe2 {

	private Human human;
	
	public void setHuman(Human human)
	{
		this.human = human;
	} // set에 값이 들어가야하는데, di.xml에 값을 주었음
	
	public void whoEat(){
		human.eat();
	}
	
}
