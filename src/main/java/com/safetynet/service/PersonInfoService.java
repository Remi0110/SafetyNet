package com.safetynet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.model.PersonInformation;

@Service
public class PersonInfoService {

	@Autowired
	private Model model;
	
	@Autowired
	private Util util;
	
	
	public PersonInfoService(Model model2, Util util2) {
		 this.model = model2;
		 this.util = util2;
	}

	public PersonInformation getPersonByFirstNameAndLastName(String FirstName, String LastName){
		PersonInformation personInfo = new PersonInformation();
		List<Person> listPersons = model.getPersons();
		List<Person> ListPersonsWithSameLastName = new ArrayList<>();
		for(Person person : listPersons) {
			if (person.getFirstName().equalsIgnoreCase(FirstName) && person.getLastName().equalsIgnoreCase(LastName)){
				personInfo.setPerson(person);
				
			}else if(person.getLastName().equalsIgnoreCase(LastName)) {
				ListPersonsWithSameLastName.add(person);
			}
			
		}
		personInfo.setPersonsWithSameLastName(ListPersonsWithSameLastName);
		return new PersonInformation(personInfo.getPerson(), personInfo.getPersonsWithSameLastName());
	}
	
	
	public PersonInformation getPersonsInformationsByFirstNameAndLastName(PersonInformation personInformation) {
		PersonInformation personInfo = new PersonInformation();
		List<Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		List<Person> listPersonsWithSameFamilyName = new ArrayList<>();
		List<Person> newListPersonsWithSameFamilyName = new ArrayList<>();
		
		try
		{
		listPersonsWithSameFamilyName = personInformation.getPersonsWithSameLastName();
		String firstName = personInformation.getPerson().getFirstName();
		String lastName = personInformation.getPerson().getLastName();
		

		for (Medicalrecord mr : listMedicalRecord) {
			if (mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
				Long age = util.calculAge(mr.getBirthdate());
				Person newPerson = new Person();
				newPerson.setFirstName(mr.getFirstName());
				newPerson.setLastName(mr.getLastName());
				newPerson.setAddress(personInformation.getPerson().getAddress());
				newPerson.setAllergies(mr.getAllergies());
				newPerson.setMedications(mr.getMedications());
				newPerson.setAge(String.valueOf(age));
				personInfo.setPerson(newPerson);
			}
		}
		}catch(NullPointerException e) {
			System.out.print("Caught NullPointerException");
		}
		try {
		for (Person person : listPersonsWithSameFamilyName) {
			for (Medicalrecord mr : listMedicalRecord) {
				if (person.getLastName().equals(mr.getLastName()) && person.getFirstName().equals(mr.getFirstName())) {
					Long age = util.calculAge(mr.getBirthdate());
					Person newPerson = new Person();
					newPerson.setFirstName(mr.getFirstName());
					newPerson.setLastName(mr.getLastName());
					newPerson.setAddress(person.getAddress());
					newPerson.setAllergies(mr.getAllergies());
					newPerson.setMedications(mr.getMedications());
					newPerson.setAge(String.valueOf(age));
					newListPersonsWithSameFamilyName.add(newPerson);
				}
			}
		}
		}catch(NullPointerException e) {
			System.out.print("Caught NullPointerException");
		}
		
		personInfo.setPersonsWithSameLastName(newListPersonsWithSameFamilyName);
		return new PersonInformation(personInfo.getPerson(), personInfo.getPersonsWithSameLastName());
	}
}
