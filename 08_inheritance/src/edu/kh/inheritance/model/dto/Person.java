package edu.kh.inheritance.model.dto;

/*Object
 * ㄴPerson
 * 	 ㄴStudent
 * */



//DTO :(data transfer object) : 비지니스 계층과 데이터 교환을 위해 사용하는 객체
public class Person {
	//Object 클래스
	//-모든 클래스의 최상위 부모
	//-class 선언부에 상속 구문이 하나도 작성되어있지 않다면 compiler가 extends Object 구문을 추가해준다.
	
	private String name;
	private int age;
	private String nationality;
	
	public Person() {} //기본 생성자
	public Person(String name, int age, String nationality) {  //매개변수 생성자
		super(); //부모님의 생성자-> 상속 후 Object에서 Person 으로 바뀌었다.
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}
	
	//메서드
	//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	

	public void breath() {
		System.out.println("사람은 코나 입으로 숨을 쉰다.");
	}
	
	public void move() {
		System.out.println("사람은 움직일 수 있다.");
	}
	
	
	@Override
	public String toString() {
		
		//Object의 toString()재정의
		return name+" / "+age+"/"+nationality;
	}
	
	

}
