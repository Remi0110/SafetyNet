package com.safetynet.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.model.ChildAlert;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.ChildAlertService;
import com.safetynet.service.Util;

@ExtendWith(MockitoExtension.class)
public class ChildAlertServiceTest {
   
	private static ChildAlertService childAlertService;

	
    private static Model model;
		
    private static Util util;
    
    @BeforeAll
    private static void setUp() {
    	 model = mock(Model.class);
    	 util = mock(Util.class);
    	childAlertService = new ChildAlertService(model, util);
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
		person2.setFirstName("Roger");
		person2.setLastName("Boyd");
		person2.setAddress("1509 Culver St");

		listPersons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Jonanathan");
		person3.setLastName("Marrack");
		person3.setAddress("29 15th St");

		listPersons.add(person3);
				
		when(model.getPersons()).thenReturn(listPersons);
		
		String address = "1509 Culver St";
		List <Person> listPersonResult = childAlertService.getPersonsFromAdress(address);
		assertNotNull(listPersonResult);
		assertEquals(2, listPersonResult.size());
	    }
	
	@Test
	 public void testGetPersonsFromAdressWithListNull () {
		List<Person> listPersons = new ArrayList<>();
		listPersons = null;
		
				
		when(model.getPersons()).thenReturn(listPersons);
		
		String address = "1509 Culver St";
		 assertThrows(
				  Exception.class,
		            ()->childAlertService.getPersonsFromAdress(address));
	    }
	
	@Test
	 public void testGetPersonsFromAdressWithNullValue (){
		List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("John");
		person1.setLastName("Boyd");
		person1.setAddress("1509 Culver St");
	
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Roger");
		person2.setLastName("Boyd");
		person2.setAddress("1509 Culver St");

		listPersons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Jonanathan");
		person3.setLastName("Marrack");
		person3.setAddress("29 15th St");

		listPersons.add(person3);
				
		when(model.getPersons()).thenReturn(listPersons);
			
		String address = null;
		assertThrows(
				  Exception.class,
		            ()->childAlertService.getPersonsFromAdress(address));
	    }
	    
	@Test
	 public void testgetChildsAndMembersFamilyFromAdress () throws Exception {
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
		
		listMedicalrecords.add(medicalrecord1);
		
		Medicalrecord medicalrecord2 = new Medicalrecord();
		medicalrecord2.setFirstName("Jacob");
		medicalrecord2.setLastName("Boyd");
		medicalrecord2.setBirthdate("03/06/1989");
		
		listMedicalrecords.add(medicalrecord2);
		
		Medicalrecord medicalrecord3 = new Medicalrecord();
		medicalrecord3.setFirstName("Tenley");
		medicalrecord3.setLastName("Boyd");
		medicalrecord3.setBirthdate("02/18/2012");
		
		listMedicalrecords.add(medicalrecord3);
		
		Medicalrecord medicalrecord4 = new Medicalrecord();
		medicalrecord4.setFirstName("Roger");
		medicalrecord4.setLastName("Boyd");
		medicalrecord4.setBirthdate("09/06/2017");
		
		listMedicalrecords.add(medicalrecord4);
		
		Medicalrecord medicalrecord5 = new Medicalrecord();
		medicalrecord5.setFirstName("Felicia");
		medicalrecord5.setLastName("Boyd");
		medicalrecord5.setBirthdate("01/08/1986");
		
		listMedicalrecords.add(medicalrecord5);
				
		when(model.getMedicalrecords()).thenReturn(listMedicalrecords);
		when(util.calculAge(Mockito.anyString())).thenCallRealMethod();
		
		ChildAlert childAlert= childAlertService.getChildsAndMembersFamilyFromAdress(listPersons);
		assertNotNull(childAlert);
		assertEquals(2, childAlert.getChilds().size());
	    }
	
	@Test
	 public void testgetChildsAndMembersFamilyFromAdressWithNullValue () throws Exception {
		
		List<Medicalrecord> listMedicalrecords = new ArrayList<>();
		
		Medicalrecord medicalrecord1 = new Medicalrecord();
		medicalrecord1.setFirstName("John");
		medicalrecord1.setLastName("Boyd");
		medicalrecord1.setBirthdate("03/06/1984");
		
		listMedicalrecords.add(medicalrecord1);
		
		Medicalrecord medicalrecord2 = new Medicalrecord();
		medicalrecord2.setFirstName("Jacob");
		medicalrecord2.setLastName("Boyd");
		medicalrecord2.setBirthdate("03/06/1989");
		
		listMedicalrecords.add(medicalrecord2);
		
		Medicalrecord medicalrecord3 = new Medicalrecord();
		medicalrecord3.setFirstName("Tenley");
		medicalrecord3.setLastName("Boyd");
		medicalrecord3.setBirthdate("02/18/2012");
		
		listMedicalrecords.add(medicalrecord3);
		
		Medicalrecord medicalrecord4 = new Medicalrecord();
		medicalrecord4.setFirstName("Roger");
		medicalrecord4.setLastName("Boyd");
		medicalrecord4.setBirthdate("09/06/2017");
		
		listMedicalrecords.add(medicalrecord4);
		
		Medicalrecord medicalrecord5 = new Medicalrecord();
		medicalrecord5.setFirstName("Felicia");
		medicalrecord5.setLastName("Boyd");
		medicalrecord5.setBirthdate("01/08/1986");
		
		listMedicalrecords.add(medicalrecord5);
				
		when(model.getMedicalrecords()).thenReturn(listMedicalrecords);
		
		List<Person> listPersons = null;
		assertThrows(
				  Exception.class,
		            ()->childAlertService.getChildsAndMembersFamilyFromAdress(listPersons));
	    
	    }
	
}
