package com.safetynet.model;

import java.util.List;

public class Flood {

	private String address;
	private List <Person> persons;
	
	public Flood(String address, List<Person> persons) {
		this.address = address;
		this.persons = persons;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Flood [address=" + address + ", persons=" + persons + "]";
	}
	
	
	
	
}
