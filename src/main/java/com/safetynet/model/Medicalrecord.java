package com.safetynet.model;

import java.util.Arrays;

public class Medicalrecord {


	private String firstName;

	private String lastName;

	private String birthdate;

	private String[] medications;

	private String[] allergies;

	public Medicalrecord() {
	}

	public Medicalrecord(String firstName, String lastName, String birthdate, String[] medications,
			String[] allergies) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String[] getMedications() {
		return medications;
	}

	public void setMedications(String[] medications) {
		this.medications = medications;
	}

	public String[] getAllergies() {
		return allergies;
	}

	public void setAllergies(String[] allergies) {
		this.allergies = allergies;
	}

	@Override
	public String toString() {
		return "Medicalrecords [firstName=" + firstName + ", lastName=" + lastName + ", birthdate=" + birthdate
				+ ", medications=" + Arrays.toString(medications) + ", allergies=" + Arrays.toString(allergies) + "]";
	}

	
}