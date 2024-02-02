package com.kh.variable.practice2;

import java.util.Scanner;

public class Practice2 {
	public void ex1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 하나를 입력하시오");
		char ch = sc.next().charAt(0); //chart(0) : 문자열에서 0번째 문자 출력(char 형태로 변경도 해줌)
		
		System.out.println(ch + " unicode : "+(int)ch);

	}

}
