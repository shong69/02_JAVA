package com.hw2.run;

import com.hw2.model.service.ManagementSystem;
import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;
import com.hw2.model.service.Company;
import com.hw2.model.service.Prison;

public class Run {
	public static void main(String[] args) {
		ManagementSystem cp = new Company(10);
		ManagementSystem pr =new Prison(10); //size로 10칸 넘어감
		
		cp.addPerson(new Employee("EMP001", "유재석","기획팀"));
		cp.addPerson(new Employee("EMP002", "정형돈","개발팀"));
		
		//등록된 전체 직원 조회
		cp.displayAllPersons();

		
		System.out.println("=============================================");
		
		//2명 수감자 새로 등록
		pr.addPerson(new Prisoner("1205", "정준하", "밥도둑"));
		pr.addPerson(new Prisoner("0705","박명수","웃음연쇄살인"));
		
		//등록된 전체 수감자 조회
		pr.displayAllPersons();

		
		System.out.println("=============================================");

		//EMP001 id 를 가진 직원 삭제
		cp.removePerson("EMP001");
		//1205 id를 가진 수감자 삭제
		pr.removePerson("1205");
		
		
		System.out.println("=============================================");

		
		//현재 남은 직원 모두 조회
		cp.displayAllPersons();
		//현재 남은 수감자 모두 조회
		pr.displayAllPersons();
	}
}
