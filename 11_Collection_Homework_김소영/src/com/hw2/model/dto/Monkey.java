package com.hw2.model.dto;

public class Monkey extends Animal{

	public Monkey() {}
	public Monkey(String name) {
		super(name);
	}
	
	@Override
	public void sound() {
		System.out.println(name+"(이)가 우끼끼끼ㅣ 소리를 냅니다.");
	}
}
