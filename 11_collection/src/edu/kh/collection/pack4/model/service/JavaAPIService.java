package edu.kh.collection.pack4.model.service;

import java.util.ArrayList;
import java.util.List;

public class JavaAPIService {

	/*
	 * -Wrapper Class
	 * 
	 * - wrap : 감싸다 포장하다
	 * - 기본 자료형을 객체로 감싸는 클래스
	 * ->기본자료형의 객체화
	 * 
	 * ->왜? 컬렉션처럼 객체만 취급하는 상황에서 기본 자료형도 취급 가능한 형태로 바꾸기 위해
	 * 		    -->Boxing
	 * Unboxing<--
	 * 
	 * boolean <--> Boolean
	 * byte <--> Byte
	 * short <--> Short
	 * int <-->Integer
	 * long <--> Long
	 * float <-->Float
	 * double <-->Double
	 * char <-->Character
	 * 
	 *  * Boxing, Unboxing을 자동으로 수행되도록 구현되어있음
	 *  -> Auto Boxing, Auto Unboxing
	 * 
	 */
	
	/**
	 * Auto Boxing, Auto Unboxing 확인
	 */
	public void method1() {
		
		
		int num1 = 100;
		//삭제 예정인 방법(쓰면안됨)
		//Integer wrap1 = new Integer(num1);
		
		
		Integer wrap1 = num1; //컴파일러가 알아서 Auto Boxing 수행코드 추가 해줌
							//(int) ->(Integer) num1
		
		int num2 = wrap1; //컴파일러가 Auto Unboxing 수행 코드 추가함
						//(Integer) wrap1 -> (int) wrap1에 저장된 값
		
		long num3 = 10_000_000_000L; //100억
		Long wrap2 = num3; //Auto Boxing
		long num4 = wrap2; //Auto Unboxing
		
		
		//Integer 객체만 저장하는 List
		List<Integer> list = new ArrayList<Integer>();
		list.add(1000); // (int) 1000 -> (Integer) 1000 / Auto Boxing
		list.add(2000);
		list.add(3000);
		
		
		//print 구문 내에서
		//wrapper 클래스로 만든 객체를 참조할 때
		//.toString()를 호출하는 것이 아닌 Auto Unboxing을 해서 기본 자료형으로 변경한다
		System.out.println(list.get(0) + list.get(1) + list.get(2)); //6000 출력
		

		
	}
	
	/**
	 * Wrapper 클래스가 제공하는 필드와 메서드
	 * -> 대부분이 static!
	 * 	  ㄴ> 클래스명.필드명 / 클래스명.메서드명() 사용
	 */
	public void method2() {
		//정수형, 실수형 공통
		System.out.println("byte의 용량 : "+ Byte.BYTES + "바이트");
		System.out.println("byte의 용량 : "+ Byte.SIZE+ "비트");
		System.out.println("byte의 최대값 : "+ Byte.MAX_VALUE);
		System.out.println("byte의 최소값 : "+ Byte.MIN_VALUE);
		
		//실수형만 사용 가능
		System.out.println(Double.NaN);
		System.out.println(Double.NEGATIVE_INFINITY); //음수 무한대 -Infinity
		System.out.println(Double.POSITIVE_INFINITY); //양수 무한대 Infinity
		
		
		//Boolean(논리형)은 true/false 밖에 없음
		System.out.println(Boolean.FALSE);
		System.out.println(Boolean.TRUE);
		
		
		System.out.println("------------------------------");
		
		System.out.println("[String -> 기본 자료형 변환]");
		//HTML 연결 시(요청 데이터 처리) 많이 사용
		//->HTML에 관련된 모든 값은 String
		
		byte b = Byte.parseByte("1");
		short s = Short.parseShort("2");
		int i = Integer.parseInt("3"); //중요
		long l = Long.parseLong("4"); //중요
		float f = Float.parseFloat("0.1");
		double d = Double.parseDouble("0.2"); //중요
		boolean bool = Boolean.parseBoolean("true");
		//char는 별도로 존재하지 않음
		
		System.out.println("-------------------------------");
		System.out.println("[기본 자료형 -> String 변환]");
		
		//String 이어쓰기를 이용한 방법
		//->코드는 짧으나 효율이 좋지 않음(속도 down,메모리 소모 up)
		long test1 = 12334567689L;
		String change1 = test1 + ""; //숫자와 문자열이 합쳐져서 문자열로 변환된다 long + String -> String
		
		//Wrapper Class를 이용하는 방법
		//->코드는 길지만 효율이 좋음
		int test2 = 400;
		String change2 = Integer.valueOf(test2).toString(); 
		
		double test3 = 4.321;
		String change3 = Double.valueOf(test3).toString();
		
		
		
	}
	/**
	 * String의 불변성 (immutubal, 변하지 않는 성질 == 상수)
	 * - 문자열이 수정되면 새로운 String객체가 생성됨
	 */
	public void method3() {
		
		//System.identityHashCode(str)
		//->주소 값을 이용해서 만든 해시코드
		//->같은 객체에 저장된 값이 변했다면 주소는 일정해야 한다
		//identityHashCode도 일정해야 한다
		
		String str = "Hello";
		System.out.println(str); //문자열 출력	
		System.out.println(System.identityHashCode(str)); // 617901222
		
		str = "world";
		System.out.println(str); //문자열 출력	
		System.out.println(System.identityHashCode(str)); 
		
		
		str += "!!!";
		System.out.println(System.identityHashCode(str)); 

		
	}
	
	
	/**
	 * String 리터럴("")로 생성된 객체 활용
	 * - 동일한 리터럴을 이용해 String 객체를 생성한 경우
	 * 추가적으로 객체를 생성하지 않고 기존의 상수풀에 존재하는 객체의 주소를 반환
	 */
	public void method4() {
		String temp1 ="Hello!!"; //temp1은 상수풀 안에 객체 하나 만들어서 "Hello!!"가 들어가 있음, 주소 0x400 참조중
		String temp2 = "Hello!!"; //같은 객체를 참조중이기 때문에 주소 같음
		
		System.out.println(System.identityHashCode(temp1));
		System.out.println(System.identityHashCode(temp2)); //두 값이 같다
		
		//객체의 필드값을 비교
		System.out.println("저장된 값 비교 : "+temp1.equals(temp2)); //true
		
		//변수의 저장된 값(주소) 비교
		System.out.println("주소를 비교 : "+(temp1 ==temp2)); //true
			
		
	}
	
