package com.pknu.user.vo;

// Value Object = Data Transfer Object
public class UserVO {
	private String name;
	private String tel;
	
	
	public UserVO() {}
	public UserVO(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
