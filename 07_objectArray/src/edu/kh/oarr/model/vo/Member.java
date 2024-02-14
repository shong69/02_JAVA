package edu.kh.oarr.model.vo;

public class Member {
	//속성(필드==멤버변수)
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region;  //지역
	
	
	
	
	//기능(생성자, 메서드)
	//생성자
	//기본생성자, 매개변수생성자
	//생성자 만드는 규칙
	//1. 생성자 이름은 클래스명과 같다
	//2. 반환형이 없다
	//**기본생성자는 컴파일러가 자동으로 생성해주는데, 생성자가 하나라도 있으면 직접 입력해야함
	//->매개변수 생성자가 있다면 기본생성자를 직접 작성해야 한다
	
	public Member() {}  //기본생성자
	//오버로딩 : 매개변수의 타입, 순서, 개수가 달라야한다.
	public Member(String memberId, String memberPw, 
			String memberName, int memberAge, 
			String region) {  //매개변수 생성자
		
		this.memberId  = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
	}
	
	
	//메서드
	//getter, setter
	
	//다 접근 가능하도록 public 
	public String getMemberId() {
		//반환형 : String 자료형을 돌려보낼거임
		return memberId; //getter 블럭 안에서 겹치는 이름이 없기 때문에(매개변수가 없기 때문에) this를 적지 않아도 됨
	}
	
	//반환형 : void 반환값이 없다
	public void setMemberId(String memberId) {
		//setter : 어떤걸 세팅할 지 전달받아온 아이가 매개변수임
		this.memberId = memberId;
		//모든 메서드는 종료 시에 호출한 곳으로 돌아가는 return 구문이 작성돼야 하지만
		//void일 경우에는 return 생략이 가능하며 compiler가 자동 추가해줌
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
	
	
	
	
	
	
	
}
