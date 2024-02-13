package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	Scanner sc = new Scanner(System.in);
	SnackController scr = new SnackController();
	
	
	public void menu() {
		
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		String inputkind = sc.next();
		
		
		System.out.print("이름");
		String inputName = sc.next();
		
		System.out.print("맛");
		String inputFlavor = sc.next();
		
		System.out.print("개수 : ");
		int inputNumOf = sc.nextInt();
		
		System.out.print("가격 : ");
		int inputPrice = sc.nextInt();
		
		scr.saveData(inputkind, inputName, inputFlavor, inputNumOf, inputPrice);
		
		System.out.println("저장한 정보를 확인하시겠습니까?(y/n) : ");

		String inputYn = sc.next();
		
		if(inputYn.equals("n")) {
			
		}else if(inputYn.equals("y")) {
			scr.confirmData();
		}else {
			System.out.println("잘못된 입력입니다."); 
		}
	}
}
