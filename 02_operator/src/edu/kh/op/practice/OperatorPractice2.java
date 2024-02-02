package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice2 {
	public void ex1() {
		/* 나이를 입력받는다
		 * 성인이면->저는 성인입니다
		 * 미성년자면->저는 미성년입니다.
		 * 13살 이상이고 19살 미만인지 묻고 맞으면 true, 아니면 false 출력
		 * 12살 미만이거나 65살 이상인지 묻고 맞으면 true 아니면 false 출력 */
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요(숫자만) : ");
		int age = sc.nextInt();
		boolean adult = age >=20;
		System.out.println(adult?"저는 성인입니다":"저는 미성년입니다");
		
		boolean teenage = age>=13&&age<=19;
		boolean oldOryoung = age>=65 || age<=12;
		System.out.println("청소년입니까? "+teenage);
		System.out.println("노인이거나 어린이 입니까? " +oldOryoung);
	}
}
