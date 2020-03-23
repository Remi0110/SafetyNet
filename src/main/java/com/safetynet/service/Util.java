package com.safetynet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class Util {
	

	public long calculAge (String date) {
		if(date == null) {
			throw new NullPointerException("le paramètre d'entrée ne peut pas être null");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(date, formatter);
		long difference = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
		return difference;
	       
		
	}

}
