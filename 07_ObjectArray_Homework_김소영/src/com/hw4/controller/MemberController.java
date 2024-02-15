package com.hw4.controller;

import com.hw4.model.vo.Member;

public class MemberController {
	public static int SIZE;
	private int memberCount;
	private Member mem[] = new Member[SIZE];
	
	{
		mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
		mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
		mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yoo5@hanmail.ner");
		mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@gmail.com");
		mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com");
		memberCount = 5;
	}
	
	
	
	public int getMemberCount() {
		return memberCount;
	}
	public Member[] getMem() {
		//mem 주소값 리턴
		return mem;
		
	}
	
	public Member checkId(String userId) {
		Member m = null; //아이디로 검색된 결과를 담을 변수 초기화
		
		//mem에서 매개변수로 전달받은 userId와 동일한 아이디를 가지고 있는 회원을 m에 대입
		//m 리턴
		for(int i = 0; i<memberCount; i++) {
			if(mem[i].getUserId().equals(userId)) {
				m = mem[i];
			}
		}
		return m;
	}
	
	public void insertMember(Member m) {
		//매개변수로 전달받은 회원정보를 mem 객체에 추가
		//memberCount 1 증가
		
		mem[memberCount] = m;
		memberCount ++;
	}
	
	
	public Member searchMember(int menu, String search) {
		Member searchMember = null;  //검색된 회원 정보를 담을 변수 초기화
		
		//매개변수로 전달받은 search 문자열을 menu 번호에 따라
		//1인 경우 아이디로 검색 후 결과를 searchMember에 대입
		//2인 경우 이름으로 검색 후 결과를 searchMember에 대입
		//3인 경우 이메일로 검색 후 위와 같음
		for(int i =0;i<=memberCount; i++) {
			if(i == 1) {
				if(mem[i].getUserId().equals(search)) {
					searchMember = mem[i];
				}
			}else if(i == 2) {
				if(mem[i].getUserId().equals(search)) {
					searchMember = mem[i];
				}
			}else {
				if(mem[i].getUserId().equals(search)) {
					searchMember = mem[i];
				}
			}
		}
		//searchMember 주소값 리턴
		return searchMember;
	}
	
	public void updateMember(Member m, int menu, String update) {
		if(menu == 1) {
			mem[]
		}
	}
	
	public void deleteMember(String userId) {
		
	}
	
	public Member[] sortIdAsc() {
		
	}
	public Member[] sortIdDesc() {
		
	}
	public Member[] sortAgeAsc() {
		return mem;
		
	}
	public Member[] sortAgeDesc() {
		
	}
	public Member[] sortGenderDesc() {
		
	}

	
}