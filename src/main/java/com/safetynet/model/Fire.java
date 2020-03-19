package com.safetynet.model;

public class Fire {

	private String station;
	private Person person;
	
	
	public Fire(String station, Person person) {
		this.station = station;
		this.person = person;
	}
	
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Fire [station=" + station + ", person=" + person + "]";
	}
	
	
}
