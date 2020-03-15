package com.safetynet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.safetynet.model.Model;

@Service
public class ChildAlertService {

	@Autowired
	private Model model;
	
	
//	 public String getChildsFromAdress (String address) {
//		 
//			return stationNumber;
//		 
//	
//	 
//	    	
//	    }
	
	
	
	
	
	
	public long calculAge (String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(date, formatter);
		long difference = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
		return difference;
	       
		
	}
	
}
