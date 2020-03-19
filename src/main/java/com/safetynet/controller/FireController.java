package com.safetynet.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Fire;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.FireService;

@RequestMapping("/fire")
@RestController
public class FireController {

	@Autowired
	Model model;

	@Autowired
	private FireService fireService;
	
	private static final Logger logger = LogManager.getRootLogger();

	@GetMapping("")
	public List<Fire> getPersonAndStationNumberByAddress(@RequestParam String address) {
		List<Person> listPersonsFromAddress = fireService.getPersonsFromAdress(address);
		List<Person> listPersonWithMedicationsAndAllergies = fireService
				.getPersonWithMedicationsAndAllergies(listPersonsFromAddress);
		List<Fire> listPersonWithStationAndMedicationsAllergies = fireService
				.getPersonAndStationNumberByAddress(listPersonWithMedicationsAndAllergies);
		logger.info("Request = @RequestBody = {}", address);
		logger.info("Response {}", listPersonWithStationAndMedicationsAllergies);
		return listPersonWithStationAndMedicationsAllergies;

	}
}
