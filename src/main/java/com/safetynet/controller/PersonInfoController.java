package com.safetynet.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.PersonInformation;
import com.safetynet.service.PersonInfoService;

@RequestMapping("/personInfo")
@RestController
public class PersonInfoController {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private PersonInfoService personInfoService;

	@GetMapping("")
	public PersonInformation getPersonsInformationsByFirstNameAndLastName(@RequestParam String firstName,
			@RequestParam String lastName) {
		PersonInformation personInfo = personInfoService.getPersonByFirstNameAndLastName(firstName, lastName);
		PersonInformation personAndPersonsWithSameLastName = personInfoService.getPersonsInformationsByFirstNameAndLastName(personInfo);
		logger.info("Request = @RequestParam = {} + {}", firstName, lastName);
		logger.info("Response {}", personAndPersonsWithSameLastName);
		return personAndPersonsWithSameLastName;

	}
}
