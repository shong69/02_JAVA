package edu.kh.inheritance.model.dto;

public class Student extends Person {
	//Student 클래스에 Person 클래스의 내용을 연장한다
	//==Student 클래스에 Person 클래스의 내용(필드, 메서드)를 추가하여 확장한다
	
	//**상속**
	//자식 extends 부모
	
	//필드
	//private String name;
	//private int age;
	//private String nationality;
	private int grade;
	private int classRoom;
	
	public Student() {}

	public Student(String name, int age, String nationality, int grade, int classRoom) {
		
		//this.name = name;
		//this.age = age;
		//this.nationality = nationality;
		/*부모의 setter를 이용할 수 있지만 비효율적이다
		setName(name);
		setAge(age);
		SetNationality(nationality);
		*/
		
		//super(); 부모의 기본 생성자
		super(name, age, nationality);
		
		this.grade = grade;
		this.classRoom = classRoom;
	}
	/*
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
	*/
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "/"+grade + "/"+classRoom;  //person의 tostring에 내용 추가
	}
	
	
	
	
	
	
	
}
