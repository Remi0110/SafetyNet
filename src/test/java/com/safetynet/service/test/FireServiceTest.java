package com.safetynet.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.model.Fire;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.FireService;
import com.safetynet.service.Util;

@ExtendWith(MockitoExtension.class)
public class FireServiceTest {

	
	private static FireService fireService;
	
    private static Model model;
	
    private static Util util;
    
    @BeforeAll
    private static void setUp() {
    	 model = mock(Model.class);
    	 util = mock(Util.class);
    	 fireService = new FireService(model, util);
    }
    
	@Test
	 public void testGetPersonsFromAdress () throws Exception {
		List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("John");
		person1.setLastName("Boyd");
		person1.setAddress("1509 Culver St");
	
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Jacob");
		person2.setLastName("Boyd");
		person2.setAddress("1509 Culver St");

		listPersons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Tenley");
		person3.setLastName("Boyd");
		person3.setAddress("1509 Culver St");
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Roger");
		person4.setLastName("Boyd");
		person4.setAddress("1509 Culver St");
	
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Felicia");
		person5.setLastName("Boyd");
		person5.setAddress("1509 Culver St");
	
		listPersons.add(person5);
				
		when(model.getPersons()).thenReturn(listPersons);
		
		String address = "1509 Culver St";
		List <Person> listPersonResult = fireService.getPersonsFromAdress(address);
		assertNotNull(listPersonResult);
		assertEquals(5, listPersonResult.size());
	    }
	
	@Test
	 public void testGetPersonWithMedicationsAndAllergies () throws Exception {
		List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("John");
		person1.setLastName("Boyd");
		person1.setAddress("1509 Culver St");
	
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Jacob");
		person2.setLastName("Boyd");
		person2.setAddress("1509 Culver St");

		listPersons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Tenley");
		person3.setLastName("Boyd");
		person3.setAddress("1509 Culver St");
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Roger");
		person4.setLastName("Boyd");
		person4.setAddress("1509 Culver St");
	
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Felicia");
		person5.setLastName("Boyd");
		person5.setAddress("1509 Culver St");
	
		listPersons.add(person5);
		
		List<Medicalrecord> listMedicalrecords = new ArrayList<>();
		
		Medicalrecord medicalrecord1 = new Medicalrecord();
		medicalrecord1.setFirstName("John");
		medicalrecord1.setLastName("Boyd");
		medicalrecord1.setBirthdate("03/06/1984");
		String[] allergies = {"nillacilan"};
		medicalrecord1.setAllergies(allergies);
		String[] medications = {"aznol:350mg", "hydrapermazol:100mg"};
		medicalrecord1.setMedications(medications);
		
		listMedicalrecords.add(medicalrecord1);
		
		Medicalrecord medicalrecord2 = new Medicalrecord();
		medicalrecord2.setFirstName("Jacob");
		medicalrecord2.setLastName("Boyd");
		medicalrecord2.setBirthdate("03/06/1989");
		String[] allergies2 = {""};
		medicalrecord2.setAllergies(allergies2);
		String[] medications2 = {"pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"};
		medicalrecord2.setMedications(medications2);
		
		listMedicalrecords.add(medicalrecord2);
		
		Medicalrecord medicalrecord3 = new Medicalrecord();
		medicalrecord3.setFirstName("Tenley");
		medicalrecord3.setLastName("Boyd");
		medicalrecord3.setBirthdate("02/18/2012");
		String[] allergies3 = {"peanut"};
		medicalrecord3.setAllergies(allergies3);
		String[] medications3 = {""};
		medicalrecord3.setMedications(medications3);
		
		listMedicalrecords.add(medicalrecord3);
		
		Medicalrecord medicalrecord4 = new Medicalrecord();
		medicalrecord4.setFirstName("Roger");
		medicalrecord4.setLastName("Boyd");
		medicalrecord4.setBirthdate("09/06/2017");
		String[] allergies4 = {""};
		medicalrecord4.setAllergies(allergies4);
		String[] medications4 = {""};
		medicalrecord4.setMedications(medications4);
		
		listMedicalrecords.add(medicalrecord4);
		
		Medicalrecord medicalrecord5 = new Medicalrecord();
		medicalrecord5.setFirstName("Felicia");
		medicalrecord5.setLastName("Boyd");
		medicalrecord5.setBirthdate("01/08/1986");
		String[] allergies5 = {"xilliathal"};
		medicalrecord5.setAllergies(allergies5);
		String[] medications5 = {"tetracyclaz:650mg"};
		medicalrecord5.setMedications(medications5);
		
		listMedicalrecords.add(medicalrecord5);
				
		when(model.getMedicalrecords()).thenReturn(listMedicalrecords);
		when(util.calculAge(Mockito.anyString())).thenCallRealMethod();

		
		List <Person> listPersonResult = fireService.getPersonWithMedicationsAndAllergies(listPersons);
		assertNotNull(listPersonResult);
		assertEquals(5, listPersonResult.size());
		assertEquals(medicalrecord1.getAllergies(), listPersonResult.get(0).getAllergies());
	    }
    