	/**
	 * 사용자(개발자)가 관리하는 String객체 생성
	 * - "" 리터럴로 생성된 String -> 상수풀에 생김(JVM이 관리한다는 뜻)
	 * - new 연산자로 생성된 String -> Heap영역(사용자 관리)
	 */
	public void method5() {
		
		String temp1 = "abcd"; //리터럴로 생성 ->상수풀에 있는 객체(abcd)를 참조
		String temp2 = new String ("abcd"); //new 연산자로 생성 -> Heap 영역에 만들어진 객체를 참조
		String temp3 = new String("abcd");  //new 연산자로 생성 -> new 연산자로 만들면 똑같은 값이라도 새로운 객체를 만들어 참조한다
		//-> 셋 다 주소 값이 다르다
		
		System.out.println("temp1 : "+System.identityHashCode(temp1));
		System.out.println("temp2 : "+System.identityHashCode(temp2));
		System.out.println("temp3 : "+System.identityHashCode(temp3));
		//-> "abcd"를 재활용 하지 않음 =>값은 같지만 전부 다른 객체이다
		
		temp2 += "efg";
		System.out.println("temp2 : "+System.identityHashCode(temp2));
		//기존 temp2와는 해쉬코드가 다르다 -> heap영역에 새 객체가 다시 생김

		
	}
	
	
	
	/**
	 * StringBuilder / StringBuffer 클래스
	 * - String의 불변성 문제를 해결한 클래스
	 * -> 가변성(mutable)
	 * 
	 * -기본 16글자를 저장할 크기로 생성
	 * 	저장되는 문자열 길이에 따라 크기가 증가/감소함
	 * 	-> 마음대로 문자열 수정, 삭제 가능
	 * 	-> 수정, 삭제를 해도 추가적인 객체 생성이 없어 효율이 좋음
	 * 
	 * 
	 * - StringBuilder : Thread Safe 미제공(비동기)
	 *  : 속도면에서는 StringBuffer보다 성능이 좋음
	 *   ->멀티쓰레드 환경에서는 지양. StringBulder 사용 시 쓰레드들의 충돌 가능성이 있음
	 *   								=>글자 깨지거나 오류 발생함
	 * 	 ->단일쓰레드 환경에서 유리함(추천(자바는 스레드 추가 선언하기 전에는 단일 쓰레드를 사용중이다))
	 * 
	 * - StringBuffer : Thread Safe 제공(동기)
	 *  : 속도는 StingBuilder보다 성능 떨어짐
	 *   -> 멀티쓰레드 환경에서 안전하게 동작할 수 있음 =>멀티쓰레드환경에서 더 유리하다
	 * 
	 */
	public void method6() {
 
		//StringBuilder 객체 생성
		StringBuilder sb = new StringBuilder();
		
		//StringBuilder 객체에 문자열을 쌓아나가는 방식으로 사용한다
		// -> 뒤에 추가(append), 앞에 추가(insert)
		sb.append("오늘 점심은 "); //"오늘 점심은 "
		
		System.out.println(System.identityHashCode(sb)); //617901222
		
		sb.append("무엇을 먹을까요?"); //"오늘 점심은 무엇을 먹을까요?"
		
		System.out.println(System.identityHashCode(sb)); //617901222 -> 해쉬코드 바뀌지 않음. 같은 객체이다
		
		sb.insert(0,"2월 21일 "); //0번 인덱스에 삽입 ==제일 앞에 추가
		
		System.out.println(System.identityHashCode(sb)); //617901222 
		
		System.out.println(sb); //2월 21일 오늘 점심은 무엇을 먹을까요? 출력됨
		
		//identityHashCode 값이 일정함 == 참조하는 객체가 변하지 않음
		//==객체 내에 값만 수정되고 있다 == 가변성
		
		//StringBuilder -> String 변환
		String temp = sb.toString(); //객체에 저장된 필드를 문자열로 반환
		
		//String[] 문자열.split("구분자") : 
		// - 문자열을 "구분자"를 기준으로 쪼개서 String[]로 반환
		String[] arr = temp.split(" ");
		for( String str : arr) {
			System.out.println(str);
		}
		
		System.out.println("--------------------");
		
		//equalsIgnoreCase() : 문자열을 비교할 때 대소문자를 무시하고 비교하는 메서드
		String str1 = "hello";
		String str2 = "HELLO";
		
		if(str1.equalsIgnoreCase(str2)) {
			System.out.println("두 문자열은 동일합니다");
		}else {
			System.out.println("두 문자열은 다릅니다!");
		}

		
		
	}

	
	
	
	
	
}
