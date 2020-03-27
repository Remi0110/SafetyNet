package com.safetynet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class PhoneAlertService {

	@Autowired
	private Model model;

	public PhoneAlertService(Model model2) {
		this.model=	model2;
	}


	public List<String> getPhoneNumberByFirestationNumber(List<String> listAddress) {
		List<String> listPhoneNumber = new ArrayList<>();
		List<Person> listPerson = model.getPersons();
		for (String address : listAddress) {
			for (Person person : listPerson) {
				if (person.getAddress().contains(address) && !listPhoneNumber.contains(person.getPhone())) {

					listPhoneNumber.add(person.getPhone());
				}
			}
		}
		// return distinct phone numbers
		return listPhoneNumber;
	}

}
