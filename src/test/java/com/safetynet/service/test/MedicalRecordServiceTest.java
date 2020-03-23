package com.safetynet.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.service.MedicalRecordService;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {

	private static MedicalRecordService medicalRecordService;

	private static Model model;

	@BeforeAll
	private static void setUp() {
		model = mock(Model.class);
		medicalRecordService = new MedicalRecordService(model);
	}

	@Test
	public void testAdd() throws Exception {
		List<Medicalrecord> listMedicalrecords = new ArrayList<>();

		Medicalrecord medicalrecord1 = new Medicalrecord();
		medicalrecord1.setFirstName("Peter");
		medicalrecord1.setLastName("Duncan");
		medicalrecord1.setBirthdate("09/06/2000");
		String[] allergies = { "shellfish" };
		medicalrecord1.setAllergies(allergies);
		String[] medications = { "" };
		medicalrecord1.setMedications(medications);

		listMedicalrecords.add(medicalrecord1);

		Medicalrecord medicalrecord2 = new Medicalrecord();
		medicalrecord2.setFirstName("Reginold");
		medicalrecord2.setLastName("Walker");
		medicalrecord2.setBirthdate("08/30/1979");
		String[] allergies2 = { "illisoxian" };
		medicalrecord2.setAllergies(allergies2);
		String[] medications2 = { "thradox:700mg" };
		medicalrecord2.setMedications(medications2);

		listMedicalrecords.add(medicalrecord2);

		Medicalrecord medicalrecord3 = new Medicalrecord();
		medicalrecord3.setFirstName("Jamie");
		medicalrecord3.setLastName("Peters");
		medicalrecord3.setBirthdate("03/06/1982");
		String[] allergies3 = { "" };
		medicalrecord3.setAllergies(allergies3);
		String[] medications3 = { "" };
		medicalrecord3.setMedications(medications3);

		listMedicalrecords.add(medicalrecord3);

		Medicalrecord medicalrecord4 = new Medicalrecord();
		medicalrecord4.setFirstName("Brian");
		medicalrecord4.setLastName("Stelzer");
		medicalrecord4.setBirthdate("12/06/1975");
		String[] allergies4 = { "nillacilan" };
		medicalrecord4.setAllergies(allergies4);
		String[] medications4 = { "ibupurin:200mg", "hydrapermazol:400mg" };
		medicalrecord4.setMedications(medications4);

		listMedicalrecords.add(medicalrecord4);

		Medicalrecord medicalrecord5 = new Medicalrecord();
		medicalrecord5.setFirstName("Shawna");
		medicalrecord5.setLastName("Stelzer");
		medicalrecord5.setBirthdate("07/08/1980");
		String[] allergies5 = { "" };
		medicalrecord5.setAllergies(allergies5);
		String[] medications5 = { "" };
		medicalrecord5.setMedications(medications5);

		listMedicalrecords.add(medicalrecord5);

		Medicalrecord medicalrecord6 = new Medicalrecord();
		medicalrecord6.setFirstName("Kendrik");
		medicalrecord6.setLastName("Stelzer");
		medicalrecord6.setBirthdate("03/06/2014");
		String[] allergies6 = { "" };
		medicalrecord6.setAllergies(allergies6);
		String[] medications6 = { "noxidian:100mg", "pharmacol:2500mg" };
		medicalrecord6.setMedications(medications6);

		listMedicalrecords.add(medicalrecord6);

		assertEquals(6, listMedicalrecords.size());

		Medicalrecord newMedicalrecord = new Medicalrecord();
		newMedicalrecord.setFirstName("AAAAAA");
		newMedicalrecord.setLastName("BBBBBB");
		newMedicalrecord.setBirthdate("01/10/1987");
		String[] allergies7 = { "" };
		newMedicalrecord.setAllergies(allergies7);
		String[] medications7 = { "doliprane:100mg" };
		newMedicalrecord.setMedications(medications7);

		when(model.getMedicalrecords()).thenReturn(listMedicalrecords);
		listMedicalrecords = medicalRecordService.add(newMedicalrecord);

		assertEquals(7, listMedicalrecords.size());
		assertEquals(newMedicalrecord.getFirstName(), listMedicalrecords.get(6).getFirstName());
	}

	@Test
	public void testUpdate() throws Exception {
		List<Medicalrecord> listMedicalrecords = new ArrayList<>();
		Medicalrecord medicalrecord1 = new Medicalrecord();
		medicalrecord1.setFirstName("Peter");
		medicalrecord1.setLastName("Duncan");
		medicalrecord1.setBirthdate("09/06/2000");
		String[] allergies = { "shellfish" };
		medicalrecord1.setAllergies(allergies);
		String[] medications = { "" };
		medicalrecord1.setMedications(medications);

		listMedicalrecords.add(medicalrecord1);

		Medicalrecord medicalrecord2 = new Medicalrecord();
		medicalrecord2.setFirstName("Reginold");
		medicalrecord2.setLastName("Walker");
		medicalrecord2.setBirthdate("08/30/1979");
		String[] allergies2 = { "illisoxian" };
		medicalrecord2.setAllergies(allergies2);
		String[] medications2 = { "thradox:700mg" };
		medicalrecord2.setMedications(medications2);

		listMedicalrecords.add(medicalrecord2);

		Medicalrecord medicalrecord3 = new Medicalrecord();
		medicalrecord3.setFirstName("Jamie");
		medicalrecord3.setLastName("Peters");
		medicalrecord3.setBirthdate("03/06/1982");
		String[] allergies3 = { "" };
		medicalrecord3.setAllergies(allergies3);
		String[] medications3 = { "" };
		medicalrecord3.setMedications(medications3);

		listMedicalrecords.add(medicalrecord3);

		Medicalrecord medicalrecord4 = new Medicalrecord();
		medicalrecord4.setFirstName("Brian");
		medicalrecord4.setLastName("Stelzer");
		medicalrecord4.setBirthdate("12/06/1975");
		String[] allergies4 = { "nillacilan" };
		medicalrecord4.setAllergies(allergies4);
		String[] medications4 = { "ibupurin:200mg", "hydrapermazol:400mg" };
		medicalrecord4.setMedications(medications4);

		listMedicalrecords.add(medicalrecord4);

		Medicalrecord medicalrecord5 = new Medicalrecord();
		medicalrecord5.setFirstName("Shawna");
		medicalrecord5.setLastName("Stelzer");
		medicalrecord5.setBirthdate("07/08/1980");
		String[] allergies5 = { "" };
		medicalrecord5.setAllergies(allergies5);
		String[] medications5 = { "" };
		medicalrecord5.setMedications(medications5);

		listMedicalrecords.add(medicalrecord5);

		Medicalrecord medicalrecord6 = new Medicalrecord();
		medicalrecord6.setFirstName("Kendrik");
		medicalrecord6.setLastName("Stelzer");
		medicalrecord6.setBirthdate("03/06/2014");
		String[] allergies6 = { "" };
		medicalrecord6.setAllergies(allergies6);
		String[] medications6 = { "noxidian:100mg", "pharmacol:2500mg" };
		medicalrecord6.setMedications(medications6);

		listMedicalrecords.add(medicalrecord6);

		assertEquals("03/06/2014", listMedicalrecords.get(5).getBirthdate());

		Medicalrecord updatedMedicalrecord = new Medicalrecord();
		updatedMedicalrecord.setFirstName("Kendrik");
		updatedMedicalrecord.setLastName("Stelzer");
		updatedMedicalrecord.setBirthdate("01/10/1987");

		when(model.getMedicalrecords()).thenReturn(listMedicalrecords);
		listMedicalrecords = medicalRecordService.update(updatedMedicalrecord);

		assertEquals("01/10/1987", listMedicalrecords.get(5).getBirthdate());
	}

	@Test
	public void testDelete() throws Exception {
		List<Medicalrecord> listMedicalrecords = new ArrayList<>();
		Medicalrecord medicalrecord1 = new Medicalrecord();
		medicalrecord1.setFirstName("Peter");
		medicalrecord1.setLastName("Duncan");
		medicalrecord1.setBirthdate("09/06/2000");
		String[] allergies = { "shellfish" };
		medicalrecord1.setAllergies(allergies);
		String[] medications = { "" };
		medicalrecord1.setMedications(medications);

		listMedicalrecords.add(medicalrecord1);

		Medicalrecord medicalrecord2 = new Medicalrecord();
		medicalrecord2.setFirstName("Reginold");
		medicalrecord2.setLastName("Walker");
		medicalrecord2.setBirthdate("08/30/1979");
		String[] allergies2 = { "illisoxian" };
		medicalrecord2.setAllergies(allergies2);
		String[] medications2 = { "thradox:700mg" };
		medicalrecord2.setMedications(medications2);

		listMedicalrecords.add(medicalrecord2);

		Medicalrecord medicalrecord3 = new Medicalrecord();
		medicalrecord3.setFirstName("Jamie");
		medicalrecord3.setLastName("Peters");
		medicalrecord3.setBirthdate("03/06/1982");
		String[] allergies3 = { "" };
		medicalrecord3.setAllergies(allergies3);
		String[] medications3 = { "" };
		medicalrecord3.setMedications(medications3);

		listMedicalrecords.add(medicalrecord3);

		Medicalrecord medicalrecord4 = new Medicalrecord();
		medicalrecord4.setFirstName("Brian");
		medicalrecord4.setLastName("Stelzer");
		medicalrecord4.setBirthdate("12/06/1975");
		String[] allergies4 = { "nillacilan" };
		medicalrecord4.setAllergies(allergies4);
		String[] medications4 = { "ibupurin:200mg", "hydrapermazol:400mg" };
		medicalrecord4.setMedications(medications4);

		listMedicalrecords.add(medicalrecord4);

		Medicalrecord medicalrecord5 = new Medicalrecord();
		medicalrecord5.setFirstName("Shawna");
		medicalrecord5.setLastName("Stelzer");
		medicalrecord5.setBirthdate("07/08/1980");
		String[] allergies5 = { "" };
		medicalrecord5.setAllergies(allergies5);
		String[] medications5 = { "" };
		medicalrecord5.setMedications(medications5);

		listMedicalrecords.add(medicalrecord5);

		Medicalrecord medicalrecord6 = new Medicalrecord();
		medicalrecord6.setFirstName("Kendrik");
		medicalrecord6.setLastName("Stelzer");
		medicalrecord6.setBirthdate("03/06/2014");
		String[] allergies6 = { "" };
		medicalrecord6.setAllergies(allergies6);
		String[] medications6 = { "noxidian:100mg", "pharmacol:2500mg" };
		medicalrecord6.setMedications(medications6);

		listMedicalrecords.add(medicalrecord6);

		assertEquals(6, listMedicalrecords.size());

		when(model.getMedicalrecords()).thenReturn(listMedicalrecords);
		listMedicalrecords = medicalRecordService.delete(medicalrecord6.getFirstName(), medicalrecord6.getLastName());

		assertEquals(5, listMedicalrecords.size());
	}

}
