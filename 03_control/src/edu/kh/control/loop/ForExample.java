package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample { //기능 제공용 클래스
	Scanner sc = new Scanner(System.in);
	/*for문
	 * -끝이 정해져 있는(횟수가 지정돼있는)반복문
	 * [작성법]
	 * 
	 * for(초기식; 조건식; 증감식){
	 * 	조건식이 true라면 반복 수행할 코드
	 * }
	 * -초기식 : for문을 제어하는 용도의 변수 선언
	 * -조건식 : for문의 반복 여부를 지정하는 식. 보통 초기식에 사용된 변수를 이용하여 조건식을 작성함
	 * -증감식 : 초기식에 사용된 변수를 for문이 끝날 때마다 증가 또는 감소시켜
	 * 			조건식의 결과를 변하게 하는 식
	 * */

	
	public void ex1() {
		
		for(int i = 1;i<=10;i++) {
			System.out.println(i);
		}
	}
	public void ex2() {
		//1부터 입력받은 수까지 1씩 증가하며 출력
		
		System.out.print("수 입력 : ");
		int i = sc.nextInt();
		for(int j = 1;j<=i;j++) {
			System.out.println(j);
		}
	}
	public void ex3() {
		//영어 알파벳 A부터 Z까지 한줄로 출력
		//ABCDEF...Z
		
		//*char 자료형은 문자형이지만 실제로 정수(문자표 번호)를 저장한다
		for(int i = 65;i<91;i++) {
			System.out.printf("%c",i);
		}
		for(int i = 'A';i<='Z';i++) {
			System.out.print((char)i); //강제 형변환
		}
		for(char i ='A';i<='Z';i++) {
			System.out.println(i);
		}
	}
	public void ex4() {
		//정수 5개를 입력 받아서 합계 구하기
		
		//ex)
		//입력 1 : 10
		//입력 2 : 20
		//입력 3 : 30
		//입력 4 : 40
		//입력 5 : 50
		
		int sum =0;
		for(int i = 1;i<6; i++) {
			System.out.printf("입력%d : ",i);
			int input = sc.nextInt();
			sum += input;
		}

		System.out.println("합계 : "+ sum);
				
	
	}
	public void ex5() {
		//1부터 20까지 1씩 증가하며 출력
		//단 입력받은 수의 배수는 양쪽에 () 표시해야함
		//ex)
		//괄호를 표시할 배수 : 3
		//1 2 (3) 4 5 (6) 7 8..20으로 표시
		
		System.out.print("괄호를 표시할 배수: ");
		int input = sc.nextInt();
		
		for(int i = 1;i<=20;i++) {
			if(i%input ==0) {
				System.out.print("("+i+") ");
			}else {
				System.out.print(i+" ");
			}
		}
	}
	public void ex6() {
		//[구구단 출력]
		//2~9 사이 수를 하나 입력받아 해당 단을 출력하기
		//단, 입력받은 수가 2~9 사이가 아니면 "잘못 입력하셨습니다" 출력
		
		//단 입력 : 5
		/*5 X 1 = 5
		 *5 X 2 = 10
		 *   .
		 *   .
		 *5 X 10 = 50
		 *=========
		 *단 입력 : -2
		 *잘못 입력하셨습니다.
		 * */
		
		System.out.print("단 입력 :");
		
		int num = sc.nextInt();
		if(num<2||num>9) {
			System.out.println("잘못 입력하셨습니다");
		}else {
			for(int i = 1; i <10;i++) {
				System.out.printf("%d X %d = %d\n",num, i, num*i);
			}
		}
	}
	public void ex7() {
		//구구단 모두 출력하기
		
		for(int i = 2;i<10;i++) {
			for(int j = 1;j<10;j++) {
				System.out.printf("%d X %d = %2d ",i,j,i*j);//결과값에 자리를 2칸 주면 정렬이 이쁘게 된다
			}System.out.println();
		}
		
		//구구단 역순으로 모두 출력하기
		System.out.println("====역순 출력====");
		for(int i = 9;i>1;i--) {
			for(int j = 1;j<10;j++) {
				System.out.printf("%d X %d = %2d ",i,j,i*j);
			}System.out.println();
		}
	}
	public void ex8() {
		//숫자 세기 count
		
		//1부터 20까지 1씩 증가하면서 입력받은 수의 배수의 총 개수를 출력하기
		//입력받은 수의 배수의 합계 출력하기
		
		//배수 입력 : 3
		//3 6 9 12 15 18 : 6개
		//3의 배수 합계 : 63
		
		
		System.out.print("배수 입력 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		int cnt = 0;
		for(int i=1;i<=20;i++) {
			if(i%num == 0) {
				cnt += 1;
				sum += i;
				System.out.print(i+ " ");
			}
		}
		System.out.println(": "+cnt + "개");
		System.out.printf("%d의 배수 합계 : %d", num, sum);
	}
	
	
}


















