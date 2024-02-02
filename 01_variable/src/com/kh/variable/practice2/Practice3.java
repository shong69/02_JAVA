package com.kh.variable.practice2;

import java.util.Scanner;

public class Practice3 {
	
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 과목의 점수를 입력하시오");
		double input1 = sc.nextDouble();
		
		System.out.print("영어 과목의 점수를 입력하시오");
		double input2 = sc.nextDouble();

		System.out.print("수항 과목의 점수를 입력하시오");
		double input3 = sc.nextDouble();

		double result = (input1 + input2 + input3)/3 ;
		System.out.printf("총점은 %d 평균은 %d 입니다.",(int)( input1 + input2 + input3), result);
	}

	public void ex3() {
		//sc.next()와 sc.nextLine()의 차이
		
		//next() : 띄어쓰기 입력 불가. 띄어쓰기를 구분인자로 생각하여 각각 저장함
		//nextLine() : 문자열에 띄어쓰기 가능. 줄구분까지 저장한다
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 1 : ");
		String input1 = sc.nextLine();
		
		System.out.print("문자열 입력 2 : ");
		String input2 = sc.next();
		
		System.out.println(input1);
		System.out.println(input2);
	}


	public void ex4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input1 = sc.nextInt();
		
		System.out.println(input1);
		
		sc.nextLine(); //입력 버퍼에 남은 개행문자 제거
		
		System.out.print("문자열 입력 : ");
		String input2 = sc.nextLine(); //문자열 입력이 되지 않음->입력 버퍼 때문
		System.out.println(input2);
		
		//정수 입력 후 enter 눌렀기 때문에 입력 버퍼에는 1\n가 들어갔지만 빠져나갈 때는 1만 빠져나감
		//그 다음 nextLine이 들어가면서 \n을 먼저 내보내고 입력받을 기회를 날려버렸다
		//->입력버퍼에 남은 개행문자 제거 후 nextLine을 사용하면 문제 x
		
		
		
	}



}