	@Test
	 public void testgetPersonAndStationNumberByAddress () throws Exception {
		List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("John");
		person1.setLastName("Boyd");
		person1.setAddress("1509 Culver St");
		person1.setCity("Culver");
		person1.setZip("97451");
		person1.setPhone("841-874-6512");
		person1.setEmail("jaboyd@email.com");
		person1.setAge("36");
		String[] allergies = {"nillacilan"};
		person1.setAllergies(allergies);
		String[] medications = {"aznol:350mg", "hydrapermazol:100mg"};
		person1.setMedications(medications);
		
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Jacob");
		person2.setLastName("Boyd");
		person2.setAddress("1509 Culver St");
		person2.setCity("Culver");
		person2.setZip("97451");
		person2.setPhone("841-874-6513");
		person2.setEmail("drk@email.com");
		person2.setAge("31");
		String[] allergies2 = {""};
		person2.setAllergies(allergies2);
		String[] medications2 = {"pharmacol:5000mg", "terazine:10mg", "noznazol:250mg"};
		person2.setMedications(medications2);

		listPersons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Tenley");
		person3.setLastName("Boyd");
		person3.setAddress("1509 Culver St");
		person3.setCity("Culver");
		person3.setZip("97451");
		person3.setPhone("841-874-6512");
		person3.setEmail("tenz@email.com");
		person3.setAge("8");
		String[] allergies3 = {"peanut"};
		person3.setAllergies(allergies3);
		String[] medications3 = {""};
		person3.setMedications(medications3);
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Roger");
		person4.setLastName("Boyd");
		person4.setAddress("1509 Culver St");
		person4.setCity("Culver");
		person4.setZip("97451");
		person4.setPhone("841-874-6512");
		person4.setEmail("jaboyd@email.com");
		person4.setAge("2");
		String[] allergies4 = {""};
		person4.setAllergies(allergies4);
		String[] medications4 = {""};
		person4.setMedications(medications4);
	
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Felicia");
		person5.setLastName("Boyd");
		person5.setAddress("1509 Culver St");
		person5.setCity("Culver");
		person5.setZip("97451");
		person5.setPhone("841-874-6544");
		person5.setEmail("jaboyd@email.com");
		person5.setAge("34");
		String[] allergies5 = {"xilliathal"};
		person5.setAllergies(allergies5);
		String[] medications5 = {"tetracyclaz:650mg"};
		person5.setMedications(medications5);
	
		listPersons.add(person5);
		
		List<Firestation> listFirestation = new ArrayList<>();
		
		Firestation firestation = new Firestation();
		firestation.setAddress("1509 Culver St");
		firestation.setStation("3");
		
		listFirestation.add(firestation);
		
		Firestation firestation2 = new Firestation();
		firestation2.setAddress("29 15th St");
		firestation2.setStation("2");
		
		listFirestation.add(firestation2);
				
		when(model.getFirestations()).thenReturn(listFirestation);
		
		List <Fire> listPersonResult = fireService.getPersonAndStationNumberByAddress(listPersons);
		assertNotNull(listPersonResult);
		assertEquals(5, listPersonResult.size());
		assertEquals("3", listPersonResult.get(0).getStation());
		assertEquals("3", listPersonResult.get(1).getStation());
		assertEquals("3", listPersonResult.get(2).getStation());
		assertEquals("3", listPersonResult.get(3).getStation());
		assertEquals("3", listPersonResult.get(4).getStation());
	    }
   
	
}
