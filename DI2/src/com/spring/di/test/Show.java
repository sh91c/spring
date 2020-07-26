package com.spring.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Show {

	public static void main(String[] args) {
		
		//classShow();
		
		diShow();

	}
	
	public static void classShow()
	{
		Man man = new Man();
		Woman woman = new Woman();
		
		Cafe cafe = new Cafe();
		
		cafe.setHuman(man);
		cafe.whoEat();
		
		cafe.setHuman(woman);
		cafe.whoEat();
		
		//cafe.test();
	}
	
	public static void diShow()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("di.xml");
		
		Man man = (Man)ac.getBean("man"); // = new Man(); (di.xml에 정의되어있음)
		Woman woman = (Woman)ac.getBean("woman"); // = new Woman();
				
		Cafe2 cafe2 = (Cafe2) ac.getBean("cafe2"); // 기본적으로 man이 대입됨
		
		cafe2.setHuman(man); // cafe2 클래스에 man 수동으로 대입
		cafe2.whoEat();
		
		cafe2.setHuman(woman); // cafe2 클래스에 woman 수동으로 대입
		cafe2.whoEat();
		
		//cafe2.test();
		
	}

}
