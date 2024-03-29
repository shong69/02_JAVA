package com.hw4.model.dto;

import java.util.Objects;

public class Toy {

	private String name; //이름
	private int properAge; //사용 가능 연령
	private int price; //가격
	private String color; //색상
	private int manufactDate; //제조일(문자열로 표현)
	private  String element; //재료
	
	public Toy() {
		
	}
	public Toy(String name, int properAge, int price, String color, int manufactDate, String element) {
		super();
		this.name = name;
		this.properAge = properAge;
		this.price = price;
		this.color = color;
		this.manufactDate = manufactDate;
		this.element = element;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProperAge() {
		return properAge;
	}
	public void setProperAge(int properAge) {
		this.properAge = properAge;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getManufactDate() {
		return manufactDate;
	}
	public void setManufactDate(int manufactDate) {
		this.manufactDate = manufactDate;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	
	
	
	
	@Override
	public String toString() {
		return "이름 : " + name + "/ 가격 : " + price + "/ 색상 : " + color
				+ "/ 사용가능연령 : "+properAge +"/ 제조년월일 : " + manufactDate + "/ 재료 : " + element;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(color, element, manufactDate, name, price, properAge);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return Objects.equals(color, other.color) && Objects.equals(element, other.element)
				&& manufactDate == other.manufactDate && Objects.equals(name, other.name) && price == other.price
				&& properAge == other.properAge;
	}

	
	
	
}
