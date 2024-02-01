package edu.kh.variable.ex1;

public class VariableExemple3 {
	public static void main(String[] args) {
		
		/*형변환(casting) : 값의 자료형을 변환하는 것(단, boolean은 제외)
		 * 
		 * **형변환이 왜 필요할까?
		 * 컴퓨터에서 기본적으로 같은 자료형끼리만 연산이 가능함
		 * 다른 자료형과 연산 시 오류가 발생한다.
		 * ->이 상황을 해결하기 위해 필요한 기술이 바로 형변환임
		 * 
		 * 자동/강제 형변환이 존재함 
		 * */
		
		int num1 = 10;
		double num2 = 3.5;
		
		System.out.println("자동 형변환 결과 : "+(num1 + num2)); //13.5 출력됨
		//원래 에러가 발생해야 하지만 "자동 형변환" 덕분에 발생 안함
		
		int i1 = 3;
		double d1 = i1;
		
		System.out.println("i1: "+i1);//정수 3
		System.out.println("d1: "+d1);//실수형으로 3.0 출력됨
		//double은 실수만 저장할 수 있는 자료형
		//정수가 대입되는 연산이 수행되면 자동으로 정수가 실수로 형변환된다.
		
		
		//int->long 형변환
		int i2 = 2_100_000_000;  //따옴표 대신 언더바로 자바에서 표현 가능
		long l2 = 10_000_000_000L;//100억
		
		long result2 = i2 + l2;
		System.out.println(result2); //int + long이므로 long으로 자동 형변환이 된다.12100000000이 출력됨
		
		
		//char->int 형변환
		//char 자료형은 문자형이지만 실제 저장하는 값은 0부터 6만 5천번 사이에 있는 숫자(정수형)
		char ch3 = 'V';
		int i3 = ch3; //int에 문자형을 대임
		
		System.out.println(i3);  //86이 출력됨(V의 문자코드)
		
		char ch4 ='각';
		int i4 = ch4;
		System.out.println(i4);  //44033 출력됨
		
		
		
		
		
		
		
		
		
	}
}
