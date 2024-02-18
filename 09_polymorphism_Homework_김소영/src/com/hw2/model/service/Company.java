package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem{

	private Employee[] employees; //전체 직원 저장용
	private int employeeCount; //직원 수
	
	public Company(int size) {
		this.employeeCount = 0;
		employees= new Employee[size];

	}

	@Override
	public void addPerson(Person person) {
		//매개변수로 전달받은 Person 객체가 Employee 클래스의 인스턴스 
		//&&배열에 공간이 있으면 추가
		
		if(person instanceof Employee && employeeCount < employees.length) {
			employees[employeeCount++] = (Employee) person; //Employee 를 괄호로 감싸는 이유는?
			System.out.println("직원이 추가되었습니다 - "+ person.getInfo());
		}else {
			System.out.println("인원이 모두 충원되어 더이상 추가할 수 없습니다.");
		}

	}

	@Override
	public void removePerson(String id) {
		for(int i = 0;i<employeeCount;i++) {
			//id일치하는 직원 찾으면 getInfo
			//없으면 없다고 syso
			if(employees[i].getId().equals(id)) {
				System.out.println("직원이 삭제되었습니다 - "+employees[i].getInfo());
				for(int j = i;j<employeeCount;j++) {
					employees[j]=employees[j+1];
				}
				employees[--employeeCount] = null;
			}return;
			
		}
		System.out.println("ID : " + id + "인 직원을 찾을 수 없습니다.");
	}

	@Override
	public void displayAllPersons() {
		for(int i = 0;i<employeeCount;i++) {
			//전체 직원 명단 출력
			System.out.println(employees[i].getInfo());
		}
	}
	

}
