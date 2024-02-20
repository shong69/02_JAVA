package com.hw2.model.dto;

public class Tiger extends Animal{

	public Tiger() {}
	public Tiger(String name) {
		super(name);
	}
	
	public void sound() {
		System.out.println(name+"(이)가 어흥~하며 포효합니다.");
	}
}
