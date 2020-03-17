package com.safetynet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.safetynet.model.ChildAlert;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class ChildAlertService {

	@Autowired
	private Model model;
	
	
	 public List<Person> getPersonsFromAdress (String address) {
		 List<Person> listPersons = model.getPersons();
		 List<Person> listPersonsFromAddress = new ArrayList<>();
		 for (Person person : listPersons) {
			 if(person.getAddress().contains(address)) {					
				 listPersonsFromAddress.add(person);
				}
		 }		 
			return listPersonsFromAddress;
	    }
	
	
	public ChildAlert getChildsAndMembersFamilyFromAdress(List <Person> listPersons) {
		List<Person> listChilds = new ArrayList<>();
		List<Person> listMembersOfFamily = new ArrayList<>();
		List<Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		for(Person person : listPersons) {
		 for (Medicalrecord mr : listMedicalRecord) {
				if (person.getFirstName().equals(mr.getFirstName()) && person.getLastName().equals(mr.getLastName())) {
				  long age = calculAge(mr.getBirthdate());
				  person.setAge(String.valueOf(age));
				 if(age<=18) {
					 Person child = new Person (person.getFirstName(), person.getLastName(), person.getAge());
					 listChilds.add(child);
				 } else {
					 listMembersOfFamily.add(person);
				 }
			 	}
		 	}	
		}
		
		return new ChildAlert(listChilds, listMembersOfFamily);
		
	}
	
	
	
	public long calculAge (String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(date, formatter);
		long difference = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
		return difference;
	       
		
	}
	
}
