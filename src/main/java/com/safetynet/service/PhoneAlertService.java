package com.safetynet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Firestation;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class PhoneAlertService {

	@Autowired
	private Model model;

	public List<String> getAddressStationsFromStationNumber(String firestation) {
		List<Firestation> listFirestation = model.getFirestations();
		List<String> address = new ArrayList<>();
		for (Firestation fs : listFirestation) {
			if (fs.getStation().equals(firestation)) {
				address.add(fs.getAddress());

			}
		}
		return address;
	}

	public List<String> getPhoneNumberByFirestationNumber(List<String> listAddress) {
		List<String> listPhoneNumber = new ArrayList<>();
		List<Person> listPerson = model.getPersons();
		for (String address : listAddress) {
			for (Person person : listPerson) {
				if (person.getAddress().contains(address)) {

					listPhoneNumber.add(person.getPhone());
				}
			}
		}
		return listPhoneNumber;
	}

}
