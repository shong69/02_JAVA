package edu.kh.variable.ex1;

public class VariableExemple2 {
	public static void main(String[] args) {
		/*자바 기본 자료형 8가지
		 * 1.논리형 : boolean(1byte)
		 * 2.정수형 : byte(1), short(2byte), int(4), long(8)
		 * 3.실수형 : float(4byte), double(8byte)
		 * 4.문자형 : char(2byte,유니코드)
		 * */
		
		//변수 선언 : 메모리에 값을 저장할 공간을 할당해줌
		//변수 값 대입 : 변수에 값을 집어넣는 것
		
		
		//*카멜 표기법
		//연결된느 두 단어 중 후속단어의 첫 문자를 대문자로 표기하는 방법
		
		
		boolean booleanData;
		//메모리에 논리값(t/f)을 저장할 공간을 1btye 할당하고 할당된 공간을 booleanData라고 부르겠다.
		
		booleanData = true; //booleanData 변수에 true값을 집어넣기
		
		System.out.println("booleanData : "+booleanData);
		
		byte byteNumber =127; //128 넣는 순간 에러남
		//메모리에 정수 값을 저장할 공간을 1byte 할당하고 할당된 공간을 byteNumber라고 부르겠다.
		//선언된 byteNumber 변수에 처음으로 127을 넣었다.
		//-->초기화:처음 변수에 값을 대입하는 것
		
		System.out.println("byteNumber : "+ byteNumber);
		
		short shortNumber=32767; //32768 넣는 순간 에러
		//정수 자료형 기본형(short나 byte는 옛날 코드의 잔재임)
		int intNumber = 2147483647; //2147483648 넣는 순간 에러남
	 //자료형//변수명  //리터럴
		//프로그래밍에서는 대입되는 이 데이터(값 자체)를 리터럴이라는 단어로도 표현한다
		
		//*리터럴 : 변수에 대입되거나 작성하는 값 자체
		//+자료형에 따라 리터럴 표기법이 달라짐
		
		long longNumber = 10000000000L;//L 또는 ㅣ 을 적어 long 표기한 것을 나타냄
		//The literal 10000000000 of type int is out of range 
		//->100억이라는 값은 int의 범위를 벗어난 거임(int는 21억 몇까지 쓸 수 있음)
		//뒤에 L을 붙여줘서 long 자료형임을 나타냄
		
		float floatNumber = 1.2345f; 
		//F나 f를 적어 float 자료형임을 나타냄//아무것도 안붙인 실수는 double 자료형임
		double doubleNumber = 3.141582;
		//double이 실수형 중 기본형이다(리터럴 표기법이 없는 실수는 기본적으로 double로 인식)
		//d를 뒤에 쓸 수 있긴 함
		
		//문자형 리터럴 표기법 :''(홑따옴표)
		//->문자 하나만 쓸 때 사용함
		char ch = 'A';
		char ch2 = 66; //숫자 적어도 에러 안남
		/*char 자료형에 숫자가 대입될 수 있는 이유
		 * -컴퓨터에는 문자표가 존재함
		 *  숫자에 따라 지정된 문자 모양이 매핑되고 
		 *  'B'문자 그대로 대입되면 변수에 숫자 66으로 변환되어 저장함
		 * -> 반대로 생각하면 변수에 애초에 66을 저장하는 것이 가능함
		 * */
		
		System.out.println("ch : "+ch);
		System.out.println("ch2 : "+ch2);
		
		
		//변수 명명 규칙
		//1. 대소문자를 구분함, 길이제한 없음
		int abcdef12320594683984y7329572;
		int abcdef12320594683984Y7329572; //대소문자를 구분하기 때문에 위와 아래가 다른 변수로 인식한다
		
		//2. 변수명으로 예약어를 사용 할 수 없다
		//double, int, static, final 등등
		
		//3. 숫자로 시작하면 안됨
		//char 1abc; 안됨
		
		//4. 특수문자$와 _만 사용 가능함(쓰지 않는게 좋다~)
		int $intNumber; //->에러는 안나지만 개발자가 직접 작성하는 일은 잘 없음
		int int_Number; //자바에서 카멜표기법 사용해야함(언더바는 db에서 사용함 MEMBER_NAME)
		
		//5.카멜표기법
		char helloWorldAppleBananaTomato;
		
		//6.변수명은 언어를 가리지 않음 하지만 쓰지 않기로
		int 정수1번;
		double 실수2번=3.23;
		System.out.println(실수2번);
		//-----------------------------------------------
		
		
		final double PI_VALUE = 3.14;  //상수 선언과 초기화
		//PI_VALUE=2.33; 상수에 값 재대입 불가
		
		/*상수(항상 같은 수)
		 * -변수의 한 종류
		 * -한번 값이 대입되면 다른 값을 재대입할 수 없다
		 * -자료형 앞에 final 키워드를 써야한다
		 * 
		 * -상수 명명 규칙 : 모두 대문자, 여러 단어를 작성해야 할 때는 _(언더바) 사용
		 * -상수를 사용하는 경우
		 * 1)변하면 안되는 고정된 값을 저장할 때
		 * 2)특정한 값에 의미를 부여하는 경우 final int LEFT_MOVE = -1; 왼쪽으로 이동하는 거리 지정
		 * */
		
		System.out.println(1+1.3); //2.3 결과 잘 출력됨
		
		
	}
}
