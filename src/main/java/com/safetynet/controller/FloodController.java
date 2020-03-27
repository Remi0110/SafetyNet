package com.safetynet.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Flood;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.FloodService;
import com.safetynet.service.Util;

@RequestMapping("/flood")
@RestController
public class FloodController {

	@Autowired
	Model model;
	
	@Autowired
	Util util;

	@Autowired
	private FloodService floodService;

	private static final Logger logger = LogManager.getRootLogger();

	@GetMapping("/stations")
	public List<Flood> getPersonAndStationNumberByAddress(@RequestParam List<String> stations) {
		List<String> listAddress = floodService.getAddressStationsFromStationNumber(stations);
		List<Person> listPersons = util.getPersonsFromAddressStation(listAddress);
		List<Person> listPersonsWithMedications = util.getPersonWithMedicationsAndAllergies(listPersons);
		List<Flood> listFloods = floodService.getListPersonByAddress(listPersonsWithMedications, listAddress);
		logger.info("Request = @RequestBody = {}", stations);
		logger.info("Response {}", listFloods);
		
		return listFloods;

	}

}
