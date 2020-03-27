package com.safetynet.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.ChildAlert;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class ChildAlertService {

	@Autowired
	private Model model;

	@Autowired
	private Util util;

	public ChildAlertService(Model model2, Util util2) {
		this.model = model2;
		this.util = util2;
	}

	public List<Person> getChildsFromListOfPersons(List<Person> listPersons) throws Exception {
		if (listPersons == null) {
			throw new Exception("list is empty");
		}
		List<Person> listChilds = new ArrayList<>();
		List<Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		for (Person person : listPersons) {
			for (Medicalrecord mr : listMedicalRecord) {
				if (person.getFirstName().equals(mr.getFirstName()) && person.getLastName().equals(mr.getLastName())) {
					long age = util.calculAge(mr.getBirthdate());
					person.setAge(String.valueOf(age));
					if (age <= 18) {
						Person child = new Person(person.getFirstName(), person.getLastName(), person.getAge());
						listChilds.add(child);
					}
				}
			}
		}
		return listChilds;
	}

	public ChildAlert getChildsAndMembersFamily(List<Person> listChilds, List<Person> listPersons) {
		List<Person> listMembersOfFamily = new ArrayList<>();
		List<Person> listPersonWithoutDuplicates = new ArrayList<>();

		if (!listChilds.isEmpty()) {
			for (Person child : listChilds) {
				Iterator<Person> itr = listPersons.iterator();
				while (itr.hasNext()) {
					Person person = itr.next();
					if (person.getFirstName().equals(child.getFirstName())
							&& person.getLastName().equals(child.getLastName())) {
						itr.remove();
					}
				}
			}
			for (Person child : listChilds) {
				for (Person person : listPersons) {
					if (person.getLastName().equals(child.getLastName())) {
						listMembersOfFamily.add(person);
					}
				}
			}
			listPersonWithoutDuplicates = listMembersOfFamily.stream().distinct().collect(Collectors.toList());
		} else {
			listPersonWithoutDuplicates.clear();
		}
		return new ChildAlert(listChilds, listPersonWithoutDuplicates);
	}

}
