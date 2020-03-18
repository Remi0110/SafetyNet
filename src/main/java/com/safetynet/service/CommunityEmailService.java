package com.safetynet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class CommunityEmailService {

	@Autowired
	private Model model;


	public List<String> getEmailsByCityName(String city) {
		List <Person> listPersons = model.getPersons();
		List <String> listEmails = new ArrayList<>();
		for (Person person : listPersons) {
			if(person.getCity().equals(city)) {
				String email = person.getEmail();
				listEmails.add(email);
			}
		}
		return listEmails;
	}

}
