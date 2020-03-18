package com.safetynet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Fire;
import com.safetynet.model.Flood;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.FireService;
import com.safetynet.service.FloodService;

@RequestMapping("/flood")
@RestController
public class FloodController {

	@Autowired
	Model model;
	
	@Autowired
	private FloodService floodService;
	
	 @GetMapping("/stations")
	    public List<Flood> getPersonAndStationNumberByAddress (@RequestParam List<String> stations) {
		 List<String> listAddress = floodService.getAddressStationsFromStationNumber(stations);
		 List<Person> listPersons = floodService.getPersonsFromAddressStation(listAddress);
		 List<Person> listPersonsWithMedications = floodService.getPersonWithMedicationsAndAllergies(listPersons);
		 List<Flood> listFloods = floodService.uv(listPersonsWithMedications, listAddress);
		return listFloods;

	    }
	
}
