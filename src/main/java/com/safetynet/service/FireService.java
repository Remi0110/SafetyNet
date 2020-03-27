package com.safetynet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Fire;
import com.safetynet.model.Firestation;
import com.safetynet.model.Model;
import com.safetynet.model.Person;

@Service
public class FireService {

	@Autowired
	private Model model;

	@Autowired
	private Util util;

	public FireService(Model model2, Util util2) {
		this.model = model2;
		this.util = util2;
	}

	public Fire getPersonAndStationNumberByAddress(List<Person> listPersonWithMedicationsAndAllergies) {
		List<Person> listPersonWithStationAndMedicationsAllergies = new ArrayList<>();
		List<String> listStations = new ArrayList<>();
		List<Firestation> listFirestations = model.getFirestations();
		for (Person person : listPersonWithMedicationsAndAllergies) {
			for (Firestation firestation : listFirestations) {
				if (person.getAddress().equals(firestation.getAddress())) {
					String station = firestation.getStation();
					if (!listStations.contains(station)) {
						listStations.add(station);
					}
					listPersonWithStationAndMedicationsAllergies.add(person);
				}
			}
		}
		List<Person> listPersonWithoutDuplicates = listPersonWithStationAndMedicationsAllergies.stream().distinct()
				.collect(Collectors.toList());
		listPersonWithStationAndMedicationsAllergies.clear();
		for (Person person : listPersonWithoutDuplicates) {
			listPersonWithStationAndMedicationsAllergies.add(new Person(person.getLastName(), person.getPhone(),
					person.getAge(), person.getMedications(), person.getAllergies()));
		}
		return new Fire(listStations, listPersonWithStationAndMedicationsAllergies);
	}

}
