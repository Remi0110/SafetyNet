package com.safetynet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.ChildAlert;
import com.safetynet.model.Fire;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.ChildAlertService;
import com.safetynet.service.FireService;

@RequestMapping("/fire")
@RestController
public class FireController {
	
	@Autowired
	Model model;
	
	@Autowired
	private FireService fireService;

	 @GetMapping("")
	    public List<Fire> getPersonAndStationNumberByAddress (@RequestParam String address) {
		 List<Person> listPersonsFromAddress = fireService.getPersonsFromAdress(address);
		 List<Person> listPersonWithMedicationsAndAllergies = fireService.getPersonWithMedicationsAndAllergies(listPersonsFromAddress);
		 List<Fire> listPersonWithStationAndMedicationsAllergies = fireService.getPersonAndStationNumberByAddress(listPersonWithMedicationsAndAllergies);
	
		return listPersonWithStationAndMedicationsAllergies;

	    }
}
