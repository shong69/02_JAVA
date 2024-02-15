package com.kh.inheritance.model.dto;

public class BasicPhone extends Phone{

	private boolean hasPhysivalKeyboard;
	
	public BasicPhone() {}

	public BasicPhone(String brand, String model, int year, int price,boolean hasPhysivalKeyboard) {
		super(brand, model, year,price);
		this.hasPhysivalKeyboard = hasPhysivalKeyboard;
	}
	
	
	public void checkKeyboard() {
		
		if(hasPhysivalKeyboard) {
			System.out.println("이 휴대폰은 물리적 키보드가 있습니다.");

		}else {
			System.out.println("이 휴대폰은 물리적 키보드가 없습니다.");

		}
	}

	public boolean isHasPhysivalKeyboard() {
		return hasPhysivalKeyboard;
	}

	public void setHasPhysivalKeyboard(boolean hasPhysivalKeyboard) {
		this.hasPhysivalKeyboard = hasPhysivalKeyboard;
	}
}
