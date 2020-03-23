package com.safetynet.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;

@Service
public class MedicalRecordService {

	@Autowired
	private Model model;

	public MedicalRecordService(Model model2) {
		 this.model = model2;
	}

	public List<Medicalrecord> add(Medicalrecord medicalrecord) {
		List<Medicalrecord> listMedicalrecords = model.getMedicalrecords();
		listMedicalrecords.add(medicalrecord);
		return listMedicalrecords;

	}

	public List<Medicalrecord> update(Medicalrecord medicalrecord) {
		String firstname = medicalrecord.getFirstName();
		String lastName = medicalrecord.getLastName();

		List<Medicalrecord> listmedicalrecords = model.getMedicalrecords();

		for (Medicalrecord mr : listmedicalrecords) {
			// suppose that firstname and lastname can not changed
			if (mr.getFirstName().equals(firstname) && mr.getLastName().equals(lastName)) {
				mr.setBirthdate(medicalrecord.getBirthdate());
				mr.setMedications(medicalrecord.getMedications());
				mr.setAllergies(medicalrecord.getAllergies());
			}
		}
		return listmedicalrecords;

	}

	public List<Medicalrecord> delete(String firstName, String lastName) {
		List<Medicalrecord> listmedicalrecords = model.getMedicalrecords();
		Iterator<Medicalrecord> it = listmedicalrecords.iterator();
		
		while (it.hasNext()) {
			// use a combinaison of firstname and lastname for id
			Medicalrecord mr = it.next();
			if (mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
				it.remove();
			}
		
		}
		return listmedicalrecords;
	}

}
