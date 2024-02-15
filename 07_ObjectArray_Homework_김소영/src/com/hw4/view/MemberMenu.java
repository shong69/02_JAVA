package com.hw4.view;

import java.util.Scanner;

import com.hw4.controller.MemberController;
import com.hw4.model.vo.Member;

public class MemberMenu {
	private MemberController mc = new MemberController();
	
	Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("*****회원관리시스템*****");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: insertMember(); break;
			case 2: searchMember(); break;
			case 3: updateMember(); break;
			case 4: deleteMember(); break;
			case 5: printAllMember(); break;
			case 6: sortMember(); break;
			case 0: System.out.println("시스템이 종료되었습니다."); return;
			
			default: System.out.println("잘못된 선택입니다.");
			}
		}
		
	}

		

	public void insertMember() {
		//1. 현재 회원수(memberCount)가 최대 회원수(SIZE)를 넘어설 경우 return 처리
		if(mc.getMemberCount()>=mc.SIZE ) {
			System.out.println("회원 수를 초과했습니다.");
			return ;
		}
		//2. 아이디를 입력 받아 MemberController을 checkId()메소드로 전달>>결과값
		System.out.print("아이디를 입력해 주세요 : ");
		String inputId = sc.next();
		mc.checkId(inputId);
		
		
	}
	
	public void searchMember() {
		System.out.println("=====회원정보 검색=====");
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 이전 메뉴로");
		
		
		System.out.print("메뉴 선택 : ");
		int menu = sc.nextInt();
		if(menu==9) {
			System.out.println("이전 메뉴로 돌아갑니다.");
			return;
		}
		System.out.print("검색 내용 : ");
		String search = sc.next();
		
		Member result = mc.searchMember(menu, search);
		if(result == null) {
			System.out.println("검색된 결과가 없습니다.");
		}else {
			result.information()
		}
	}
	
	public void updateMember() {
		System.out.println("=====회원정보 수정=====");
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 이름 수정");
		System.out.println("3. 이메일 수정");
		System.out.println("9. 이전 메뉴로");
		
		System.out.print("메뉴 선택 : ");
		int menu = sc.nextInt();
		if(menu==9) {
			System.out.println("이전 메뉴로 돌아갑니다.");
			return;
		}
		System.out.print("변경할 회원 아이디 : ");
		String inputId = sc.next();
		//// redo
	}
	
	public void deleteMember() {
		
	}
	
	public void printAllMember() {
		
	}
	public void sortMember() {
		
	}
}
