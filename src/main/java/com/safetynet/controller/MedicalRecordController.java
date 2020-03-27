package com.safetynet.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.service.MedicalRecordService;

@RequestMapping("/medicalRecord")
@RestController
public class MedicalRecordController {

	@Autowired
	Model model;

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private MedicalRecordService medicalrecordService;

	@PostMapping("/add")
	public List<Medicalrecord> addMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
		List<Medicalrecord> listMedicalrecord = this.medicalrecordService.add(medicalrecord);
		logger.info("Request = @RequestBody = {}", medicalrecord);
		logger.info("Response {}", listMedicalrecord);
		
		return listMedicalrecord;
	}

	@PutMapping("/update")
	public List<Medicalrecord> updateMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
		List<Medicalrecord> listMedicalrecords = medicalrecordService.update(medicalrecord);
		logger.info("Request = @RequestBody = {}", medicalrecord);
		logger.info("Response ={}", listMedicalrecords);

		return listMedicalrecords;

	}

	@DeleteMapping("/delete")
	public List<Medicalrecord> deleteMedicalrecord(@RequestParam String firstName, @RequestParam String lastName) {
		List<Medicalrecord> listMedicalrecords = medicalrecordService.delete(firstName, lastName);
		logger.info("Request = @RequestParam = {} + {}", firstName, lastName);
		logger.info("Response ={}", listMedicalrecords);

		return listMedicalrecords;
	}

}
