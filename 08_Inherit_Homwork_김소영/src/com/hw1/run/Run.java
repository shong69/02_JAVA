package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student stArray[]= new Student[3];
		stArray[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		stArray[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		stArray[2] = new Student("강개순", 23,167.0, 45.0, 4, "정보통신공학과");

		
		/*
		for(int i = 0;i<stArray.length;i++) {
			System.out.println(stArray[i].information());
		}*/
		
		//향상된 for문
		for(Student std : stArray) {
			System.out.println(std.information());
		}
		
		System.out.println("=========================================");
		Employee empArray[] = new Employee[10];
		//사원들의 정보를 키보드로 입력받고, 추가할 것인지 물어보고
		//대소문자 상관없이 'y'면 계속 객체 추가
		//한명씩 추가될 때마다 카운트해라
		int count = -1;
		while(true) {
			count += 1;
			System.out.print("이름 : ");
			String inputName = sc.next();
			
			System.out.print("나이 : ");
			int inputAge = sc.nextInt();
			
			System.out.print("신장 : ");
			double inputHeight = sc.nextDouble();
			
			System.out.print("몸무게 : ");
			double inputWeight = sc.nextDouble();
			
			System.out.print("급여 : ");
			int inputPaycheck = sc.nextInt();
			
			System.out.print("부서 : ");
			String inputDept = sc.next();
			
	
			empArray[count] =new Employee(inputName, inputAge, inputHeight, inputWeight, inputPaycheck, inputDept);

			System.out.println("계속 추가하시겠습니까?");
			String input = sc.next().toUpperCase(); //받은게 무엇이든 대문자로 변환시켜줌
			
			if(input.equals("Y")) {
				continue;
			}else {
				
				/*//현재까지 기록된 사원들의 정보를 모두 출력하며 while문 종료
				for(int i = 0;i<=count;i++) {
					System.out.println(empArray[i].information());
				}*/
				break;
			}
			
		}
		//현재까지 기록된 사원들의 정보를 모두 출력
		for(Employee emp : empArray) {
			if(emp == null) {
				break;
			}
			System.out.println(emp.information());
				
		}//10칸 중 채워지지 않은 빈 객체 칸도 읽으려고 하면서 error발생하기 때문에 if문으로 제어하기
	}
}
