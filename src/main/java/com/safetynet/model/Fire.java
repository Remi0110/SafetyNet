package com.safetynet.model;

import java.util.List;

public class Fire {

	private List <String> stations;
	private List <Person> persons;
	
	public Fire(List<String> stations, List<Person> persons) {
		super();
		this.stations = stations;
		this.persons = persons;
	}
	
	public List<String> getStations() {
		return stations;
	}
	public void setStations(List<String> stations) {
		this.stations = stations;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	@Override
	public String toString() {
		return "Fire [stations=" + stations + ", persons=" + persons + "]";
	}

}
