package com.safetynet.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Model;
import com.safetynet.service.PhoneAlertService;
import com.safetynet.service.Util;

@RequestMapping("/phoneAlert")
@RestController
public class PhoneAlertController {

	@Autowired
	Model model;
	
	@Autowired
	Util util;

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private PhoneAlertService phoneAlertService;

	@GetMapping("")
	public List<String> getPhoneNumberByFirestationNumber(@RequestParam String firestation) {
		List<String> listAddress = util.getAddressStationsFromStationNumber(firestation);
		List<String> listPhoneNumber = phoneAlertService.getPhoneNumberByFirestationNumber(listAddress);
		logger.info("Request = @RequestBody = {}", firestation);
		logger.info("Response ={}", listPhoneNumber);
		
		return listPhoneNumber;

	}

}
