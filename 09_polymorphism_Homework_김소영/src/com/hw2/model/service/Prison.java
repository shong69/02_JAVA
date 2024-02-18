package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem{

	private Prisoner[] prisoners; //전체 수용자 저장용
	private int prisonerCount; //수용자 수
	
	public Prison() {}
	public Prison(int size) {
		this.prisonerCount = 0;
		prisoners= new Prisoner[size];

	}
	@Override
	public void addPerson(Person person) {
		if(person instanceof Prisoner && prisonerCount <prisoners.length) {
			prisoners[prisonerCount++] = (Prisoner) person;
			System.out.println("수감자가 추가되었습니다 - "+person.getInfo());
		}else {
			System.out.println("수용소가 만실 상태여서 더이상 추가할 수 없습니다.");
		}
	}
	@Override
	public void removePerson(String id) {

		for(int i = 0;i<prisonerCount;i++) {
			//id일치하는 직원 찾으면 getInfo
			//없으면 없다고 syso
			if(prisoners[i].getId().equals(id)) {
				System.out.println("수감자가 삭제되었습니다 - "+prisoners[i].getInfo());
				for(int j = i;j<prisonerCount;j++) {
					prisoners[j]=prisoners[j+1];
				}
				prisoners[--prisonerCount] = null;
			}return;
		}
		System.out.println("ID : "+id + "인 수감자를 찾을 수 없습니다");
	}
	@Override
	public void displayAllPersons() {
		for(int i = 0;i<prisonerCount;i++) {
			System.out.println(prisoners[i].getInfo());
		}		
	}

}
