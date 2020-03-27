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
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.PhoneAlertService;

@ExtendWith(MockitoExtension.class)
public class PhoneAlertServiceTest {
	
	private static PhoneAlertService phoneAlertService;

    private static Model model;
    
    @BeforeAll
    private static void setUp() {
    	 model = mock(Model.class);
    	 phoneAlertService = new PhoneAlertService(model);
    }
    
    @Test
 	 public void testgetPhoneNumberByFirestationNumber() throws Exception {
    	List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("Peter");
		person1.setLastName("Duncan");
		person1.setAddress("644 Gershwin Cir");
		person1.setPhone("841-874-6512");
		
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Reginold");
		person2.setLastName("Walker");
		person2.setAddress("908 73rd St");
		person2.setPhone("841-874-8547");

		listPersons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Jamie");
		person3.setLastName("Peters");
		person3.setAddress("908 73rd St");
		person3.setPhone("841-874-7462");
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Brian");
		person4.setLastName("Stelzer");
		person4.setAddress("947 E. Rose Dr");
		person4.setPhone("841-874-7784");
	
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Shawna");
		person5.setLastName("Stelzer");
		person5.setAddress("947 E. Rose Dr");
		person5.setPhone("841-874-7784");
	
		listPersons.add(person5);
		
		Person person6 = new Person();
		person6.setFirstName("Kendrik");
		person6.setLastName("Stelzer");
		person6.setAddress("947 E. Rose Dr");
		person6.setPhone("841-874-7784");
		person6.setEmail("bstel@email.com");
		
		listPersons.add(person6);
		
		Person person7 = new Person();
		person7.setFirstName("John");
		person7.setLastName("Boyd");
		person7.setAddress("1509 Culver St");
		person7.setPhone("841-874-6512");
		
		listPersons.add(person7);
		
		Person person8 = new Person();
		person8.setFirstName("Jacob");
		person8.setLastName("Boyd");
		person8.setAddress("1509 Culver St");
		person8.setPhone("841-874-6513");
		
		listPersons.add(person8);
    	
    	List<String> listAdress = new ArrayList<>();
		listAdress.add("644 Gershwin Cir");
		listAdress.add("908 73rd St");
		listAdress.add("947 E. Rose Dr");
		
		when(model.getPersons()).thenReturn(listPersons);
		
		List<String> listAddress = phoneAlertService.getPhoneNumberByFirestationNumber(listAdress);
		
		assertNotNull(listAddress);
		// return distinct phone number
		assertEquals(4, listAddress.size());
    }

}
