package com.pknu.spring.vo;

public class BoardVO {
	private String a;
	private int    b;
	
	
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	
	@Override
	public String toString() {
		return "BoardVO [a=" + a + ", b=" + b + "]";
	}
}
