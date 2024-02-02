package edu.kh.op.ex;

import java.util.Scanner;

public class OpExemple {//예제 코드 작성용 클래스
	
	//ex2() method : 객체 지향 프로그래밍에서 OpExemple 객체와 관련된 함수
	//OpExemple이 가지고 있는 기능 중 ex1()이라는 기능
	public void ex1() {
		//System.out.println("ex1() 호출 중");//
		//증감(증가, 감소) 연산자 : ++, --
		int iNum1 = 10;
		int iNum2 = 10;
		
		iNum1++; //iNum1을 1 증가시킴
		iNum2--; //iNum2를 1 감소시킴
		
		System.out.println("iNum1 : " + iNum1);//11
		System.out.println("iNum2 : " + iNum2);//9'
		
		//전위연산
		int temp1 = 5;
		System.out.println(++ temp1 + 5);//5 +1 +5가됨
		//후위연산
		int temp2 = 3;
		System.out.println(temp2-- + 2); //3+2가 출력되고 나서 temp2-1이 된다
		System.out.println(temp2); //2가 나온다
		
		int a = 3;
		int b = 5;
		int c = a++ + --b;
		
		System.out.printf("%d / %d / %d\n",a,b,c);//4,4,7

	}
	public void ex2() {
		//비교 연산자 : >, <, >=, <=, ==, !=
		//-비교연산자의 결과는 항상 논리값(true/false)
		int a = 10;
		int b = 20;
		
		System.out.println(a>b);//false
		System.out.println((a==b)==false); //true
						//()괄호 안에 있는 것 먼저 연산
						//false == false -> true
		int c = 4;
		int d = 5;
		System.out.println((++c!=d) == (--c!=d)); //false
							//false	==   true ->false
	}
	public void ex3() {
		//논리연산자 : && ||
		//&& : and 연산자
		//와, 그리고, ~면서, ~부터~까지, ~사이
		int a = 101;
		//a 는 100 이상이면서 짝수인가?
		System.out.println(a>=100 && a%2==0); //false
		
		int b = 5;
		//b는 1부터 10까지 숫자 범위에 포함돼 있는가?
		System.out.println(b>=1&&b<=10);//true
		
		System.out.println("---------------------------------");
		//|| : or연산자 둘 다 false면 false, 나머지는 true(and 반대)
		//또는, ~거나, ~이거나
		
		int c = 10;
		System.out.println(c>10 || c%2==0);//true
		
		
		
		
	}
	public void ex4() {
		//삼항 연산자 : 조건식? true일 때 수행될 값 : false일 때 수행될 값
		
		//*조건식 : 연산 결과가 true/false인 식이어야 함
		
		int num = 30;
		//num이 30보다 크면(초과) "num은 30보다 큰 수이다"
		//아니면 "num은 30 이하의 수이다" 출력
		
		//System.out.println(num>30? "num은 30보다 큰 수이다":"num은 30 이하의 수이다");
		
		String result = num > 30? "num은 30보다 큰 수이다":"num은 30 이하의 수이다";
		System.out.println(result);
		System.out.println("----------");
		
		//입력받은 정수가 음수인지 양수인지 구분
		//단, 0은 양수로 처리
		
		//ex)
		//정수 입력 : 4
		//양수입니다.
		//정수입력 : -5
		//음수입니다.
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		
		int a = sc.nextInt();
		
		System.out.println(a>=0 ? "양수 입니다.":"음수 입니다.");
	}
}
