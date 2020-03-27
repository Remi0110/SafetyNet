package com.safetynet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Firestation;
import com.safetynet.model.Flood;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class FloodService {

	@Autowired
	private Model model;

	@Autowired
	private Util util;

	public FloodService(Model model2, Util util2) {
		 this.model = model2;
		 this.util = util2;
	}

	public List<String> getAddressStationsFromStationNumber(List<String> stations) {
		List<Firestation> listFirestation = model.getFirestations();
		List<String> listAddress = new ArrayList<>();
		for (String station : stations) {
			for (Firestation firestation : listFirestation) {
				if (station.equals(firestation.getStation()) && !listAddress.contains(firestation.getAddress())) {
					listAddress.add(firestation.getAddress());
				}
			}
		}
		return listAddress;
	}


	public List<Flood> getListPersonByAddress(List<Person> listPersons, List<String> listAddress) {
		List<Flood> listFloods = new ArrayList<>();
		for (String address : listAddress) {
			List<Person> listPersonsByAddress = new ArrayList<>();
			for (Person person : listPersons) {
				if (person.getAddress().equals(address)) {
					listPersonsByAddress.add(new Person(person.getLastName(),
							person.getPhone(), person.getAge(), person.getMedications(), person.getAllergies()));
				}
			}
			Flood flood = new Flood(address, listPersonsByAddress);
			listFloods.add(flood);
		}
		return listFloods;
	}

}