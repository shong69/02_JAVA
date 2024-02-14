package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {
	public static void main(String[] args) {
		Employee empArr[] = new Employee[3];

		empArr[0]= new Employee();
		empArr[1]= new Employee();
		empArr[2]= new Employee();

		
		empArr[1].setEmpNo(1);
		empArr[1].setEmpName("홍길동");
		empArr[1].setAge(19);
		empArr[1].setGender('M');
		empArr[1].setAddress("서울 잠실");
		

		empArr[2].setEmpNo(2);
		empArr[2].setEmpName("강말순");
		empArr[2].setDept("교육부");
		empArr[2].setJob("강사");
		empArr[2].setAge(20);
		empArr[2].setGender('F');
		empArr[2].setSalary(1000000);
		empArr[2].setBonusPoint(0.01);
		empArr[2].setPhone("01011112222");
		empArr[2].setAddress("서울 마곡");
		

		
		System.out.println("emp[0]"+empArr[0].information());
		System.out.println("emp[1]"+empArr[1].information());
		System.out.println("emp[2]"+empArr[2].information());
		
		
		System.out.println("===============================================================");
		empArr[0].setEmpNo(0);
		empArr[0].setEmpName("김말똥");
		empArr[0].setDept("영업부");
		empArr[0].setJob("팀장");
		empArr[0].setAge(30);
		empArr[0].setGender('M');
		empArr[0].setSalary(3000000);
		empArr[0].setBonusPoint(0.2);
		empArr[0].setPhone("01055559999");
		empArr[0].setAddress("전라도 광주");
		
		empArr[1].setDept("기획부");
		empArr[1].setJob("팀장");
		empArr[1].setAge(40);
		empArr[1].setGender('M');
		empArr[1].setSalary(4000000);
		empArr[1].setBonusPoint(0.3);
		
		System.out.println("emp[0]"+empArr[0].information());
		System.out.println("emp[1]"+empArr[1].information());

		
		System.out.println("===============================================================");
		
		int emp1Sal = (int) ((empArr[0].getSalary()+empArr[0].getSalary()*empArr[0].getBonusPoint())*12);
		int emp2sal = (int) ((empArr[1].getSalary()+empArr[1].getSalary()*empArr[1].getBonusPoint())*12);
		int emp3Sal = (int) ((empArr[2].getSalary()+empArr[2].getSalary()*empArr[2].getBonusPoint())*12);

		System.out.println(empArr[0].getEmpName()+"의 연봉 : "+ emp1Sal+"원");
		
		System.out.println(empArr[1].getEmpName()+"의 연봉 : "+ emp2sal+"원");
		
		System.out.println(empArr[2].getEmpName()+"의 연봉 : "+ emp3Sal+"원");
		
		
		
		System.out.println("===============================================================");

		
		
		System.out.println("직원들의 연봉의 평균 : "+ (emp1Sal + emp2sal + emp3Sal)/3 + "원");
		
		
		

	}
}
