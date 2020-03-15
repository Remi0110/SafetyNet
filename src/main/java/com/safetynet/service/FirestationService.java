package com.safetynet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.model.PersonInfo;


@Service
public class FirestationService {

	@Autowired
	private Model model;

	
	
	public List<String> getAddressStationsFromStationNumber(String stationNumber) {
		List <Firestation> listFirestation = model.getFirestations();
		List <String> address = new ArrayList<>();
		for(Firestation firestation : listFirestation) {
			if(firestation.getStation().equals(stationNumber)) {
				address.add(firestation.getAddress());
				
			}
		}
		return address;
	}
	
	public List<Person> getPersonsFromAddressStation (List <String> listAddress){
		List<Person> listPersonInfo = new ArrayList<>();
		List <Person> listPerson = model.getPersons();
		for(String address : listAddress) {
			for(Person person : listPerson) {
				if(person.getAddress().contains(address)) {
					
					listPersonInfo.add(person);
				}
			}
		}
		return listPersonInfo;
	}
		
	public PersonInfo getPersons(List<Person> listPersonInfo) {
		Integer nbAdults = 0;
		Integer nbChilds = 0;
		
		List<Person> listAdults = new ArrayList<>();
		List<Person> listChilds = new ArrayList<>();
		List<Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		for (Person person : listPersonInfo) {
			for (Medicalrecord mr : listMedicalRecord) {
				if (person.getFirstName().equals(mr.getFirstName()) && person.getLastName().equals(mr.getLastName())) {
					Long age = calculAge(mr.getBirthdate());
					if (age >= 18) {
						nbAdults++;
						Person adult = new Person();
						adult.setFirstName(person.getFirstName());
						adult.setLastName(person.getLastName());
						adult.setAddress(person.getAddress());
						adult.setPhone(person.getPhone());
						listAdults.add(adult);

					} else {
						nbChilds++;
						Person child = new Person();
						child.setFirstName(person.getFirstName());
						child.setLastName(person.getLastName());
						child.setAddress(person.getAddress());
						child.setPhone(person.getPhone());
						listChilds.add(child);

					}
				}
			}
		}

		return new PersonInfo(listAdults, nbAdults, listChilds, nbChilds);
	}
		
	
	
	
	public long calculAge (String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(date, formatter);
		long difference = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
		return difference;
	       
		
	}
}
