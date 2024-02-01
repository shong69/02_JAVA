package edu.kh.variable.ex1;

public class VariableExemple1 {
	//생성된 .java 파일과 class 오른쪽에 작성된 이름은 같아야 한다
	
	//프로그램 실행 시 제일 먼저 main메소드를 찾아간다
	public static void main(String[] args) {
		System.out.println(2*3.141592653589793*5); //->작성하기 힘들어! 변수 선언한다
		
		/*변수(variable)
		 * -메모리(RAM)에 값을 기록하는 공간
		 * 	->공간에 기록되는 값(data)이 변할 수 있어서 변수라고 부른다
		 * 
		 * -변수는 여러 종류가 존재함(저장되는 값의 형태, 크기가 다르다)
		 * 
		 * 변수 사용의 장점
		 * 1. 가독성이 좋다
		 * 2. 재사용성 증가(한 번 만든 변수 계속 사용 가능)
		 * 3. 코드 길이의 감소
		 * 4. 유지보수성 증가
		 * */
		
		double pi = 3.141592653589793;//원주율
		int r = 5;//반지름(radius)
		int h = 20; //높이(height)
		
		
		System.out.println("----------------------------");
		
		System.out.println(2*pi*r);//원의 둘레
		System.out.println(pi*r*r);//원의 넓이
		System.out.println(pi*r*r*h);//원기둥의 부피
		System.out.println(4*pi*r*r);//구의 겉넓이
		
		
		
		
	}
}
