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


	public CommunityEmailService(Model model2) {
		this.model=	model2;
	}


	public List<String> getEmailsByCityName(String city) throws Exception {
		 if(city == null || city.isEmpty()) {
				throw new Exception("city is empty or null");
			}
		List <Person> listPersons = model.getPersons();
		List <String> listEmails = new ArrayList<>();
		for (Person person : listPersons) {
			if(person.getCity().equalsIgnoreCase(city) && !listEmails.contains(person.getEmail())) {
				String email = person.getEmail();
				listEmails.add(email);
			}
		}
		// return distinct emails
		return listEmails;
	}

}
