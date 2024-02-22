package com.hw4.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.hw4.model.dto.Toy;

public class ToyFactory {
	
	/*
	 * 반드시 지켜야 할 사항
		1. 장난감은 똑같은 재료를 중복으로 저장할 수 없다. -> 재료를 저장할 때 중복 검사
		2. 똑같은 장난감을 만들 수 없다. ->장난감 등록할 때 검사
		3. 장난감을 저장할 컬렉션에 중복된 장난감이 있어서는 안된다. ->??앞이랑 같은 얘기 아닌가??
		4. 재료는 { 고유번호 : 재료명 } 형식으로 작성되어 있어야 한다. -> Map으로 저장
		5. 재료의 고유번호는 중복될 수 없다. -> 재료 저장 시 고유번호 중복 검사
		6. 재료 등록 시 이미 등록된 고유번호의 재료가 있으면, 덮어쓰겠냐는 질문을 하고 y/n으로 답변을 입력받아 처리해야 한다.
		7. 재료 삭제 시 고유번호가 아닌, 재료명을 입력받아 같은 재료명이 있으면 삭제한다.
	*/
	
	
	Scanner sc = new Scanner(System.in);	
	
	//기본 등록된 재료 Map 설정
	Map<Integer, String> elInven = new HashMap<Integer, String>();
	//현재 제작된 장난감 목록 설정 set ->장난감들의 순서는 상관없고 중복 없어야 함 =>  set
	//set의 중복 제거 => hashCode, equals 작성
	Set<Toy> toyList = new HashSet<Toy>();
	//장남감의 재료 목록 StringBuilder 사용
	
