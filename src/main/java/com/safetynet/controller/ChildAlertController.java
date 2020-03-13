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

@RequestMapping("/childAlert")
@RestController
public class ChildAlertController {
	
	@Autowired
	Model model;

	private static final Logger logger = LogManager.getRootLogger();
	
//	 @GetMapping("")
//	    public String getPersonsFromNumberStation (@RequestParam String address) {
//		 
//			return stationNumber;
//		 
//	
//	 
//	    	
//	    }
}
