package com.pknu.test.di;

import javax.annotation.Resource;

public class PetOwner {
	// bean 목록에서 생성자에 필요한 class를 자동으로 집어넣음
	// @Autowired : data type이 같은 bean을 자동 주입한다.
	// @Qualifier : 인스턴스 id로 값을 찾는다.
	
	//@Autowired
	//@Qualifier(value="cat")
	
	// 인스턴스 id 대신 name으로 의존성 값을 찾아 주입한다.
	@Resource(name="dog")
	private AnimalType animal;

	public void play() {
		animal.sound();
	}
	
}
