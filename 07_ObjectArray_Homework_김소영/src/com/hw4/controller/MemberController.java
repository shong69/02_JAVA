package com.hw4.controller;

import com.hw4.model.vo.Member;

public class MemberController {
	public static final int SIZE=10;
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
		return this.memberCount;
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
		for(int i =0;i<memberCount; i++) {
			if(menu == 1) {
				if(mem[i].getUserId().equals(search)) {
					searchMember = mem[i];
				}
			}else if(menu == 2) {
				if(mem[i].getName().equals(search)) {
					searchMember = mem[i];
				}
			}else {
				if(mem[i].getEmail().equals(search)) {
					searchMember = mem[i];
				}
			}
		}
		//searchMember 주소값 리턴
		return searchMember;
	}
	
	public void updateMember(Member m, int menu, String update) {
		if(menu == 1) {
			m.setUserPwd(update);
		}else if(menu==2) {
			m.setUserId(update);
		}else if(menu == 3) {
			m.setEmail(update);
		}else {
			System.out.println("잘못된 선택지입니다.");
		}
	}
	
	public void deleteMember(String userId) {
		//매개변수로 전달받은 userId가 mem에 존재하는 경우 해당 회원 삭제 후 다음 인덱스 객체들의 정보를 한 칸씩 앞으로 이동시킴 
		//-> 삭제시킨 위치 기억하고 다음칸 인덱스 한칸씩 줄여서 넣기
		//실행 시 NullPointerExecption 발생할 수 있음->왜 그런지 생각해보기
		
		for(int i = 0;i<memberCount;i++) {
			if(mem[i].getUserId().equals(userId)) {
				for(int j = i;j<memberCount;j++) {
					mem[j]=mem[j+1]; 
				}
				//break; //break하는 이유??
			}
		}
		memberCount--;
		//memberCount 1 감소
	}
	
	public Member[] sortIdAsc() {
		//compareTo(String) -> 음수는 나중, 양수는 더 앞인 문자열
		Member[] copy = mem.clone();
		//삽입정렬 사용
		for(int i = 0; i<memberCount; i++) {
			for(int j = 0;j<i;j++) {
				if(copy[i].getUserId().compareTo(copy[j].getUserId())<0) { // 뒤에 있는 수가 더 커야지 음수가 결과로 나옴
					Member temp = copy[j];
					copy[j]=copy[i];
					copy[i] = temp;
				}
			}

		}
		return copy;
		
	}
	public Member[] sortIdDesc() {
		
		//선택 정렬
		Member[] copy = mem.clone();
		for(int i = 0;i<memberCount-1; i++) {
			for(int j = i+1;j<memberCount;j++) {
				if(copy[i].getUserId().compareTo(copy[j].getUserId())<0) {
					Member temp = copy[j];
					copy[j]=copy[i];
					copy[i]=temp;
				}
			}
		}
		return copy;
		
	}
	public Member[] sortAgeAsc() {
		Member[] copy = mem.clone();
		//삽입정렬
		for(int i = 0; i<memberCount;i++) {
			for(int j = 0;j<i;j++) {
				if(copy[i].getAge()<copy[j].getAge()) {
					Member temp = copy[j];
					copy[j]=copy[i];
					copy[i]=temp;
				}
			}
		}
		return copy;
			
		
	}
	public Member[] sortAgeDesc() {
		Member[] copy = mem.clone();
		//삽입정렬
		for(int i = 0; i<memberCount;i++) {
			for(int j = 0;j<i;j++) {
				if(copy[i].getAge()>copy[j].getAge()) {
					Member temp = copy[j];
					copy[j]=copy[i];
					copy[i]=temp;
				}
			}
		}
		return copy;
		
	}
	public Member[] sortGenderDesc() {
		Member[] copy = mem.clone();
		//삽입정렬
		for(int i = 0; i<memberCount;i++) {
			for(int j = 0;j<i;j++) {
				if(copy[i].getGender()=='M'&&copy[j].getGender()=='F') {
					Member temp = copy[j];
					copy[j]=copy[i];
					copy[i]=temp;
				}
			}
		}
		return copy;
	}

	
}