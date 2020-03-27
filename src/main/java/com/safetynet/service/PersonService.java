package com.safetynet.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class PersonService {
	
	@Autowired
	private Model model;

	public PersonService(Model model2) {
		 this.model = model2;
	}


	public List<Person> update(Person person) {
		String firstname = person.getFirstName();
		String lastName = person.getLastName();

		List<Person> listPersons = model.getPersons();

		for (Person p : listPersons) {
			// suppose that firstname and lastname can not changed
			if (p.getFirstName().equals(firstname) && p.getLastName().equals(lastName)) {
				p.setAddress(person.getAddress());
				p.setCity(person.getCity());
				p.setZip(person.getZip());
				p.setPhone(person.getPhone());
				p.setEmail(person.getEmail());
			}
		}
		return listPersons;

	}

	public List<Person> add(Person person) {
		List<Person> listPersons = model.getPersons();
		listPersons.add(person);
		return listPersons;

	}

	public List<Person> delete(String firstName, String lastName) {
		List<Person> listPersons = model.getPersons();
		Iterator<Person> it = listPersons.iterator();
		
		while (it.hasNext()) {
			// use a combinaison of firstname and lastname for id
			Person person = it.next();
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				it.remove();
			}
		
		}
		return listPersons;
	}

}
