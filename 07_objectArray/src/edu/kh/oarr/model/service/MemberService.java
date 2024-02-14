package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {

	//속성
	private Scanner sc = new Scanner(System.in);
	
	//Member 5칸짜리 객체배열 선언 및 할당
	private Member memberArr[] = new Member[5];
	
	//현재 로그인한 회원의 정보를 저장할 변수 선언
	private Member loginMember = null; //로그인은 한사람만 가능
	
	public MemberService() {  //기본생성자
		
		//memberArr 배열 0,1,2 인덱스 초기화(매번 5명 회원가입 시키기 힘들어서 미리 3명만 만들어둠)
		memberArr[0] = new Member("user01", "pass01","홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02","계보린", 25, "경기");
		memberArr[2] = new Member("user03", "pass03","고길동", 45, "강원");
	}
	
	
	//기능
	
	//메뉴 출력용 메서드
	public void displayMenu() {
		int menuNum = 0;  //메뉴 선택용 변수
		
		//무조건 한번은 반복
		do {
			System.out.println("===회원정보 관리 프로그램v2====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보 조회");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원 검생(지역)");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("메뉴 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine(); //입력 버퍼에 남은 개행문자 제거용
			
			switch(menuNum) {
			case 1: System.out.println(signUp()); break;
			case 2: System.out.println(login()); break;
			case 3: System.out.println(selectMember()); break;
			case 4: 
				int result = updateMember();
			
				if(result == -1) {
					System.out.println("로그인 후 이용해주세요.");
				}else if(result == 0) {
					System.out.println("회원정보 수정 실패(비밀번호 불일치");
				}else {
					System.out.println("회원정보가 수정됐습니다.");
				}
				
				break;
			case 5:  searchRegion(); break;
			case 0: System.out.println("프로그램 종료"); break;
			
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요!");
			}
			
			
		}while(menuNum != 0); //menuNum이 0돼면 반복 종료
	}
	
	//memberArr에 비어있는 인덱스 번호를 반환하는 메서드
	//단, 비어있는 인덱스가 없다면 -1 반환
	public int emptyIndex() {
		//memberArr 배열을 0index부터 끝까지 접근해 참조하는 값이 null인 경우의 인덱스를 반환함
		
		for(int i = 0;i<memberArr.length;i++) {
			if(memberArr[i] == null) {
				return i; //현재 메서드를 종료하고 호출한 곳으로 i값을 가지고 돌아감(메서드 탈출)
			}		
		}
		
		return -1;  //배열에 빈칸이 없는 경우 -1 반환
	}
	
	
	/*case1 회원가입 메서드*/
	
	public String signUp() {
		System.out.println("\n=========회원가입==========");
		
		//객체 배열 memberArr에 가입한 회원 정보를 저장할 예정
		//=>새로운 회원정보를 저장할 공간이 있는지 확인 + 빈 공간 인덱스를 얻어옴
		
		int index  = emptyIndex(); //null인 인덱스(없으면 -1)을 호출해주는 메서드
		
		if(index == -1) { //비어있는 인덱스가 없을 경우->회원가입 불가
			return "회원가입이 불가능합니다. (인원수 초과)";			
		}

		
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
		
		System.out.print("지역 : ");
		String region = sc.next();
		
		if(memberPw.equals(memberPw2)) { //비밀번호, 비밀번호 확인이 일치하면 회원가입 성공/ 아니면 실패
			//Member객체를 생성해 할당된 주소를 memberAtt의 비어있는 인덱스에 대입하기
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, region);
			
			
			return "회원가입이 성공했습니다";
		}else {
			return "회원가입 실패(비밀번호 불일치)";
		}
		
	}
	
	
	
	/*case2 로그인 메서드*/
	public String login() {
		System.out.println("\n====로그인====");
		
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		//1. memberArr배열 내 요소를 순서대로 접근하여 null이 아닌지 확인
		for(int i  = 0; i < memberArr.length; i++) {
			if(memberArr[i] != null) {  //회원정보가 있을 경우
				
				//2. 회원정보(memberArr[i]의 아이디, 비밀번호와 입력받은 아이디(memberId)와 비밀번호(memberpw)가 같은지 확인
				
				if(memberArr[i].getMemberId().equals(memberId) &&
						memberArr[i].getMemberPw().equals(memberPw)) {
					
					//3.로그인회원정보 객체를 참조하는 변수 loginMember에 현재 접근중인 memberArr[i]에 저장된 주소를 얕은 복사
					loginMember = memberArr[i];
					break; //더이상 같은 아이디, 비밀번호가 없기 때문에 for문 종료
					
				}
			}
		}
		
		//4. 로그인 성공/실패 여부에 따라 결과값 반환
		if(loginMember == null) {  //로그인 실패
			
			return "아이디 또는 비밀번호가 일치하지 않습니다.";
			
		}else {  //로그인 성공
			return loginMember.getMemberName()+"님 환영합니다";
		}
	}
	
	
	
	/*case5 회원검색(지역) 메서드*/
	public void searchRegion() {
		System.out.println("\n====회원검색(지역)====");
		
		System.out.print("검색할 지역을 입력하세요 : ");
		String inputRegion = sc.next();
		
		//검색결과 신호용 변수
		boolean flag = true;
		
		//1)memberArr 배열의 모든 요소 순차 접근하기
		for(int i = 0;i<memberArr.length;i++) {
			//2)memberArr의 i번째 요소가 null인 경우 반복 종료
			if(memberArr[i]==null) {
				break;
			}
			//3)memberArr[i]요소에 저장된 지역(region)이 위에서 입력받은(inputRegion)과 같은 경우 회원의 아이디, 이름 출력
			if(memberArr[i].getRegion().equals(inputRegion)) {
				System.out.printf("아이디 : %s, 이름 : %s\n", 
						memberArr[i].getMemberId(),memberArr[i].getMemberName()
						);
				flag = false;
			}
			
		}
		
		if(flag) { //flag == true
			System.out.println("일치하는 검색결과가 없습니다");
		}
	}
	
	
	
	/*case3 회원정보 조회 메서드*/
	public String selectMember() {
		//로그인됐는지 확인하고 이름이랑 나이 알려줌 
		System.out.println("\n=========회원정보 조회==========");

		if(loginMember== null) { //로그인 안된 경우
			return "로그인 후 검색하세요";
		}
		
		//로그인 도니 경우 문자열로 회원정보 반환
		String str ="아이디 : " +  loginMember.getMemberId() +
				"\n이름 : "+ loginMember.getMemberName() +
				"\n나이 : " + loginMember.getMemberAge() + "세\n" +
				loginMember.getRegion()+" 거주";
		
		return str;
	}
	
	
	
	/*case4 회원정보 수정 메서드*/
	
	public int updateMember() {
		System.out.println("\n=========회원정보 수정==========");

		if(loginMember==null) {
			return -1;
		}
		
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if(loginMember.getMemberPw().equals(inputPw)) {
			System.out.print("수정할 이름 입력 : ");
			String inputName = sc.next();
			loginMember.setMemberName(inputName);
			
			System.out.print("수정할 나이 입력 : ");
			int inputAge = sc.nextInt();
			loginMember.setMemberAge(inputAge);
			
			System.out.print("수정할 지역 입력 : ");
			String inputRegion = sc.next();
			loginMember.setRegion(inputRegion);
			
			return 1;
			
		}else {
			
			return 0;
		}
	}
	
	
	

	
	
	
	
}
