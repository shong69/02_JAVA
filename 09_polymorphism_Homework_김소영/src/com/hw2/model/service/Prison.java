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
		
	}
	@Override
	public void removePerson(String id) {

		for(int i = 0;i<prisoners.length;i++) {
			//id일치하는 직원 찾으면 getInfo
			//없으면 없다고 syso
			if(prisoners[i].getId().equals(id)) {
				System.out.printf("\n직원이 삭제되었습니다 - ID : %s , 이름 : %s , 죄목 : %s",
						prisoners[i].getId(),prisoners[i].getName(), prisoners[i].getCrime());
				for(int j = i;j<prisonerCount;j++) {
					prisoners[j]=prisoners[j+1];
				}
			}break;
			
		}
	}
	@Override
	public void displayAllPersons() {
		for(int i = 0;i<prisonerCount;i++) {
			prisoners[i].getInfo();
		}		
	}

}
