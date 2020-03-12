package com.safetynet.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

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
		
	public List<Person> getPersons (List<Person> listPersonInfo){
		int nbAdults = 0;
		int nbChilds = 0;
		List <Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		for ( Person person : listPersonInfo) {
			for (Medicalrecord mr :listMedicalRecord) {
				if(person.getFirstName().equals(mr.getFirstName()) && person.getLastName().equals(mr.getLastName())) {	
					Long age = calculAge(mr.getBirthdate());
					if(age >=18) {
						nbAdults ++;
					}else {
						nbChilds ++;
					}
				}
			}
		}
		return listPersonInfo;
	}
	
	
	public long calculAge (String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(date, formatter);
		long difference = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
		return difference;
	       
		
	}
}