package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {
	public void practice() {
		Book bk1 = new Book();
		Book bk2 = new Book("자바의 정석", 30000, 0.2, "남궁성");
		
		//toString()
		
		System.out.println("==========================");

		
		bk1.setTitle("C언어");
		bk1.setPrice(30000);
		bk1.setDiscountRate(0.1);
		bk1.setAuthor("홍길동");
		
		System.out.println("수정된 결과 확인");
		
		//toString()
		
		System.out.println("===========================");
		System.out.printf("도서명 : %s\n",bk1.getTitle());
		System.out.printf("할인된 가격 : %d원\n",1-bk1.getPrice()*bk2.getDiscountRate() );
		
		System.out.printf("도서명 : %s\n",bk2.getTitle());
		System.out.printf("할인된 가격 : %d원\n",1-bk2.getPrice()*bk2.getDiscountRate() );


	}
}
