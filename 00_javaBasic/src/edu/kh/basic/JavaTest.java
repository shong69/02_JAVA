package edu.kh.basic;

//한 줄 주석 : 컴파일러(번역기)가 해석하지 않는 부분
/*범위 주석
 * 
 * 
 * */

//class : 자바 코드가 작성되는 영역
public class JavaTest {
	public static void main(String[] args) {
		//main method(메서드): 자바 애플리케이션(프로그램)을 실행하기 위해 반드시 필요함
		System.out.println("Hello World");
		System.out.println("쏨땀");
		System.out.println("물갈비");
		
		//ctrl+alt 방향키 : 작성한 방향으로 해당 줄 복사하기
		
		System.out.println("------------------------");//syso 치고 ctrl+space 누르면 자동완성 됨
		
		//숫자 연산
		System.out.println("1+2"); // 1+2 그대로 출력됨
		System.out.println(1+2);  //3 연산결과 출력
		//""안에 작성된 코드는 단순문자열로 인식
		//""안에 작성되지 않은 코드는 숫자, 변수로 인식함
		
		System.out.println(50-23);
		System.out.println(12*3);
		System.out.println(503/3);
		System.out.println(12%2);  //산술 연산자는 다 똑같이 작동함
		
		
		//""(문자열) + 숫자 함께 작성할 때
		System.out.println("14*19=" + 266);
		System.out.println("14*19=" + 14*19); //문자열 + 숫자의 연산까지 출력 가능함
		
		System.out.println("90+70+65="+ 90 + 70 + 65); //연산 순서 상 더하기를 앞에서부터 적용했기 때문에 나머지 숫자들도 문자로 인식함
		System.out.println("90+70+65="+ (90 + 70 + 65)); //소괄호로 묶어서 정상 출력
		//자바는 사칙연산의 우선순위를 그대로 따른다
		//->우선계산을 원하면 소괄호를 사용한다
		
		// +기호의 역할
		// ->숫자 + 숫자 = 덧셈
		// ->문자열 + 숫자 or 문자열 + 문자열 : 이어쓰기		
	}

}
