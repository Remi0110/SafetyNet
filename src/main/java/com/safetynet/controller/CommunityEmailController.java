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
import com.safetynet.service.CommunityEmailService;

@RequestMapping("/communityEmail")
@RestController
public class CommunityEmailController {

	@Autowired
	Model model;

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private CommunityEmailService communityEmailService;

	@GetMapping("")
	public List<String> getEmailsByCityName(@RequestParam String city) throws Exception {

		List<String> listEmails = communityEmailService.getEmailsByCityName(city);
		logger.info("Request = @RequestBody = {}", city);
		logger.info("Response {}", listEmails);
		return listEmails;
	}

}
