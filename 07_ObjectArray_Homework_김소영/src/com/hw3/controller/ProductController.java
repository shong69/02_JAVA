package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;

public class ProductController {
	Scanner sc = new Scanner(System.in);
	
	private Product proArr[] =null;
	
	//객체 수 카운드 
	public static int count= 0;
	
	
	//초기화 블럭에 배열 10칸 할당하기
	{
		proArr = new Product[10];
	}
	
	public void mainMenu() {
		//메뉴출력(do while)
		int menuNum = 0;
		do {
			System.out.println("====제품 관리 메뉴====");
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1: productInput(); break;
			case 2: productPrint(); break;
			case 0: System.out.println("프로그램이 종료됩니다."); break;
			default: System.out.println("번호를 잘못 입력했습니다. 다시 해주세요.");
			}
			
		}while(menuNum !=0);
	}
	
	public void productInput() {
		System.out.println("========제품 정보 추가=========");

		System.out.print("제품번호 입력 : ");
		int inputNum = sc.nextInt();
		
		System.out.print("제품명 입력 : ");
		String inputName = sc.nextLine();
		sc.nextLine();
		
		System.out.print("제품 가격 입력 : ");
		int inputPrice = sc.nextInt();
		
		System.out.print("제품 세금 입력 : ");
		double inputTax = sc.nextDouble();
		
		
		proArr[count] = new Product(inputNum, inputName, inputPrice, inputTax);
		//count 확인하고 9 이하면 count만큼의 인덱스에 객체 생성
	}
	

	public void productPrint() {
		System.out.println("========제품 정보 조회=========");

		if(proArr[0]==null) {
			System.out.println("저장된 제품 정보가 없습니다.");
			
		}
		for(int i = 0;i<count;i++) {
			System.out.println(proArr[i].information());
	
		}

		
	}
	
	
	
	
	
	
}