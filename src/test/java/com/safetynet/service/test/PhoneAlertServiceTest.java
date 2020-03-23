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

import com.safetynet.model.Firestation;
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
  	 public void testGetAddressStationsFromStationNumber() throws Exception {
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
		
		String stationNumber = "1";
		List<String> listAddress = phoneAlertService.getAddressStationsFromStationNumber(stationNumber);
		assertEquals(3, listAddress.size());
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
		assertEquals(4, listAddress.size());
    }

}
