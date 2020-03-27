package com.safetynet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class Util {

	@Autowired
	private Model model;

	public Util(Model model2) {
		this.model = model2;
	}

	public Util() {

	}

	public long calculAge(String date) {
		if (date == null) {
			throw new NullPointerException("le paramètre d'entrée ne peut pas être null");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(date, formatter);
		long difference = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
		return difference;
	}

	public List<Person> getPersonsFromAdress(String address) throws Exception {
		List<Person> listPersons = model.getPersons();
		List<Person> listPersonsFromAddress = new ArrayList<>();
		if (address == null || address.isEmpty()) {
			throw new Exception("address is empty or null");
		}
		for (Person person : listPersons) {
			if (person.getAddress().equalsIgnoreCase(address)) {
				listPersonsFromAddress.add(person);
			}
		}
		return listPersonsFromAddress;
	}
	
	public List<Person> getPersonsFromAddressStation(List<String> listAddress) {
		List<Person> listPersonInfo = new ArrayList<>();
		List<Person> listPerson = model.getPersons();
		for (String address : listAddress) {
			for (Person person : listPerson) {
				if (person.getAddress().contains(address)) {
					listPersonInfo.add(person);
				}
			}
		}
		return listPersonInfo;
	}
	
	public List<Person> getPersonWithMedicationsAndAllergies(List<Person> listPersons) {
		List<Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		List<Person> listPersonWithMedicationsAndAllergies = new ArrayList<>();
		for (Person person : listPersons) {
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
	
	public List<String> getAddressStationsFromStationNumber(String stationNumber) {
		List<Firestation> listFirestation = model.getFirestations();
		List<String> address = new ArrayList<>();
		for (Firestation firestation : listFirestation) {
			if (firestation.getStation().equals(stationNumber) && !address.contains(firestation.getAddress())) {
				address.add(firestation.getAddress());
			}
		}
		return address;
	}

}
