package edu.kh.variable.ex2;

public class PrintExemple {
	//main작성 ctrl+space+enter
	public static void main(String[] args) {
		//System.out.print():단순 출력(출력 후 줄바꿈x)
		//System.out.println():한 줄 출력(출력 후 줄바꿈 수행)
		//줄바꿈이라는 차이점은 있지만 괄호 안의 내용이 그대로 출력된다는 것은 똑같음
		
		//System.out.printLn(); 자동완성 syso ctl+space
		System.out.println("테스트1");
		System.out.println("테스트2"); //안에 있는 내용 실행 후 커서를 다음 줄로 내려주는 것까지 함
		System.out.print("테스트3"); //위의 println 덕분에 아래줄에 출력이 되지만 커서가 안내려가서 다음줄 클릭이 안된다.
		System.out.println(); //내용 없는 println():단순 줄바꿈
		System.out.print("테스트4"); 
		
		
		//System.out.printf():출력될 문자열 형식을 패턴으로 지정하는 출력구문
		
		System.out.println(); //위에 print 구문 썼으니 줄바꿈 해줌
		
		int iNum1 = 10;
		int iNum2 = 5;
		
		//10 + 5 = 15 모양으로 출력
		System.out.println(iNum1 +" + " + iNum2 + " = " + (iNum1+iNum2));//오타 날 확률 o
		
		/*printf에서 사용하는 패턴
		 *  %d : 정수형, %o : 8진수, %x : 16진수
			%c : 문자, %s : 문자열
			%f : 실수(소수점 아래 6자리), %e : 지수형태표현, %g : 대입 값 그대로
			%A : 16진수 실수
			%b : 논리형
		 * */
		//System.out.printf("패턴", 패턴에 들어갈 값);
		//10 + 5 = 15
		System.out.printf("%d + %d = %d\n",iNum1, iNum2, iNum1 + iNum2);//\n 사용해 줄바꿈
		System.out.println("next line");
		//10 + 10 * 5 / 2 = 35
		System.out.printf("%d + %d * %d / %d = %d\n", iNum1, iNum1, iNum2, 2, iNum1 + iNum1*iNum2/2);
		
		//패턴 연습
		int iNum3 =3;
		System.out.printf("%d\n",iNum3);  //3
		System.out.printf("%5d\n",iNum3);  //다섯 칸의 공간 확보 후 오른쪽 정렬
		System.out.printf("%-5d\n",iNum3);  //다섯 칸의 공간 확보 후 왼쪽 정렬
		
		
		//소수점 자리 제어(반올림처리)
		System.out.printf("%f\n",10/4.0);//2.500000
		System.out.printf("%.2f\n",10/4.0);//2.50 소수점 둘째자리
		System.out.printf("%.0f\n",10/4.0);//3 소수점 아래를 표현하지 않겠다
		
		//문자, 문자열 boolean
		boolean isTrue = false;
		char ch = '조';
		String str = "안녕하세요"; //String은 참조형
		//false / 조 / 안녕하세요
		System.out.printf("%b / %c / %s\n",isTrue, ch, str);
		
		//escape(이스케이프==탈출)문자 : 일반 문자가 아닌 특수문자 표현
		//     \ 
		System.out.println("\\");//역슬래시(백슬래시) 출력방법
		//  \0/
		System.out.println("\\0/");
		
		System.out.println("a\tb\tc\td");//tab 출력
		//한공간씩 표현 x, 한번에 공간 차지
		
		//유니코드 이스케이프
		System.out.println("\u0041");// A
		//유니코드(16진수)
		//65를 16진수로 표현 65/16 = 몫4 나머지 1
		
		
	}
}










