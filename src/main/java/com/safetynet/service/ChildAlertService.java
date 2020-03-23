package com.safetynet.service;

import java.util.ArrayList;
import java.util.List;

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


	public List<Person> getPersonsFromAdress (String address) throws Exception {
		 List<Person> listPersons = model.getPersons();
		 List<Person> listPersonsFromAddress = new ArrayList<>();
		 if(address == null || address.isEmpty()) {
				throw new Exception("address is empty or null");
			}
		 String addressFormatted = address.substring(0, 1).toUpperCase() + address.substring(1);

		 for (Person person : listPersons) {
			 if(person.getAddress().contains(addressFormatted)) {					
				 listPersonsFromAddress.add(person);
				}
		 }		 
			return listPersonsFromAddress;
	    }
	
	
	public ChildAlert getChildsAndMembersFamilyFromAdress(List <Person> listPersons) throws Exception {
		 if(listPersons == null) {
				throw new Exception("la liste est vide");
			}
		List<Person> listChilds = new ArrayList<>();
		List<Person> listMembersOfFamily = new ArrayList<>();
		List<Medicalrecord> listMedicalRecord = model.getMedicalrecords();
		for(Person person : listPersons) {
		 for (Medicalrecord mr : listMedicalRecord) {
				if (person.getFirstName().equals(mr.getFirstName()) && person.getLastName().equals(mr.getLastName())) {
				  long age = util.calculAge(mr.getBirthdate());
				  person.setAge(String.valueOf(age));
				 if(age<=18) {
					 Person child = new Person (person.getFirstName(), person.getLastName(), person.getAge());
					 listChilds.add(child);
				 } else {
					 listMembersOfFamily.add(person);
				 }
			 	}
		 	}	
		}
		
		return new ChildAlert(listChilds, listMembersOfFamily);
		
	}
	

	
}
