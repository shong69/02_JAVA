package edu.kh.inheritance.model.dto;


//final 클래스 -> 상속 불가하다
//-제공되는 클래스 그대로 사용해야 하는 경우에 사용함
//String 클래스
public /*final*/class Employee extends Person {
	
	//필드
	private String company;
	
	//기본 생성자
	public Employee () {}
	//매개변수 생성자

	public Employee(String name, int age, String nationality, String company) {
		super(name, age, nationality);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	//Person으로부터 상속받은 메서드 중 move() 메소드를 자식 Emnployee에 맞게 재정의하기(==overriding)
	
	//@Override 어노테이션 : 해당 메서드가 오버라이딩 되었음을 컴파일러에게 알려줌(문법체크 등 함)
	
	//어노테이션(annotation) : 컴파일러에게 알려주기 위한 코드(컴파일러인식용 주석)
	
	@Override
	public void move() {
		System.out.println("오버라이딩 된 move()");
		System.out.println("효율적으로 빨리 일하고 움직인다.");
		
		
		
		
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"/"+company;
	}
	
	
	
	/*final 메서드 ->오버라이딩 불가
	 * 
	 * -메서드의 기능이 변하면 안되는 경우에 사용
	 * 
	 * */
	public final void onlyEmployee() {
		System.out.println("final 메서드 입니다");
	}
	
	
	
	
}
