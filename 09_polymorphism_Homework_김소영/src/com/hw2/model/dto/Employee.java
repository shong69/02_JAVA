package com.hw2.model.dto;

public class Employee extends Person{

	private String position;

	public Employee() {}
	public Employee(String id, String name,String position) {
		super(id, name);
		this.position = position;
	}
	@Override
	public String getInfo() {
		return "ID : " + id +", 이름 : "+name+" , 직책 : "+position;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
