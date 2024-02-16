package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;
import edu.kh.poly.ex2.model.vo.Fish;
import edu.kh.poly.ex2.model.vo.Person;

public class AbstractService {
	
	public void ex1() {
		//animal 추상 클래스가 정말 객체화 되지 않는지
		//Animal a1 = new Animal();
		//Cannot instantiate the type Animal (객체화 할 수 없음 에러 뜸)
		
		//클래스 : 객체의 속성과 기능을 정의함(일종의 설계도)
		//추상 클래스 : 미완성 메서드를 포함한 클래스(미완성 설계도)
		//->미완성 설계도로는 객체를 만들 수 없다 -> 오류 발생
		
		//-> Animal을 상속받아 미완성 부분을 구현한 클래스를 이용해 객체 생성해야 함
		
		//추상 클래스를 상속받은 자식 객체 생성
		Person p1 = new Person();
		
		p1.setName("홍길동");
		
		//상속받은 기능 호출
		p1.setType("척추동물");
		p1.setEatType("잡식");
		
		//오버라이딩한 메서드 호출
		p1.eat();
		p1.breath();
		p1.move();
		
		Fish f1 = new Fish();
		
		//오버라이딩한 메서드 호출
		f1.eat();
		f1.breath();
		f1.move();
		
	}
	
	
	
	public void ex2() {
		
		//추상 클래스와 다형성 + 바인딩
		
		//추상클래스는 객체로 만들 수 없다!
		//->하지만 "참조변수"로는 쓸 수 있다@@@@
		
		//Animal a1 = new Animal(); 에러남
		
		//사람 -> 동물  /  물고기 -> 동물
		//Animal a1 = new Person();  //다형성 중 업캐스팅 적용됨
		//Animal a2 = new Fish();
		
		
		Animal[] arr = new Animal[2];
		//Animal 참조변수 배열 선언 및 할당
		
		arr[0] = new Person("사람","잡식","김사람");
		//Aniaml 부모 = Person 자식(다형성 중 업캐스팅)
		arr[1] = new Fish("물고기","잡식");
		//Aniaml 부모 = Fish 자식(다형성 중 업캐스팅)

		//바인딩 확인
		for(int i = 0;i<arr.length;i++) {
			//arr[i] == Animal 참조변수
			arr[i].eat();
			arr[i].breath();
			System.out.println(arr[i].toString());
			
			//edu.kh.poly.ex2.model.vo.Animal.eat() - 정적 바인딩
			
			System.out.println("----------------------------");
			
			//프로그램 실행 시 참조하고 있는 자식 객체의 오버라이딩 된 eat(), breath(), toString() 메소드를 수행함
			//->동적 바인딩 : 부모 타입 참조변수로 메소드를 호출했지만
			//					자식 타입의 오버라이딩된 메서드가 수행된다.
			
		}
		
	
		
		
	}
}
