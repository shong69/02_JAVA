package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {
	public void ex1(){
		//다형성 확인 예제
		
		//Car 객체 생성
		Car car = new Car();
		//부모타입 참조변수 = 부모객체
		
		//Tesla 객체 생성
		Tesla tesla = new Tesla();
		//자식타입 참조변수 = 자식객체
		
		//****************다형성*****************
		//부모타입참조변수 = 자식객체
		Car car2 = new Tesla();  //오류 발생 안함
		//Tesla 객체를 참조하는 변수의 타입이 Car(부모)이기 때문에 
		//Tesla객체가 Car(부모)객체로 변화함.
		
		Car car3 = new Spark();
		
		//******* 다형성(업캐스팅) 작성 방법 *********
		//1) 자식 객체가 부모객체로 변했기 때문에 자식만의 고유한 필드, 메서드를 사용할 수 없게됨
		
		//1-1)car(부모=부모)
		car.setEngine("v6 6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		//Car 메서드 모두 사용 가능
		
		//1-2)tesla(자식 = 자식)
		tesla.setEngine("전기모터");
		tesla.setFuel("전기");
		tesla.setWheel(4);
		tesla.setBatteryCapacity(1000000);
		//Tesla 부모, 본인의 메서드 모두 사용 가능
		
		//1-3)car2 (부모 = 자식(Tesla))
		//업캐스팅
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		//car2.setBatteryCapacity(1000000); ->The method setBatteryCapacity(int) is undefined for the type Car
		//car니까 car것만 사용 가능
		
		
		//car3(부모 = 자식(Spark())
		//업캐스팅
		//Car car3 = new Spark();
		car3.setEngine("경차 엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
		//car3.setDiscountOffer(0.5); 사용 불가 -> 부모 흉내를 내는 자식은 본인거를 사용 못함
		
		//-------------------------------------------------------------------------------
		//2)다형성을 이용한 객체배열
		
		//객체배열 : 같은 객체 참조 자료형의 변수를 하나의 묶음으로 다루는 것
					//부모 타입 참조 자료형의 변수를 하나의 묶음으로 다루는 것
		
		Car[] arr = new Car[3];  //부모 타입 참조변수 배열 선언 및 할당
		
		//각 배열 요소 Car 타입 참조변수
		arr[0] = car; //Car car = new Car(); Car 주소 들어감
		arr[1] = car2; //Tesla tesla = new Tesla(); Tesla 주소 
		arr[2] = car3; //Spark 주소
		
		//부모타입 참조변수의 배열에 다형성이 적용된 객체들이 들어갈 수 있다
		
		for(int i=0; i < arr.length; i++) {
			System.out.println(i+"번째 인덱스의 엔진 : "+arr[i].getEngine());
		}
		
		// 상속 + 다형성
		// 상속 특징 : Car 상속 클래스는 모두 getEngine()을 가지고 있다를 정의함
		//다형성(업캐스팅) : 부모타입 참조변수 arr[i]로 자식객체를 참조할 수 있다.
		
		
		
	}

	//전달받은 Car 또는 자식객체(Tesla, Spark)의 엔진, 연료 바퀴갯수를 출력하는 메서드
	//매개변수에 부모 타입 참조변수를 작성하면 모든 자식객체를 전달받을 수 있다.
	public void printCar(Car temp) { 
		//부모타입 참조변수 = 자식타입객체
		//다형성의 업캐스팅 모양과 똑같음
		//=>temp에는 Tesla, Spark, Car의 주소가 넘어올 수 있다(업캐스팅 적용됨)
		
		System.out.println("엔진 : " +temp.getEngine());
		System.out.println("연료 : " +temp.getFuel());
		System.out.println("바퀴 갯수 : " +temp.getWheel()+"개");
		System.out.println();  //줄바꿈
	}
	
	
	public Car createCar(int num) {
		//num에 따라 만들어진 객체를 돌려주는 메서드
		Car result = null;
		switch(num) {
		case 1: result = new Car(); break; 
		case 2: result = new Tesla(); break;
		case 3: result = new Spark(); break;
		}
		return result;
	}
	
	
	
	public void ex2() {
		//다형성(업캐스팅)을 이용한 매개변수 사용법
		Tesla t = new Tesla("전기모터","전기",4,1000000);
		
		Spark s = new Spark("경차엔진", "휘발유",4,0.5);
		
		Car c = new Car("경유엔진","경우",12);
		
		printCar(t); //Tesla
		printCar(s); //Spark
		printCar(c); //Car
		
		
		System.out.println("---------------------------------------");
		
		//다형성을 이용한 반환형 사용법
		
		//Car[] arr = {new Car(), new Tesla(), new Spark()};
		Car[] arr = { createCar(1), createCar(2), createCar(3) };
						//Car		//Car(Tesla)  //Car(Spark)		
		
		//instanceof 연산자 : 객체의 자료형을 검사하는 연산자
		//->참조하는 객체가 특정 자료형이거나 부모쪽 상속관계인지 확인해줌
		
		System.out.println(arr[1] instanceof Tesla); //True 호출
		System.out.println(arr[1] instanceof Spark); //False 호출
		System.out.println(arr[1] instanceof Car); //True 호출(부모 상속관계임)
		
		
		
		
		
		
		
		
		
	}

	
	public void ex3() {
		
		// ********** 다형성 중 다운캐스팅 ***********
		//다운캐스팅이란?
		//부모타입 참조변수가 자식객체를 참조하는 기술로
		//업캐스팅 상태에서만 진행할 수 있음
		//부모타입을 자식타입으로 "강제 형변환"해서 자식객체의 본래 필드와 메서드를 사용 가능하게함
		
		Car c1 = new Tesla("전기모터", "전기",4,50000);
		//업캐스팅 상태
		
		//System.out.println(c1.getBatteryCapacity());->업캐스팅 상태에서는 사용 불가한 게터
		
		System.out.println(((Tesla)c1).getBatteryCapacity()); 
		//형변환을 먼저 감싸주지 않으면 getter가 먼저 접근하게 된다
		//( . 연산자가 형변환 연산자보다 우선순위가 높다)
		
		//다운캐스팅 방법2
		Tesla t1=(Tesla)c1;
		System.out.println(t1.getBatteryCapacity());
			
	}
	

	
	public void ex4() {
		//다운 캐스팅 주의사항
		
		Car c1 = new Tesla(); //업캐스팅
		//Spark s1 = (Spark)c1;
		//실행 시 오류 : ClassCastExeption ->형변환 예외
		//->c1이 참조하는 객체는 Tesla인데 Spark참조변수로 Tesla를 참조하려고 하면 문제 발생
		
		//해결방법 : instanceof 와 같이 사용해야한다!!
		
		if(c1 instanceof Spark) {
			Spark s1 = (Spark)c1; //다운캐스팅
			System.out.println("성공");
		}else {
			System.out.println("실패. Spark타입이 아님");
		}//예외처리
				
		
		
	}
	
	
	public void ex5() {
		
		//바인딩(Binding)
		//실제 실행할 메소드 코드와 호출하는 코드를 연결시키는 것
		
		Car c1 = new Car("경유엔진", "경유",8);
		
		System.out.println(c1.getEngine());
		//Car객체에 있는 getEngine메소드를 호출함 == 바인딩
		// edu.kh.poly.ex1.model.vo.Car.getEngine()
		
		
		//프로그램 "실행 전"
		//-컴파일러는 getEngine() 메소드가 Car에 있는걸로 인식해서 
		//c1.getEngine() 호출코드와 edu.kh.poly.ex1.model.vo.Car.getEngine() 메소드 코드를 연결
		//->정적 바인딩
		
		// ** 다형성 적용 시 바인딩 **
		
		Car c2 = new Spark("경차엔진","휘발유",4,0.5);
		//업캐스팅 적용 -> 부모 부분만 참조 가능한 상태
		
		System.out.println(c2.toString());
		//edu.kh.poly.ex1.model.vo.Car.toString()
		//참조변수 c2가 Car타입이므로 toString()도 Car의 toString() 호출 - 정적 바인딩
		
		//하지만 실행해보면 자신(Spark)의 toString()이 호출되고 있음
		//->컴파일 시에는 부모(Car)와 바인딩 == 정적 바인딩
		//->"실행" 시에는 자식(Spark)의 오버라이딩된 메소드와 바인딩 == 동적 바인딩
				
	}

	
	
	
	
	
	
	
	
	
	
}
