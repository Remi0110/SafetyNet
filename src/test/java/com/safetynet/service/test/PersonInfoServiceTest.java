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

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.model.PersonInformation;
import com.safetynet.service.PersonInfoService;
import com.safetynet.service.Util;

@ExtendWith(MockitoExtension.class)
public class PersonInfoServiceTest {

	private static PersonInfoService personInfoService;
	
    private static Model model;
	
    private static Util util;
	
    @BeforeAll
    private static void setUp() {
    	 model = mock(Model.class);
    	 util = mock(Util.class);
    	 personInfoService = new PersonInfoService(model, util);
    }
    
    @Test
	 public void testGetPersonByFirstNameAndLastName () throws Exception {
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
		
		Person person6 = new Person();
		person6.setFirstName("Allison");
		person6.setLastName("Boyd");
		person6.setAddress("112 Steppes Pl");
	
		listPersons.add(person6);
    	
		Person person7 = new Person();
		person7.setFirstName("Jonanathan");
		person7.setLastName("Marrack");
		person7.setAddress("29 15th St");
	
		listPersons.add(person7);
		
		assertEquals(7, listPersons.size());
		
		when(model.getPersons()).thenReturn(listPersons);
		PersonInformation personInformation = personInfoService.getPersonByFirstNameAndLastName(person2.getFirstName(), person2.getLastName());
	
		assertEquals(person2.getFirstName(), personInformation.getPerson().getFirstName());
		assertEquals(5, personInformation.getPersonsWithSameLastName().size());
    }
    
    @Test
	 public void testGetPersonsInformationsByFirstNameAndLastName () throws Exception {
    	List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("John");
		person1.setLastName("Boyd");
		person1.setAddress("1509 Culver St");
		person1.setCity("Culver");
		person1.setZip("97451");
		person1.setPhone("841-874-6512");
		person1.setEmail("jaboyd@email.com");
		
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Jacob");
		person2.setLastName("Boyd");
		person2.setAddress("1509 Culver St");
		person2.setCity("Culver");
		person2.setZip("97451");
		person2.setPhone("841-874-6513");
		person2.setEmail("drk@email.com" );


		Person person3 = new Person();
		person3.setFirstName("Tenley");
		person3.setLastName("Boyd");
		person3.setAddress("1509 Culver St");
		person3.setCity("Culver");
		person3.setZip("97451");
		person3.setPhone("841-874-6512");
		person3.setEmail("tenz@email.com");
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Roger");
		person4.setLastName("Boyd");
		person4.setAddress("1509 Culver St");
		person4.setCity("Culver");
		person4.setZip("97451");
		person4.setPhone("841-874-6512");
		person4.setEmail("jaboyd@email.com");
			
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Felicia");
		person5.setLastName("Boyd");
		person5.setAddress("1509 Culver St");
		person5.setCity("Culver");
		person5.setZip("97451");
		person5.setPhone("841-874-6544");
		person5.setEmail("jaboyd@email.com");
	
		listPersons.add(person5);
		
		Person person6 = new Person();
		person6.setFirstName("Allison");
		person6.setLastName("Boyd");
		person6.setAddress("112 Steppes Pl");
		person6.setCity("Culver");
		person6.setZip("97451");
		person6.setPhone("841-874-9888");
		person6.setEmail("aly@imail.com");
		
		listPersons.add(person6);
		
		PersonInformation personInformation = new PersonInformation();
		personInformation.setPerson(person2);
		personInformation.setPersonsWithSameLastName(listPersons);
    	
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
		
		Medicalrecord medicalrecord6 = new Medicalrecord();
		medicalrecord6.setFirstName("Allison");
		medicalrecord6.setLastName("Boyd");
		medicalrecord6.setBirthdate("03/15/1965");
		String[] allergies6 = {"nillacilan"};
		medicalrecord6.setAllergies(allergies6);
		String[] medications6 = {"aznol:200mg"};
		medicalrecord6.setMedications(medications6);
		
		listMedicalrecords.add(medicalrecord6);
		
		Medicalrecord medicalrecord7 = new Medicalrecord();
		medicalrecord7.setFirstName("Zach");
		medicalrecord7.setLastName("Zemicks");
		medicalrecord7.setBirthdate("03/06/2017");
		String[] allergies7 = {""};
		medicalrecord7.setAllergies(allergies7);
		String[] medications7 = {""};
		medicalrecord7.setMedications(medications7);
		
		listMedicalrecords.add(medicalrecord7);
		
		when(model.getMedicalrecords()).thenReturn(listMedicalrecords);
		when(util.calculAge(Mockito.anyString())).thenCallRealMethod();
		
		PersonInformation personInformationResult= personInfoService.getPersonsInformationsByFirstNameAndLastName(personInformation);
		assertNotNull(personInformationResult);
		assertEquals(person2.getFirstName(), personInformationResult.getPerson().getFirstName());
		assertNotNull(personInformationResult.getPerson().getAge());
		assertEquals(5, personInformation.getPersonsWithSameLastName().size());
    }
   
    
}
