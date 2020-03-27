package com.safetynet.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
	 public void testGetChildsFromListOfPersons () throws Exception {
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
		
		List <Person> listChilds= childAlertService.getChildsFromListOfPersons(listPersons);
		assertNotNull(listChilds);
		assertEquals(2, listChilds.size());
	    }
	
	@Test
	 public void testGetChildsFromListOfPersonsWithNullValue () throws Exception {
		
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
		            ()->childAlertService.getChildsFromListOfPersons(listPersons));
	    }
	
	@Test
	 public void testGetChildsAndMembersFamily () throws Exception {
		List<Person> listChilds = new ArrayList<>();

		Person person1 = new Person();
		person1.setFirstName("Tenley");
		person1.setLastName("Boyd");
	
		listChilds.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Roger");
		person2.setLastName("Boyd");
	
		listChilds.add(person2);
		
		Person person3 = new Person();
		person3.setFirstName("Zach");
		person3.setLastName("Zemicks");
	
		listChilds.add(person3);
		
		List<Person> listPersons = new ArrayList<>();
		
		Person person4 = new Person();
		person4.setFirstName("John");
		person4.setLastName("Boyd");
		
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Jacob");
		person5.setLastName("Boyd");
		
		listPersons.add(person5);
		
		Person person6 = new Person();
		person6.setFirstName("Felicia");
		person6.setLastName("Boyd");
		
		listPersons.add(person6);
		
		Person person7 = new Person();
		person7.setFirstName("Sophia");
		person7.setLastName("Zemicks");
		
		listPersons.add(person7);
		
		Person person8 = new Person();
		person8.setFirstName("Warren");
		person8.setLastName("Zemicks");
		
		listPersons.add(person8);
		
		Person person9 = new Person();
		person9.setFirstName("Eric");
		person9.setLastName("Cadigan");
		
		listPersons.add(person9);
		
		Person person10 = new Person();
		person10.setFirstName("Tenley");
		person10.setLastName("Boyd");
	
		listPersons.add(person10);
		
		Person person11 = new Person();
		person11.setFirstName("Roger");
		person11.setLastName("Boyd");
	
		listPersons.add(person11);
		
		Person person12 = new Person();
		person12.setFirstName("Zach");
		person12.setLastName("Zemicks");
	
		listPersons.add(person12);
		
		ChildAlert childAlert= childAlertService.getChildsAndMembersFamily(listChilds, listPersons);
		assertNotNull(childAlert);
		assertEquals(3, childAlert.getChilds().size());
		assertEquals(5, childAlert.getMembersOfFamily().size());
	}
	
	@Test
	 public void testGetChildsAndMembersFamilyWithListOfChildsIsEmpty () throws Exception {
		List<Person> listChilds = new ArrayList<>();
		
		List<Person> listPersons = new ArrayList<>();
		
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Boyd");
		
		listPersons.add(person);
		
		Person person2 = new Person();
		person2.setFirstName("Jacob");
		person2.setLastName("Boyd");
		
		listPersons.add(person2);
		
		Person person3 = new Person();
		person3.setFirstName("Felicia");
		person3.setLastName("Boyd");
		
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Sophia");
		person4.setLastName("Zemicks");
		
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Warren");
		person5.setLastName("Zemicks");
		
		listPersons.add(person5);
		
		Person person6 = new Person();
		person6.setFirstName("Eric");
		person6.setLastName("Cadigan");
		
		listPersons.add(person6);
		
		ChildAlert childAlert= childAlertService.getChildsAndMembersFamily(listChilds, listPersons);
		assertTrue(childAlert.getChilds().isEmpty());
		assertTrue(childAlert.getMembersOfFamily().isEmpty());
	}
	
}
