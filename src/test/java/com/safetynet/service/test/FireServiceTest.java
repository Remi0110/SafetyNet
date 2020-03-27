package com.safetynet.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.model.Fire;
import com.safetynet.model.Firestation;
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
	 public void testGetPersonAndStationNumberByAddress () throws Exception {
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
		
		Fire Result = fireService.getPersonAndStationNumberByAddress(listPersons);
		assertNotNull(Result);
		assertTrue(Result.getStations().contains("3"));
		assertEquals(5, Result.getPersons().size());

	    }
   

	@Test
	 public void testGetPersonAndStationNumberByAddressWithStationWithTwoStationNumber () throws Exception {
		List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("Tony");
		person1.setLastName("Cooper");
		person1.setAddress("112 Steppes Pl");
		person1.setCity("Culver");
		person1.setZip("97451");
		person1.setPhone("841-874-6874");
		person1.setEmail("tcoop@ymail.com");
		person1.setAge("34");
		String[] allergies = {"shellfish"};
		person1.setAllergies(allergies);
		String[] medications = {"hydrapermazol:300mg", "dodoxadin:30mg"};
		person1.setMedications(medications);
		
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Ron");
		person2.setLastName("Peters");
		person2.setAddress("112 Steppes Pl");
		person2.setCity("Culver");
		person2.setZip("97451");
		person2.setPhone("841-874-8888");
		person2.setEmail("jpeter@email.com");
		person2.setAge("12");
		String[] allergies2 = {""};
		person2.setAllergies(allergies2);
		String[] medications2 = {""};
		person2.setMedications(medications2);
		
		listPersons.add(person2);
		
		Person person3 = new Person();
		person3.setFirstName("Allison");
		person3.setLastName("Boyd");
		person3.setAddress("112 Steppes Pl");
		person3.setCity("Culver");
		person3.setZip("97451");
		person3.setPhone("841-874-9888");
		person3.setEmail("aly@imail.com");
		person3.setAge("19");
		String[] allergies3 = {"nillacilan"};
		person3.setAllergies(allergies3);
		String[] medications3 = {"aznol:200mg"};
		person3.setMedications(medications3);
		
		listPersons.add(person3);
		
		List<Firestation> listFirestation = new ArrayList<>();
    	
		Firestation firestation = new Firestation();
		firestation.setAddress("1509 Culver St");
		firestation.setStation("3");
		
		listFirestation.add(firestation);
		
		Firestation firestation2 = new Firestation();
		firestation2.setAddress("29 15th St");
		firestation2.setStation("2");
		
		listFirestation.add(firestation2);

		Firestation firestation3 = new Firestation();
		firestation3.setAddress("834 Binoc Ave");
		firestation3.setStation("3");
		
		listFirestation.add(firestation3);
		
		Firestation firestation4 = new Firestation();
		firestation4.setAddress("644 Gershwin Cir");
		firestation4.setStation("1");
		
		listFirestation.add(firestation4);
		
		Firestation firestation5 = new Firestation();
		firestation5.setAddress("748 Townings Dr");
		firestation5.setStation("3");
		
		listFirestation.add(firestation5);
		
		Firestation firestation6 = new Firestation();
		firestation6.setAddress("112 Steppes Pl");
		firestation6.setStation("3");
		
		listFirestation.add(firestation6);
		
		Firestation firestation7 = new Firestation();
		firestation7.setAddress("489 Manchester St");
		firestation7.setStation("4");
		
		listFirestation.add(firestation7);
		
		Firestation firestation8 = new Firestation();
		firestation8.setAddress("892 Downing Ct");
		firestation8.setStation("2");
		
		listFirestation.add(firestation8);
		
		Firestation firestation9 = new Firestation();
		firestation9.setAddress("908 73rd St");
		firestation9.setStation("1");
		
		listFirestation.add(firestation9);
		
		Firestation firestation10 = new Firestation();
		firestation10.setAddress("112 Steppes Pl");
		firestation10.setStation("4");
		
		listFirestation.add(firestation10);
		
		Firestation firestation11 = new Firestation();
		firestation11.setAddress("947 E. Rose Dr");
		firestation11.setStation("1");
		
		listFirestation.add(firestation11);
		
		Firestation firestation12 = new Firestation();
		firestation12.setAddress("748 Townings Dr");
		firestation12.setStation("3");
		
		listFirestation.add(firestation12);
		
		Firestation firestation13 = new Firestation();
		firestation13.setAddress("951 LoneTree Rd");
		firestation13.setStation("2");
		
		listFirestation.add(firestation13);
		
		when(model.getFirestations()).thenReturn(listFirestation);
		Fire Result = fireService.getPersonAndStationNumberByAddress(listPersons);
		assertNotNull(Result);
		assertTrue(Result.getStations().contains("3"));
		assertTrue(Result.getStations().contains("4"));
		assertEquals(3, Result.getPersons().size());
	}
	
}