	public ToyFactory(){
		elInven.put(1, "면직물");
		elInven.put(2, "플라스틱");
		elInven.put(3, "유리");
		elInven.put(4, "고무");
		
		toyList.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805,"면직물, 고무" ));

		toyList.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, "면직물, 플라스틱"));

		toyList.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, "면직물, 플라스틱"));
		
		toyList.add(new Toy("캣냅", 8, 27000, "보라색", 19960128,"면직물, 플라스틱"));

		toyList.add(new Toy("파피", 12, 57000, "빨간색", 19931225, "면직물, 플라스틱, 고무"));
		

	}

	
	
	
	public void displayMenu() {
		
		int menuNum = -1;
		do {
			System.out.println("\n<<플레이타임 공장>>");
			
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			
			
			System.out.print("선택 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1: lookupToy(); break;
			case 2: makeNewToy(); break;
			case 3: deleteToy(); break;
			case 4: searchToy1(); break;
			case 5: searchToy2(); break;
			case 6: addElement(); break;
			case 7: deleteElement(); break;
			
			default: System.out.println("잘못된 선택입니다. 종료합니다.");
			}
		}while(menuNum!=0);
	}
	
	
	/**
	 *1. 전체 장난감 조회하기 
	 */
	public void lookupToy() {
		System.out.println("<전체 장난감 목록>");
		
		for(Object toy : toyList) {
			System.out.println(toy.toString());
		}
		
	}
	
	
	/**
	 * 2. 새로운 장난감 만들기
	 * 장난감은 똑같은 재료를 중복으로 저장할 수 없다
	 * 똑같은 장난감을 만들 수 없다 ->이름이 같으면 안된다..?
	 */
	public void makeNewToy() {
		System.out.println("<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String name = sc.next();

		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		System.out.print("색상 : ");
		String color = sc.next();
		
		System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
		int manuDate = sc.nextInt();
		
		//재료 저장 어떻게 할지
		//-> StringBuilder로 만들고 중복 확인할때마다 배열로 바꿔서 확인 없으면 Builder에 추가
		StringBuilder list = new StringBuilder();
		String element;
		while(true) {
			System.out.print("재료를 입력하세요(종료하려면 'q'를 입력하세요) : ");
			element = sc.next();
			
			if(element.equals("q")) {
				break;
			}else {
				String temp = list.toString();
				String[] elList = temp.split(", ");
				
				boolean flag = false;
				for(String el : elList) {
					if(el.equals(element)) {
						System.out.println("이미 입력한 재료입니다.");
						flag = true;
						
					}
				}
				if(!flag) {
					list.append(element+", ");
				}
			}
		}
		
		//재료 리스트에서 마지막 쉼표와 공백 제거하기
		if(list.length()>0) {
			list.setLength(list.length()-2);
		}
		//재료 리스트 문자열로 바꾸기
		String strList = list.toString();
		if(toyList.contains(new Toy(name, age, price, color, manuDate, strList))) {
			System.out.println("이미 등록되어있는 장난감입니다.");
		}else {
			toyList.add(new Toy(name, age, price, color, manuDate, strList));
			System.out.println("새로운 장난감이 추가되었습니다.");
		}

		// 장난감 중복 검사 안됨
		//따옴표 마지막에도 생김
	}
	
	
	/**
	 * 3. 장난감 삭제하기
	 */
	public void deleteToy() {
		System.out.print("삭제할 장난감의 이름을 입력하세요 : ");
		String name = sc.next();
		
		boolean flag = false;
		for(Toy toy : toyList) {
			if(toy.getName().equals(name)) {
				toyList.remove(toy);
			}
		}
		if(flag) {
			System.out.println("장난감이 삭제되었습니다.");

		}else {
			System.out.println("해당하는 이름의 장난감을 찾을 수 없습니다.");

		}
	}
	
	
	
	/**
	 * 4. 장난감 제조일 순으로 조회하기
	 */
	public void searchToy1() {
		System.out.println("<제조일 순으로 장난감을 정렬>");
		//set을 list로 변환하여 sort 하기
		List<Toy> toyListSortedByDate = new ArrayList<Toy>(toyList);
		
		
		

		Collections.sort(toyList);
		for(Toy toy : toyList) {

		}
	}
	
	/**
	 * 5. 연령별 사용 가능한 장난감 리스트 조회하기
	 */
	public void searchToy2() {
		System.out.println("<연령별로 사용 가능한 장난감>");
		
		Set<Toy> toyList2 = toyList;
		//리스트 복제하고 for문으로 한바퀴 돌리면서 age 칸 찾고 remove(리턴값 프린트하기)
		for(int i=0; i<toyList2.size();i++) {
			
			int age = toyList2.get(i).getProperAge();
			System.out.printf("[연령 : %d세]\n", age);
			
			for(int j=0; j<toyList2.size();j++) {
				if(toyList2.get(j).getProperAge()==age) {
					
					System.out.println(toyList.remove(j).toString());
				}
			}
		}
	}
	
	
	
	/**
	 * 6. 재료 추가
	 */
	public void addElement() {
		System.out.println("<재료 추가>");
		System.out.println("***현재 등록된 재료***");
		
		Set<Entry<Integer,String>> entrySet = elInven.entrySet(); //entrySet 사용하기 위해 Set 사용
		for(Entry<Integer,String> entryset : entrySet) {
			System.out.printf("%d : %s",entryset.getKey(), entryset.getValue());
		}
		
		System.out.println("======================");
		
		System.out.print("재료 고유번호(Key) 입력 : ");
		int num = sc.nextInt();
		System.out.print("재료명 입력 : ");
		String name = sc.next();

		if(elInven.containsKey(num)) {
			System.out.println("이미 해당 키에 재료가 등록되어 있습니다");
			System.out.print("덮어쓰시겠습니까?(Y/N) : ");
			String ans = sc.next().toUpperCase();
			if(ans.equals("Y")) {
				elInven.put(num,name);
				System.out.println("재료가 성공적으로 덮어쓰기 되었습니다.");
			}else {
				return;
			}
		}else {
			elInven.put(num,name);
			System.out.println("새로운 재료가 성공적으로 등록되었습니다.");
		}


		
	}
	
	
	/**
	 * 7. 재료 제거
	 */
	public void deleteElement() {
		System.out.println("<재료 삭제>");
		if(elInven.size()>0) {
			System.out.println("***현재 등록된 재료***");
			
			Set<Entry<Integer,String>> entrySet = elInven.entrySet(); //entrySet 사용하기 위해 Set 사용
			
			for(Entry<Integer,String> entryset : entrySet) {
				System.out.printf("%d : %s",entryset.getKey(), entryset.getValue());
			}
			System.out.println("======================");

			System.out.print("삭제할 재료명 입력 : ");
			String name = sc.next();
			boolean flag = false;
			for(int i=0; i<elInven.size();i++) {
				if(elInven.get(i+1).equals(name)) {
					elInven.remove(i+1);
					System.out.printf("재료 '%s'가 성공적으로 제거되었습니다.", name);
				}
			}
			if(!flag) {
				System.out.println("해당 이름의 재료가 존재하지 않습니다.");
			}
		}
	}
}
