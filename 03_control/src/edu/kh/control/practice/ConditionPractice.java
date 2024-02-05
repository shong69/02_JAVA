package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		
		
		System.out.print("숫자를 한 개 입력하시오 : ");
		
		int input = sc.nextInt();
		if(input<0) {
			System.out.println("양수만 입력해주세요");
		}else {
			if(input%2==0) {
				System.out.println("짝수입니다.");
			}else {
				System.out.println("홀수입니다.");
			}
		}
	}
	public void practice2() {
		System.out.print("국어 점수 : ");
		int leng =sc.nextInt();
		System.out.print("수학 점수 : ");
		int math =sc.nextInt();
		System.out.print("영어 점수 : ");
		int eng =sc.nextInt();
		
		int sum = leng + math + eng;
		double avg = sum/3;
		
		if(leng>=40 && math >=40 && eng >=40) {
			if(avg>=60) {
				System.out.println("국어 : "+ leng + "\n수학 : "+ math + "\n영어 : "+eng);
				System.out.println("합계 : "+sum + "\n평균 : "+avg + "\n축하합니다, 합격입니다!");
			}else {
				System.out.println("불합격입니다.");
			}
		}else {
			System.out.println("불합격입니다.");
		}
	}
	public void practice3() {
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1,3,5,7,8,10,12: System.out.println(month +"월은 31일까지 있습니다"); break;
		case 4,6,9,11: System.out.println(month +"월은 30일까지 있습니다"); break;
		case 2: System.out.println(month+"월은 28일까지 있습니다"); break;
		default: System.out.println(month + "월은 잘못 입력된 달입니다"); break;
		}
	}
	public void practice4() {
		
		System.out.print("키(m)를 입력해 주세요 :");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)을 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double BMI = weight / (height * height);
		System.out.println("BMI 지수 : " + BMI);
		
		if(BMI < 18.5) {
			System.out.println("저체중");
		}else if(BMI <23) {
			System.out.println("정상체중");
		}else if(BMI < 25) {
			System.out.println("과체중");
		}else if(BMI < 30) {
			System.out.println("비만");
		}else {
			System.out.println("고도 비만");
		}
	}
	public void practice5() {
		System.out.print("중간고사 점수 : ");
		double midTerm = sc.nextDouble();
		System.out.print("기말고사 점수 : ");
		double finalTerm = sc.nextDouble();
		System.out.print("과제 점수 : ");
		double homework = sc.nextDouble();
		System.out.print("출석 횟수 : ");
		double attendance = sc.nextDouble();
		
		System.out.println("==============결과==============");
		
		if(attendance<=14) {
			System.out.printf("Fail [출석 횟수 부족 (%.0f/20)]",attendance);
		}else {
			midTerm*=0.2;
			finalTerm*=0.3;
			homework*=0.3;
			attendance*=0.2;
			
			double total = midTerm + finalTerm + homework + attendance;
			
			
			System.out.printf("중간 고사 점수(20) : %.1f\n",midTerm);
			System.out.printf("기말 고사 점수(30) : %.1f\n", finalTerm);
			System.out.printf("과제 점수 : %.1f\n", homework);
			System.out.printf("출석 점수 : %.1f\n", attendance);
			System.out.printf("총점 :%.1f \n", total);
			if(total >=70) {
				System.out.println("Pass");
			}else{
				System.out.println("Fail [점수 미달]");
			}
		}
		
	}

	
}
