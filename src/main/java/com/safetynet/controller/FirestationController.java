package com.safetynet.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Firestation;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.model.PersonInfo;
import com.safetynet.service.FirestationService;
import com.safetynet.service.Util;

@RequestMapping("/firestation")
@RestController
public class FirestationController {

	@Autowired
	Model model;
	
	@Autowired
	Util util;

	@Autowired
	private FirestationService fireService;
	
	private static final Logger logger = LogManager.getRootLogger();


	@GetMapping("")
	public PersonInfo getPersonsFromNumberStation(@RequestParam String stationNumber) {

		List<String> address = util.getAddressStationsFromStationNumber(stationNumber);
		List<Person> listPerson = util.getPersonsFromAddressStation(address);
		PersonInfo personInfo = fireService.getPersons(listPerson);
		logger.info("Request = @RequestBody = {}", stationNumber);
		logger.info("Response {}", personInfo.toString());
		return personInfo;
	}

	@PostMapping("/add")
	public List<Firestation> addFirestation(@RequestBody Firestation firestation) {
		List<Firestation> listFirestations = this.fireService.add(firestation);
		logger.info("Request = @RequestBody = {}", firestation);
		logger.info("Response {}", listFirestations);
		return listFirestations;
	}

	@PutMapping("/update")
	public List<Firestation> updateFirestation(@RequestBody Firestation firestation) {

		List<Firestation> listFirestations = fireService.update(firestation);

		logger.info("Request = @RequestBody = {}", firestation);
		logger.info("Response ={}", listFirestations);

		return listFirestations;
	}

	@DeleteMapping("/delete")
	public List<Firestation> deleteFirestation(@RequestBody Firestation firestation) {
		List<Firestation> listFirestations = fireService.delete(firestation);
		logger.info("Request = @RequestParam = {} + {}", firestation);
		logger.info("Response ={}", listFirestations);

		return listFirestations;
	}

}
