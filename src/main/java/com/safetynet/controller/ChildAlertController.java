package com.safetynet.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.ChildAlert;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.ChildAlertService;

@RequestMapping("/childAlert")
@RestController
public class ChildAlertController {

	@Autowired
	Model model;

	@Autowired
	private ChildAlertService childAlertService;

	private static final Logger logger = LogManager.getRootLogger();

	@GetMapping("")
	public ChildAlert getChildsFromAdress(@RequestParam String address) {

		List<Person> listPerson = childAlertService.getPersonsFromAdress(address);
		ChildAlert childAlert = childAlertService.getChildsAndMembersFamilyFromAdress(listPerson);
		logger.info("Request = @RequestBody = {}", address);
		logger.info("Response {}", childAlert.toString());
		return childAlert;

	}
}
