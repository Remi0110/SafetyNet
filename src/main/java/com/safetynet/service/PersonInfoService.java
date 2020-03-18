package com.safetynet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class PersonInfoService {

	@Autowired
	private Model model;
	
	public List<Person> getPersonByFirstNameAndLastName(String FirstName, String LastName){
		List<Person> listPersons = model.getPersons();
		List<Person> newListPersons = new ArrayList<>();
		for(Person person : listPersons) {
			if (person.getFirstName().equals(FirstName) && person.getLastName().equals(LastName) 
					|| person.getLastName().equals(LastName)) {
				newListPersons.add(person);
			}
		}
		return newListPersons;
	}
	
	public List<Person> getPersonsInformationsByFirstNameAndLastName(List<Person> listPerson){
		List <Person> newlistPerson = new ArrayList<>();
		List<Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		for (Person person : listPerson) {
			for (Medicalrecord mr : listMedicalRecord) {
				if(person.getLastName().equals(mr.getLastName()) && person.getFirstName().equals(mr.getFirstName())) {
					Long age = calculAge(mr.getBirthdate());
					Person newPerson = new Person();
					newPerson.setFirstName(mr.getFirstName());
					newPerson.setLastName(mr.getLastName());
					newPerson.setAddress(person.getAddress());
					newPerson.setAllergies(mr.getAllergies());
					newPerson.setMedications(mr.getMedications());
					newPerson.setAge(String.valueOf(age));		
					newlistPerson.add(newPerson);
				}
			}
		}
		return newlistPerson;
	}
	
	public long calculAge (String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(date, formatter);
		long difference = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
		return difference;
	       
		
	}
	
}
