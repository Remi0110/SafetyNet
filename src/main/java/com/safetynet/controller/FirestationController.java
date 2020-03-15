package com.safetynet.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.model.PersonInfo;
import com.safetynet.service.FirestationService;

@RequestMapping("/firestation")
@RestController
public class FirestationController {
	
	@Autowired
	Model model;

	private static final Logger logger = LogManager.getRootLogger();
	
	 @Autowired
	private FirestationService fireService;
	 
	 @GetMapping("")
	    public PersonInfo getPersonsFromNumberStation (@RequestParam String stationNumber) {
		 
		 List<String> address = fireService.getAddressStationsFromStationNumber(stationNumber);
		 List<Person> listPerson = fireService.getPersonsFromAddressStation(address);
		 PersonInfo personInfo = fireService.getPersons(listPerson);
		  logger.info("Request = @RequestBody = {}", stationNumber);
		  logger.info("Response {}", personInfo.toString());
		 return personInfo;
//		  Gson gson = new GsonBuilder()
//		            .serializeNulls()
//		            .disableHtmlEscaping()
//		            .setPrettyPrinting()
//		            .create();
//		return gson.toJson(personInfo);
	 
	    	
	    }
	 
	

}
