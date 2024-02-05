package edu.kh.control.practice;
import java.util.Scanner;
public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	public void practice1() {
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if(input<1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}
		for(int i = 1;i<=input;i++) {
			System.out.println(i);
		}
	}
	
	public void practice2() {
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		for(int i = input; i>=1;i--) {
			System.out.println(i);
		}
	}
	
	public void practice3() {
		System.out.println("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int sum = 0;
		for(int i = 1;i<=input;i++) {
			sum += i;
			System.out.print(i);
			if(i!=input) {
				System.out.print(" + ");
			}
		}System.out.print("= "+sum);
	}
	
	public void practice4() {
		System.out.print("첫 번째 숫자");
		int input1 = sc.nextInt();
		System.out.print("두 번째 숫자");
		int input2 = sc.nextInt();
		
		
		if(input1<1 || input2<1) {
			System.out.println("1 이상의 숫자를 입력해주세요");
		}else {
			if(input1<=input2) {
				for(int i = input1; i<=input2;i++) {
					System.out.print(i+" ");
				}
			}else {
				for(int i = input2;i<=input1;i++) {
					System.out.print(i+" ");
				}
			}
		}
	}
	
	public void practice5() {
		System.out.println("숫자 : ");
		int input = sc.nextInt();
		
		System.out.printf("=====%d단=====",input);
		System.out.println();
		
		for(int i = 1; i <= 9;i++) {
			System.out.printf("%d * %d = %d", input, i, input*i);
			System.out.println();
		}
	}
	
	public void practice6() {
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		if(input<2 || input>9) {
			System.out.println("2~9 사이 숫자만 입력해 주세요");
		}else {
			for(int st = input;st<=9;st++) {
				System.out.printf("====%d단====",input);
				System.out.println();
				for(int i = 1; i<=9;i++) {
					System.out.printf("%d X %d = %d",st,i,st*i);
					System.out.println();
				}
			}
		}
		
	}
}
