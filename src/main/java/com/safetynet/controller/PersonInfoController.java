package com.safetynet.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Person;
import com.safetynet.model.PersonInfo;
import com.safetynet.service.FirestationService;
import com.safetynet.service.PersonInfoService;

@RequestMapping("/personInfo")
@RestController
public class PersonInfoController {
	
	private static final Logger logger = LogManager.getRootLogger();

	 @Autowired
	private PersonInfoService personInfoService;
	 
	 @GetMapping("")
	    public List<Person> getPersonsInformationsByFirstNameAndLastName (@RequestParam String firstName, @RequestParam String lastName) {
		 List<Person> listPerson = personInfoService.getPersonByFirstNameAndLastName(firstName, lastName);
		 List<Person> listPersonWithInformations  = personInfoService.getPersonsInformationsByFirstNameAndLastName(listPerson);
		 return listPersonWithInformations;
	
	    }
}
