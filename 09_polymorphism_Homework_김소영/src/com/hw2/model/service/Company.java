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
		
		if(person) {
				
			}
		/*System.out.printf("직원이 추가되었습니다 - ID : %s , 이름 : %s , 직책 : ",
				employees[i].getId(),employees[i].getName(),employees[i].getPosition());*/

	}

	@Override
	public void removePerson(String id) {
		for(int i = 0;i<employees.length;i++) {
			//id일치하는 직원 찾으면 getInfo
			//없으면 없다고 syso
			if(employees[i].getId().equals(id)) {
				System.out.printf("\n직원이 삭제되었습니다 - ID : %s , 이름 : %s , 직책 : %s",
						employees[i].getId(),employees[i].getName(), employees[i].getPosition());
				for(int j = i;j<employeeCount;j++) {
					employees[j]=employees[j+1];
				}
			}break;
			
		}
	}

	@Override
	public void displayAllPersons() {
		for(int i = 0;i<employeeCount;i++) {
			//전체 직원 명단 출력
			employees[i].getInfo();
		}
	}
	

}
