package com.hw2.model.service;

import com.hw2.model.dto.Person;

public interface ManagementSystem {

	void addPerson(Person person); //어차피  interface 라서 public 이나 void 는 필요 없음
	
	void removePerson(String id);
	
	void displayAllPersons();
}
