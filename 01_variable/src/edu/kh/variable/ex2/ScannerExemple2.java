package edu.kh.variable.ex2;

import java.util.Scanner;
public class ScannerExemple2 {
	public static void main(String[] args) {
		//사칙연산 계산기 만들기
		//->두 실수를 입력받아 사칙연산 결과를 모두 출력해라
		//->단, 출력된 결과값은 소수점 이하 둘째자리까지만 표현해라
		//정수 : sc.nextInt();
		//실수 : sc.nextDouble();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("실수 하나를 입력하시오 : ");
		double input1 = sc.nextDouble();
		
		System.out.print("실수 하나를 입력하시오 : ");
		double input2 = sc.nextDouble();
		
		System.out.printf("%.2d + %.2d =%.2d\n", input1, input2, input1 + input2);
		System.out.printf("%.2d - %.2d =%.2d\n", input1, input2, input1 - input2);
		System.out.printf("%.2d * %.2d =%.2d\n", input1, input2, input1 * input2);
		System.out.printf("%.2d / %.2d =%.2d\n", input1, input2, input1 / input2);

	}
}
