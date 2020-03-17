package com.safetynet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Fire;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class FireService {
	

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
	 
	 public List<Person> getPersonWithMedicationsAndAllergies (List<Person> listPersons){
		 List<Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		 List <Person> listPersonWithMedicationsAndAllergies = new ArrayList<>();
			for(Person person : listPersons) {
				 for (Medicalrecord mr : listMedicalRecord) {
						if (person.getFirstName().equals(mr.getFirstName()) && person.getLastName().equals(mr.getLastName())) {
						  long age = calculAge(mr.getBirthdate());
						  String[] medications = mr.getMedications();
						  String[] allergies = mr.getAllergies();
						  person.setAge(String.valueOf(age));
						  person.setAllergies(allergies);
						  person.setMedications(medications);
						  listPersonWithMedicationsAndAllergies.add(person);
					 	}
				 	}	
			}
			return listPersonWithMedicationsAndAllergies;
	 }
	 
	 public List<Fire> getPersonAndStationNumberByAddress (List <Person> listPersonWithMedicationsAndAllergies){
		 List <Fire> listPersonWithStationAndMedicationsAllergies = new ArrayList<>();
			List<Firestation> listFirestations = model.getFirestations();
			for(Person person : listPersonWithMedicationsAndAllergies) {
				 for (Firestation firestation : listFirestations) {
						if (person.getAddress().equals(firestation.getAddress()) ) {
							String station =firestation.getStation();
							listPersonWithStationAndMedicationsAllergies.add(new Fire(station,new Person(person.getLastName(),person.getPhone(), person.getAge(), person.getMedications(), person.getAllergies())));	
					 	}
				 	}	
				}
			return listPersonWithStationAndMedicationsAllergies;
	 }
	
		public long calculAge (String date) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate birthDate = LocalDate.parse(date, formatter);
			long difference = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
			return difference;
		       
			
		}
	 
}
