package edu.kh.oop.method.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService {
	//속성 (필드)
	private Scanner sc = new Scanner(System.in);
	private Member memberInfo = null;  //가입할 회원의 정보를 저장할 변수
		//참조변수, 참조형이기 때문에 jvm에서 기본적으로 null 값을 넣어준다
	private Member loginMember = null;  //로그인한 회원의 정보를 저장할 변수
	
	//기능(생성자, 메서드)
	//따로 구현할 내용은 없음(기본생성자가 자동으로 생성됨)
	
	//메뉴 화면 출력 기능
	public void displayMenu() {
		int menuNum = 0;  //메뉴 선택용 변수
		
		//무조건 한번은 반복
		do {
			
			System.out.println("==========회원정보 관리 프로그램==========");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();
			
			//입력 버퍼에 남은 개행 제거
			sc.nextLine();
			
			switch(menuNum) {
			case 1: System.out.println(signUp()); break; //string을 반환할 함수signup 호출
			case 2: System.out.println(login());break;
			case 3: System.out.println(selectMember());break;
			case 4: 
				int result = updateMember();
				
				if(result == -1) {
					System.out.println("로그인 후 이용해주세요.");
				}else if(result == 0) {
					System.out.println("회원정보 수정 실패(비밀번호 불일치)");
				}else { //result == 1
					System.out.println("회원정보가 수정됐습니다.");
				}
				
				break;
				
			case 0: System.out.println("프로그램 종료");break;
			default: System.out.println("잘못 입력하셨습니다. 메뉴에 있는 번호만 입력해주세요");
			}
			
		}while(menuNum !=0);  //menuNum이 0이되면 종료
		
		
		
		
	}



	//회원가입 기능
	public String signUp() {
		//반환형
		//해당 메서드는 끝나고 호출한 곳으로 돌아갈 때 String 자료형 값을 가지고 돌아간다.
		
		System.out.println("\n**********회원가입**********");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		//비밀번호, 비밀번호 확인이 일치하면 회원가입, 아니면 실패
		
		if(memberPw.equals(memberPw2)) { //일치
			
			//입력받은 정보를 이용해서 Member 객체를 생성한 후 생성된 객체의 주소를 필드에 있는 memberInfo에 대입
			memberInfo = new Member(memberId, memberPw, memberName, memberAge); //memberInfo에 값 대입해줌
			return "회원가입 성공!";
			
		}else { //불일치
			return "회원가입 실패!(비밀번호 불일치)";
		}	
	}
	
	

	public String login() {
		System.out.println("\n**********로그인**********");
		
		//1. 회원가입여부 먼저 확인
		//==memberInfo가 객체를 참조하고 있는지 확인(null인지 아닌지)
		
		if(memberInfo == null) {
			//null은 아무것도 참조하고 있지 않는 상태
			return "회원가입부터 진행해주세요!";
		}
		
		//2. 회원가입 했다면 로그인기능 수행
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();

		//3. 이미 회원가입한 정보(memberInfo가 참조하는 Member객체)들과 일치하는지 확인
		//저장된 아이디, 비밀번호가 입력받은 아이디, 비밀번호롸 같으면 "로그인 성공"
		//같지 않으면 "아이디 또는 비밀번호가 일치하지 않습니다" 리턴
		
		//아이디, 비밀번호 모두 일치할 경우
		if(memberId.equals(memberInfo.getMemberId()) && memberPw.equals(memberInfo.getMemberPw())) {
			//입력받은 memberId와 memberInfo 필드에서 참조중인 Member 객체의 memberId가 같은지 확인(pw도 마찬가지)
			
			//loginMember에 Member 객체 주소 대입
			loginMember = memberInfo;
			//loginMember도 참조형 변수임(얕은 복사)
			
			//회원가입 정보를 loginMember에 대입하여 어떤 회원이 로그인했는지를 구분할 수 있도록함
			
			return loginMember.getMemberName()+ "님 환영합니다.";
		}else {
			return "아이디 또는 비밀번호가 일치하지 않습니다.";
		}
		
		
	}
		
	
	
	public String selectMember() {
		//1.로그인 했는지 확인 (안했을땐는 문구 return)
		//2.로그인 된 경우 회원정보를 출력할 문자열을 만들어서 반환(return)
		//단 비밀번호는 제외
		System.out.println("\n******회원정보 조회******");
		if(loginMember==null) {
			return "로그인 후 이용해주세요";
		}
		//방법 1. return("아이디 : "+loginMember.getMemberId()+"\n이름 : "+loginMember.getMemberName()+"\n나이 : "+loginMember.getMemberAge()+"세");
		//방법2. 
		String str = "이름 : " + loginMember.getMemberName();
		str += "\n아이디 : " + loginMember.getMemberId();
		str += "\n나이 : " +  loginMember.getMemberAge()+"세";
		
		return str;

		
	}
	
	//회원정보 수정 기능
	public int updateMember() {
		System.out.println("\n********회원정보 수정********");
		
		//1)로그인 여부 판별
		//로그인이 돼있지 않으면 -1을 반환
		if(loginMember==null) {
			return -1;
		}
		
		//2)로그인이 된 경우 1.수정할 회원 정보를 입력받기(이름이랑 나이만) 
		//2. 비밀번호를 입력받아 로그인한 회원의 비번과 일치하는지 확인->같은 경우 로그인한 회원의 이름, 나이 정보를 변경 후 1 리턴
		//   비밀번호가 다를 경우엔 0 반환
		System.out.println("수정할 이름 입력 : ");
		String inputName = sc.next();
		
		
		System.out.println("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();
		
		System.out.println("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if(inputPw.equals(loginMember.getMemberPw())) {
			
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			return 1;
		}else {
			return 0;
		}
		

		
	}
	
	
	
	
}
