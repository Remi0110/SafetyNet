package com.safetynet.model;

import java.util.List;

public class Model {


	private List<Person> persons;

	private List<Firestation> firestations;

	private List<Medicalrecord> medicalrecords;

	public Model() {
	}

	public Model(List<Person> persons, List<Firestation> firestations, List<Medicalrecord> medicalrecords) {
		this.persons = persons;
		this.firestations = firestations;
		this.medicalrecords = medicalrecords;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void setFirestations(List<Firestation> firestations) {
		this.firestations = firestations;
	}

	public void setMedicalrecords(List<Medicalrecord> medicalrecords) {
		this.medicalrecords = medicalrecords;
	}

	public List<Medicalrecord> getMedicalrecords() {
		return medicalrecords;
	}

	public List<Firestation> getFirestations() {
		return firestations;
	}

	@Override
	public String toString() {
		return "Model [persons=" + persons + ", medicalrecord=" + medicalrecords + ", firestations="
				+ firestations + "]";
	}
	
}
