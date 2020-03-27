package com.safetynet.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	@Autowired
	private Util util;

	public FirestationService(Model model2, Util util2) {
		 this.model = model2;
		 this.util = util2;
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
					Long age = util.calculAge(mr.getBirthdate());
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

	public List<Firestation> add(Firestation firestation) {
		List<Firestation> listFirestations = model.getFirestations();
		listFirestations.add(firestation);
		return listFirestations;

	}

	public List<Firestation> update(Firestation firestation) {

		String address = firestation.getAddress();
		String station = firestation.getStation();
		List<Firestation> listFirestations = model.getFirestations();

		for (Firestation fs : listFirestations) {
			if (fs.getAddress().equals(address)) {
				fs.setStation(station);
			}
		}
		return listFirestations;
	}

	public List<Firestation> delete(Firestation firestation) {
		List<Firestation> listFirestations = model.getFirestations();
		Iterator<Firestation> it = listFirestations.iterator();

		String address = firestation.getAddress();

		while (it.hasNext()) {
			Firestation fs = it.next();
			if (fs.getAddress().equals(address)) {
				it.remove();
			}
		}
		return listFirestations;
	}

}
