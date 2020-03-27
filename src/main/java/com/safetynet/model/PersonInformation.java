package com.safetynet.model;

import java.util.List;

public class PersonInformation {
	
	private Person person;
	private List<Person> personsWithSameLastName;
		
	public PersonInformation(Person person, List<Person> personsWithSameLastName) {
		this.person = person;
		this.personsWithSameLastName = personsWithSameLastName;
	}

	public PersonInformation() {
		
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Person> getPersonsWithSameLastName() {
		return personsWithSameLastName;
	}
	public void setPersonsWithSameLastName(List<Person> personsWithSameLastName) {
		this.personsWithSameLastName = personsWithSameLastName;
	}
	@Override
	public String toString() {
		return "PersonInformation [person=" + person + ", personsWithSameLastName=" + personsWithSameLastName + "]";
	}
	
	
}
