package edu.kh.poly.ex1.model.vo;

public class Car {

	//속성
	private String engine; //엔진
	private String fuel;   //연료
	private int wheel;  //바퀴 개수
	
	public Car() {}  //기본 생성자
	public Car(String engine, String fuel, int wheel) { //매개변수 생성자
		super(); //상속 전에는 최상위 부모인 Object로 이동된
		this.engine = engine;
		this.fuel = fuel;
		this.wheel = wheel;
	}
	
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public int getWheel() {
		return wheel;
	}
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	
	//Object.toString() 오버라이딩
	@Override  //오버라이딩된 메소드라는 것을 컴파일러에게 알려주는 Override 어노테이션(컴파일러 인식용 주석)
	public String toString() { 
		return engine + "/" + fuel + "/" + wheel;
	}
	
}
