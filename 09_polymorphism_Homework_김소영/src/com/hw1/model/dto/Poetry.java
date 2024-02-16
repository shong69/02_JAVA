package com.hw1.model.dto;

public class Poetry extends Book{
	private int numberOfPoems;

	public Poetry() {}
	public Poetry(String title, String author, int numberOfPoems) {
		super(title, author);
		this.numberOfPoems = numberOfPoems;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("[전문 서적] 제목 : "+getTitle()+"/ 저자 : "+getAuthor()+" / 시 수 : "+numberOfPoems);
		
	}
	

}
