package com.hw3.model.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {

	Scanner sc = new Scanner(System.in);
	//도서 리스트 만들기
	List<Book> booklist = new LinkedList<Book>(); 
	List<Book> favoritelist = new LinkedList<Book>();
	//필드 값 초기화
	public BookService() {
		booklist.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		booklist.add(new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개"));
		booklist.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		booklist.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		booklist.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
	}
	
	public void displayMenu() {
		int menu = 0;
		
		do {
			System.out.println("===도서 목록 프로그램===");
			
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 조회");
			System.out.println("3. 도서 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 즐겨찾기 추가");
			System.out.println("6. 즐겨찾기 삭제");
			System.out.println("7. 즐겨찾기 조회");
			System.out.println("8. 추천도서 뽑기");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴를 입력하세요 : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: addBook(); break;
			case 2: lookupBook(); break;
			case 3: updateBook(); break;
			case 4: deleteBook(); break;
			case 5: addFavorite(); break;
			case 6: deleteFavorite(); break;
			case 7: lookupFavorite(); break;
			case 8: pickRecBook(); break;
			case 0: System.out.println("프로그램이 종료됩니다.");
			
			
			
			}
			
		}while(menu != 0);
	}

	
	
	public void addBook() {
		System.out.println("======도서 등록=====");
		
		System.out.print("도서 번호 : ");
		int num = sc.nextInt();
		System.out.print("도서 제목 : ");
		String name = sc.next();
		System.out.print("도서 저자 : ");
		String author = sc.next();
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		System.out.print("도서 출판사 : ");
		String publisher =sc.next();
		
		
		//등록 가능
		//등록 불가 -> 리스트 가득 찬 경우
		
		if(booklist.add(new Book(num, name, author, price, publisher))) {
			System.out.println("등록 완.");
		}else {
			System.out.println("저장공간이 가득 차 더이상 등록이 불가합니다.");
		}
		
		
	}
	
	public void lookupBook() {
		System.out.println("===도서 조회===");
		if(booklist.isEmpty()) {
			System.out.println("조회할 도서가 없습니다.");
		}else {
			for(Book book : booklist) {
				System.out.println(book.toString());
			}
		}

	}
	
	public void updateBook() {
		
		System.out.println("===도서 수정===");
		
		
		System.out.print("수정할 도서 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		boolean flag = false;
		
		int index=-1;
		for(int i  = 0; i< booklist.size(); i++) {
			if(booklist.get(i).getBookNum() == num) {
				flag = true;
				index = i;
			}
		}
		
		if(flag) {
			System.out.println("1. 도서명");
			System.out.println("2. 도서 저자");
			System.out.println("3. 도서 가격");
			System.out.println("4. 도서 출판사");
			System.out.println("0. 수정 종료");
			
			System.out.print("어떤 정보를 수정하시겠습니까?");
			int num1 = sc.nextInt();
			
			if(num1 == 1) {
				System.out.print("수정할 도서명을 입력하세요 : ");
				String name = sc.next();
			
				booklist.get(index).setBookName(name);

			}else if(num1 == 2) {
				System.out.print("수정할 도서 저자를 입력하세요 : ");
				String author = sc.next();
				booklist.get(index).setAuthor(author);
				
			}else if(num1 == 3) {
				System.out.print("수정할 도서 가격을 입력하세요 : ");
				int price = sc.nextInt();
				
				if(price > 0) {
					booklist.get(index).setPrice(price);
				}else {
					System.out.println("잘못된 입력입니다.");
				}
			}else if(num1 == 4) {
				System.out.print("수정할 도서 출판사를 입력하세요 : ");
				String publisher = sc.next();
				
				booklist.get(index).setPublisher(publisher);
			}else if(num1 == 0) {
				System.out.println("수정을 종료합니다.");
			}

		}else {
			System.out.println("잘못된 입력입니다.");
		}
	}
	
	public void deleteBook() {
		System.out.println("===도서 삭제===");
		
		System.out.print("삭제할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		
		boolean flag = false;
		int index = -1;
		for(int i  = 0; i< booklist.size(); i++) {
			if((booklist.get(i).getBookNum() == input)) {
				flag = true;
				index = i;
			}
		}
		
		if(flag) {
			Book temp = booklist.get(index);
			booklist.remove(index);
			System.out.println(temp.getBookName() +"에 대한 정보가 삭제되었습니다.");
		}else {
			System.out.println("잘못된 입력입니다.");
		}
	}
		
	
	public void addFavorite() {
		//즐겨찾기 추가 할 도서 번호 입력
		//즐겨찾기 기능?
		
		System.out.println("===즐겨찾기 추가===");
		
		System.out.print("즐겨찾기 추가 할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();

		//즐겨찾기 리스트에 없는 경우
		boolean flag1 = false;
		int index=-1;
		for(int i  = 0; i<favoritelist.size(); i++) {
			if((favoritelist.get(i).getBookNum() == input)) {
				System.out.println("이미 추가된 도서입니다.");
				flag1 = true;
				
			}
		}
		//북리스트에 있는 경우
		boolean flag2 = false;
		for(int i  = 0; i<booklist.size(); i++) {
			if((booklist.get(i).getBookNum() == input)) {
				flag2 = true;
				index = i;
			}
		}
		if(!flag2) {
			System.out.println("입력하신 도서의 정보가 존재하지 않습니다.");
		}
		//즐겨찾기 리스트에 없고, 북리스트에 있는 경우
		if(!flag1 && flag2) {
			favoritelist.add(booklist.get(index));
			System.out.println("즐겨찾기에 추가됐습니다.");
		}
		
	}
	
	public void deleteFavorite() {
		System.out.println("===즐겨찾기 삭제===");
		
		System.out.print("삭제하실 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		
		boolean flag1 = false;
		int index=-1;
		for(int i  = 0; i<favoritelist.size(); i++) {
			if((favoritelist.get(i).getBookNum() == input)) {
				flag1 = true;
				index = i;
				
			}
		}

		if(!flag1) {
			System.out.println("즐겨찾기로 등록된 도서번호가 아닙니다.");
		}else {
			favoritelist.remove(index);
			System.out.println("삭제되었습니다.");
		}
		
	}
	
	public void lookupFavorite() {

		if(favoritelist.isEmpty()) {
			System.out.println("-비어있습니다-");
		}
		for(Book favBook : favoritelist) {
			System.out.println(favBook.toString());
		}
	}
	
	//추천도서 뽑기
	public void pickRecBook() {
		int recBook = (int)(Math.random() * booklist.size());
		System.out.println("오늘의 추천도서는 "+booklist.get(recBook));
	}
	
}


