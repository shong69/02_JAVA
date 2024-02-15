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
		if(mc.getMemberCount()>=MemberController.SIZE ) {
			System.out.println("회원 수를 초과했습니다.");
			return ;
		}
		//2. 아이디를 입력 받아 MemberController을 checkId()메소드로 전달>>결과값
		System.out.print("아이디를 입력해 주세요 : ");
		String inputId = sc.next();
		Member m =mc.checkId(inputId);
		
		if(m !=null) {
			System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
		}else {
			System.out.println("비밀번호 : ");
			String userPwd = sc.nextLine();
			
			System.out.println("이름 : ");
			String name = sc.nextLine();
			
			System.out.println("나이 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.println("성별 : ");
			char gender = sc.nextLine().charAt(0);
			System.out.println("이메일 : ");
			String email = sc.nextLine();
			mc.insertMember(new Member(inputId, userPwd,name,age,gender, email));
			
			System.err.println("성공적으로 회원등록이 되었습니다.");
		}
		
		
	}
	
	public void searchMember() {
		while(true) {
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
			String search = sc.nextLine();
			
			Member result = mc.searchMember(menu, search);
			if(result == null) {
				System.out.println("검색된 결과가 없습니다.");  //아이디 잘못 입력한 경우 에러 발생함
			}else {
				System.out.println("====검색결과====");
				System.out.println(result.information());
			}
		}
	}
	
	public void updateMember() {
		while(true) {
			System.out.println("=====회원정보 수정=====");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 이메일 수정");
			System.out.println("9. 이전 메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu==9) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}

			System.out.print("변경할 회원 아이디 : ");
			String inputId = sc.nextLine();
			Member m = mc.checkId(inputId);
			
			if(m==null)System.out.println("변경할 회원이 존재하지 않습니다.");
			else {
				System.out.println("기존 정보 : "+m.information());
				System.out.print("변경 내용 입력 : ");
				String update = sc.nextLine();
				

				mc.updateMember(m,menu,update);
				System.out.println("회원의 정보가 변경되었습니다.");
			}
		}

		
	}
	
	public void deleteMember() {
		System.out.print("삭제할 회원 아이디 입력 : ");
		String inputId = sc.next();
		
		Member m = mc.checkId(inputId);
		
		if(m ==null)  System.out.println("삭제할 회원이 존재하지 않습니다.");
		else {
			System.out.println("기존 정보 : "+m.information());
			System.out.print("정말 삭제하시겠습니까?");
			char ans = sc.nextLine().toUpperCase().charAt(0);
			if(ans=='Y') {
				mc.deleteMember(inputId);
				System.out.println("회원의 정보가 삭제되었습니다.");
			}else {
				System.out.println("삭제할 회원에 대한 정보가 존재하지 않습니다.");
			}
				
		}
			
	}
	
	public void printAllMember() {
		Member[] mem = mc.getMem();
		for(int i =0;i<mc.getMemberCount();i++) {
			System.out.println(mem[i].information());
		}
	}
	public void sortMember() {
		Member[] sortMem = null;
		
		while(true) {
			System.out.println("=====회원 정보 정렬=====");
			System.out.println("1. 아이디 오름차순 정렬");
			System.out.println("2. 아이디 내림차순 정렬");
			System.out.println("3. 나이 오름차순 정렬" );
			System.out.println("4. 나이 내림차순 정렬" );
			System.out.println("5. 성별 내림차순 정렬(남여 순)" );
			System.out.println("9. 이전 메뉴로" );
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			if(menu==9) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}
			switch(menu) {
			case 1: sortMem = mc.sortIdAsc(); break;
			case 2: sortMem = mc.sortIdDesc(); break;
			case 3: sortMem = mc.sortAgeAsc(); break;
			case 4: sortMem = mc.sortAgeDesc(); break;
			case 5: sortMem = mc.sortGenderDesc(); break;
			
			default: System.out.println("잘못된 입력입니다.");
			
			}
			
			for(int i = 0;i<mc.getMemberCount();i++) {
				System.out.println(sortMem[i].information());
			}

		}
	}
}
