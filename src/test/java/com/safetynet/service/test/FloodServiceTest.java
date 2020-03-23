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

import com.safetynet.model.Firestation;
import com.safetynet.model.Flood;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.FloodService;
import com.safetynet.service.Util;

@ExtendWith(MockitoExtension.class)
public class FloodServiceTest {

private static FloodService floodService;
	
    private static Model model;
	
    private static Util util;
    
    
    @BeforeAll
    private static void setUp() {
    	 model = mock(Model.class);
    	 util = mock(Util.class);
    	 floodService = new FloodService(model, util);
    }
    
    @Test
	 public void testGetAddressStationsFromStationNumber () throws Exception {
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
		
		List<String> stations = new ArrayList<>();
		stations.add("1");
		stations.add("2");
		
		when(model.getFirestations()).thenReturn(listFirestation);
		
		List<String> listAddresss= floodService.getAddressStationsFromStationNumber(stations);
		assertEquals(6, listAddresss.size());	
    }
    
    @Test
	 public void testGetPersonsFromAddressStation () throws Exception {   	
    	List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("Peter");
		person1.setLastName("Duncan");
		person1.setAddress("644 Gershwin Cir");
		person1.setCity("Culver");
		person1.setZip("97451");
		person1.setPhone("841-874-6512");
		person1.setEmail("jaboyd@email.com");
		String[] allergies = {"shellfish"};
		person1.setAllergies(allergies);
		String[] medications = {""};
		person1.setMedications(medications);
		
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Reginold");
		person2.setLastName("Walker");
		person2.setAddress("908 73rd St");
		person2.setCity("Culver");
		person2.setZip("97451");
		person2.setPhone("841-874-8547");
		person2.setEmail("reg@email.com");
		String[] allergies2 = {"illisoxian"};
		person2.setAllergies(allergies2);
		String[] medications2 = {"thradox:700mg"};
		person2.setMedications(medications2);

		listPersons.add(person2);
		
		Person person3 = new Person();
		person3.setFirstName("Jamie");
		person3.setLastName("Peters");
		person3.setAddress("908 73rd St");
		person3.setCity("Culver");
		person3.setZip("97451");
		person3.setPhone("841-874-7462");
		person3.setEmail("jpeter@email.com");
		String[] allergies3 = {""};
		person3.setAllergies(allergies3);
		String[] medications3 = {""};
		person3.setMedications(medications3);
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Brian");
		person4.setLastName("Stelzer");
		person4.setAddress("947 E. Rose Dr");
		person4.setCity("Culver");
		person4.setZip("97451");
		person4.setPhone("841-874-7784");
		person4.setEmail("bstel@email.com");
		String[] allergies4 = {"nillacilan"};
		person4.setAllergies(allergies4);
		String[] medications4 = {"ibupurin:200mg","hydrapermazol:400mg"};
		person4.setMedications(medications4);
			
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Shawna");
		person5.setLastName("Stelzer");
		person5.setAddress("947 E. Rose Dr");
		person5.setCity("Culver");
		person5.setZip("97451");
		person5.setPhone("841-874-7784");
		person5.setEmail("ssanw@email.com");
		String[] allergies5 = {""};
		person5.setAllergies(allergies5);
		String[] medications5 = {""};
		person5.setMedications(medications5);
	
		listPersons.add(person5);
		
		Person person6 = new Person();
		person6.setFirstName("Kendrik");
		person6.setLastName("Stelzer");
		person6.setAddress("947 E. Rose Dr");
		person6.setCity("Culver");
		person6.setZip("97451");
		person6.setPhone("841-874-7784");
		person6.setEmail("bstel@email.com");
		String[] allergies6 = {""};
		person6.setAllergies(allergies6);
		String[] medications6 = {"noxidian:100mg", "pharmacol:2500mg"};
		person6.setMedications(medications6);
		
		listPersons.add(person6);
		
		Person person7 = new Person();
		person7.setFirstName("Jonanathan");
		person7.setLastName("Marrack");
		person7.setAddress("29 15th St");
		person7.setCity("Culver");
		person7.setZip("97451");
		person7.setPhone("841-874-6513");
		person7.setEmail("drk@email.com");
		String[] allergies7 = {""};
		person7.setAllergies(allergies7);
		String[] medications7 = {""};
		person7.setMedications(medications7);
		
		listPersons.add(person7);
		
		Person person8 = new Person();
		person8.setFirstName("Sophia");
		person8.setLastName("Zemicks");
		person8.setAddress("892 Downing Ct");
		person8.setCity("Culver");
		person8.setZip("97451");
		person8.setPhone("841-874-7878");
		person8.setEmail("soph@email.com");
		String[] allergies8 = {"peanut", "shellfish", "aznol"};
		person8.setAllergies(allergies8);
		String[] medications8 = {"aznol:60mg", "hydrapermazol:900mg", "pharmacol:5000mg", "terazine:500mg"};
		person8.setMedications(medications8);
		
		listPersons.add(person8);
		
		Person person9 = new Person();
		person9.setFirstName("Warren");
		person9.setLastName("Zemicks");
		person9.setAddress("892 Downing Ct");
		person9.setCity("Culver");
		person9.setZip("97451");
		person9.setPhone("841-874-7512");
		person9.setEmail("ward@email.com");
		String[] allergies9 = {""};
		person9.setAllergies(allergies9);
		String[] medications9 = {""};
		person9.setMedications(medications9);
		
		listPersons.add(person9);
		
		Person person10 = new Person();
		person10.setFirstName("Zach");
		person10.setLastName("Zemicks");
		person10.setAddress("892 Downing Ct");
		person10.setCity("Culver");
		person10.setZip("97451");
		person10.setPhone("841-874-7512");
		person10.setEmail("zarc@email.com");
		String[] allergies10 = {""};
		person10.setAllergies(allergies10);
		String[] medications10 = {""};
		person10.setMedications(medications10);
		
		listPersons.add(person10);
		
		Person person11 = new Person();
		person11.setFirstName("Eric");
		person11.setLastName("Cadigan");
		person11.setAddress("951 LoneTree Rd");
		person11.setCity("Culver");
		person11.setZip("97451");
		person11.setPhone("841-874-7458");
		person11.setEmail("gramps@email.com");
		String[] allergies11 = {""};
		person11.setAllergies(allergies11);
		String[] medications11 = {"tradoxidine:400mg"};
		person11.setMedications(medications11);
		
		listPersons.add(person11);
		
		Person person12 = new Person();
		person12.setFirstName("Ron");
		person12.setLastName("Peters");
		person12.setAddress("112 Steppes Pl");
		person12.setCity("Culver");
		person12.setZip("97451");
		person12.setPhone("841-874-8888");
		person12.setEmail("jpeter@email.com");
		String[] allergies12 = {""};
		person12.setAllergies(allergies12);
		String[] medications12 = {""};
		person12.setMedications(medications12);
		
		listPersons.add(person12);
		
		Person person13 = new Person();
		person13.setFirstName("Clive");
		person13.setLastName("Ferguson");
		person13.setAddress("748 Townings Dr");
		person13.setCity("Culver");
		person13.setZip("97451");
		person13.setPhone("841-874-6741");
		person13.setEmail("clivfd@ymail.com");
		String[] allergies13 = {""};
		person13.setAllergies(allergies13);
		String[] medications13 = {""};
		person13.setMedications(medications13);
		
		listPersons.add(person13);
    	
		List<String> listAddress = new ArrayList<>();
		listAddress.add("644 Gershwin Cir");
		listAddress.add("908 73rd St");
		listAddress.add("947 E. Rose Dr");
		listAddress.add("29 15th St");
		listAddress.add("892 Downing Ct");
		listAddress.add("951 LoneTree Rd");
		
		when(model.getPersons()).thenReturn(listPersons);
		List<Person> listPerson= floodService.getPersonsFromAddressStation(listAddress);
		assertEquals(11, listPerson.size());	
	
    }
    	
    @Test
 	 public void testGetPersonWithMedicationsAndAllergies () throws Exception {   	
    	List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("Peter");
		person1.setLastName("Duncan");
		person1.setAddress("644 Gershwin Cir");
		person1.setCity("Culver");
		person1.setZip("97451");
		person1.setPhone("841-874-6512");
		person1.setEmail("jaboyd@email.com");
	
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Reginold");
		person2.setLastName("Walker");
		person2.setAddress("908 73rd St");
		person2.setCity("Culver");
		person2.setZip("97451");
		person2.setPhone("841-874-8547");

		listPersons.add(person2);
		
		Person person3 = new Person();
		person3.setFirstName("Jamie");
		person3.setLastName("Peters");
		person3.setAddress("908 73rd St");
		person3.setCity("Culver");
		person3.setZip("97451");
		person3.setPhone("841-874-7462");
		person3.setEmail("jpeter@email.com");
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Brian");
		person4.setLastName("Stelzer");
		person4.setAddress("947 E. Rose Dr");
		person4.setCity("Culver");
		person4.setZip("97451");
		person4.setPhone("841-874-7784");
		person4.setEmail("bstel@email.com");
			
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Shawna");
		person5.setLastName("Stelzer");
		person5.setAddress("947 E. Rose Dr");
		person5.setCity("Culver");
		person5.setZip("97451");
		person5.setPhone("841-874-7784");
		person5.setEmail("ssanw@email.com");
	
		listPersons.add(person5);
		
		Person person6 = new Person();
		person6.setFirstName("Kendrik");
		person6.setLastName("Stelzer");
		person6.setAddress("947 E. Rose Dr");
		person6.setCity("Culver");
		person6.setZip("97451");
		person6.setPhone("841-874-7784");
		person6.setEmail("bstel@email.com");
		
		listPersons.add(person6);
		
		Person person7 = new Person();
		person7.setFirstName("Jonanathan");
		person7.setLastName("Marrack");
		person7.setAddress("29 15th St");
		person7.setCity("Culver");
		person7.setZip("97451");
		person7.setPhone("841-874-6513");
		person7.setEmail("drk@email.com");
		
		listPersons.add(person7);
		
		Person person8 = new Person();
		person8.setFirstName("Sophia");
		person8.setLastName("Zemicks");
		person8.setAddress("892 Downing Ct");
		person8.setCity("Culver");
		person8.setZip("97451");
		person8.setPhone("841-874-7878");
		person8.setEmail("soph@email.com");
		
		listPersons.add(person8);
		
		Person person9 = new Person();
		person9.setFirstName("Warren");
		person9.setLastName("Zemicks");
		person9.setAddress("892 Downing Ct");
		person9.setCity("Culver");
		person9.setZip("97451");
		person9.setPhone("841-874-7512");
		person9.setEmail("ward@email.com");
		
		listPersons.add(person9);
		
		Person person10 = new Person();
		person10.setFirstName("Zach");
		person10.setLastName("Zemicks");
		person10.setAddress("892 Downing Ct");
		person10.setCity("Culver");
		person10.setZip("97451");
		person10.setPhone("841-874-7512");
		person10.setEmail("zarc@email.com");
		
		listPersons.add(person10);
		
		Person person11 = new Person();
		person11.setFirstName("Eric");
		person11.setLastName("Cadigan");
		person11.setAddress("951 LoneTree Rd");
		person11.setCity("Culver");
		person11.setZip("97451");
		person11.setPhone("841-874-7458");
		person11.setEmail("gramps@email.com");
		
		listPersons.add(person11);
    	
		List<Medicalrecord> listMedicalrecords = new ArrayList<>();
		
		Medicalrecord medicalrecord1 = new Medicalrecord();
		medicalrecord1.setFirstName("Peter");
		medicalrecord1.setLastName("Duncan");
		medicalrecord1.setBirthdate("09/06/2000");
		String[] allergies = {"shellfish"};
		medicalrecord1.setAllergies(allergies);
		String[] medications = {""};
		medicalrecord1.setMedications(medications);
		
		listMedicalrecords.add(medicalrecord1);
		
		Medicalrecord medicalrecord2 = new Medicalrecord();
		medicalrecord2.setFirstName("Reginold");
		medicalrecord2.setLastName("Walker");
		medicalrecord2.setBirthdate("08/30/1979");
		String[] allergies2 = {"illisoxian"};
		medicalrecord2.setAllergies(allergies2);
		String[] medications2 = {"thradox:700mg"};
		medicalrecord2.setMedications(medications2);
		
		listMedicalrecords.add(medicalrecord2);
		
		Medicalrecord medicalrecord3 = new Medicalrecord();
		medicalrecord3.setFirstName("Jamie");
		medicalrecord3.setLastName("Peters");
		medicalrecord3.setBirthdate("03/06/1982");
		String[] allergies3 = {""};
		medicalrecord3.setAllergies(allergies3);
		String[] medications3 = {""};
		medicalrecord3.setMedications(medications3);
		
		listMedicalrecords.add(medicalrecord3);
		
		Medicalrecord medicalrecord4 = new Medicalrecord();
		medicalrecord4.setFirstName("Brian");
		medicalrecord4.setLastName("Stelzer");
		medicalrecord4.setBirthdate("12/06/1975");
		String[] allergies4 = {"nillacilan"};
		medicalrecord4.setAllergies(allergies4);
		String[] medications4 = {"ibupurin:200mg","hydrapermazol:400mg"};
		medicalrecord4.setMedications(medications4);
		
		listMedicalrecords.add(medicalrecord4);
		
		Medicalrecord medicalrecord5 = new Medicalrecord();
		medicalrecord5.setFirstName("Shawna");
		medicalrecord5.setLastName("Stelzer");
		medicalrecord5.setBirthdate("07/08/1980");
		String[] allergies5 = {""};
		medicalrecord5.setAllergies(allergies5);
		String[] medications5 = {""};
		medicalrecord5.setMedications(medications5);
		
		listMedicalrecords.add(medicalrecord5);
		
		Medicalrecord medicalrecord6 = new Medicalrecord();
		medicalrecord6.setFirstName("Kendrik");
		medicalrecord6.setLastName("Stelzer");
		medicalrecord6.setBirthdate("03/06/2014");
		String[] allergies6 = {""};
		medicalrecord6.setAllergies(allergies6);
		String[] medications6 = {"noxidian:100mg", "pharmacol:2500mg"};
		medicalrecord6.setMedications(medications6);
		
		listMedicalrecords.add(medicalrecord6);
		
		Medicalrecord medicalrecord7 = new Medicalrecord();
		medicalrecord7.setFirstName("Jonanathan");
		medicalrecord7.setLastName("Marrack");
		medicalrecord7.setBirthdate("01/03/1989");
		String[] allergies7 = {""};
		medicalrecord7.setAllergies(allergies7);
		String[] medications7 = {""};
		medicalrecord7.setMedications(medications7);
		
		listMedicalrecords.add(medicalrecord7);
		
		Medicalrecord medicalrecord8 = new Medicalrecord();
		medicalrecord8.setFirstName("Sophia");
		medicalrecord8.setLastName("Zemicks");
		medicalrecord8.setBirthdate("03/06/1988");
		String[] allergies8 = {"peanut", "shellfish", "aznol"};
		medicalrecord8.setAllergies(allergies8);
		String[] medications8 = {"aznol:60mg", "hydrapermazol:900mg", "pharmacol:5000mg", "terazine:500mg"};
		medicalrecord8.setMedications(medications8);
		
		listMedicalrecords.add(medicalrecord8);
    
		Medicalrecord medicalrecord9 = new Medicalrecord();
		medicalrecord9.setFirstName("Warren");
		medicalrecord9.setLastName("Zemicks");
		medicalrecord9.setBirthdate("03/06/1985");
		String[] allergies9 = {""};
		medicalrecord9.setAllergies(allergies9);
		String[] medications9 = {""};
		medicalrecord9.setMedications(medications9);
		
		listMedicalrecords.add(medicalrecord9);
		
		Medicalrecord medicalrecord10 = new Medicalrecord();
		medicalrecord10.setFirstName("Zach");
		medicalrecord10.setLastName("Zemicks");
		medicalrecord10.setBirthdate("03/06/2017");
		String[] allergies10 = {""};
		medicalrecord10.setAllergies(allergies10);
		String[] medications10 = {""};
		medicalrecord10.setMedications(medications10);
		
		listMedicalrecords.add(medicalrecord10);
		
		Medicalrecord medicalrecord11 = new Medicalrecord();
		medicalrecord11.setFirstName("Eric");
		medicalrecord11.setLastName("Cadigan");
		medicalrecord11.setBirthdate("08/06/1945");
		String[] allergies11 = {""};
		medicalrecord11.setAllergies(allergies11);
		String[] medications11 = {"tradoxidine:400mg"};
		medicalrecord11.setMedications(medications11);
		
		listMedicalrecords.add(medicalrecord11);
		
		when(model.getMedicalrecords()).thenReturn(listMedicalrecords);
		when(util.calculAge(Mockito.anyString())).thenCallRealMethod();
		
 		List<Person> listPersonResult = floodService.getPersonWithMedicationsAndAllergies(listPersons);
		assertNotNull(listPersonResult);
		assertNotNull(listPersonResult.get(0).getAllergies());
		assertEquals(medicalrecord1.getAllergies(),listPersonResult.get(0).getAllergies());
    }
    
    @Test
 	 public void testGetListPersonByAddress () throws Exception { 
    	List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("Peter");
		person1.setLastName("Duncan");
		person1.setAddress("644 Gershwin Cir");
		person1.setCity("Culver");
		person1.setZip("97451");
		person1.setPhone("841-874-6512");
		person1.setEmail("jaboyd@email.com");
		String[] allergies = {"shellfish"};
		person1.setAllergies(allergies);
		String[] medications = {""};
		person1.setMedications(medications);
		
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Reginold");
		person2.setLastName("Walker");
		person2.setAddress("908 73rd St");
		person2.setCity("Culver");
		person2.setZip("97451");
		person2.setPhone("841-874-8547");
		person2.setEmail("reg@email.com");
		String[] allergies2 = {"illisoxian"};
		person2.setAllergies(allergies2);
		String[] medications2 = {"thradox:700mg"};
		person2.setMedications(medications2);

		listPersons.add(person2);
		
		Person person3 = new Person();
		person3.setFirstName("Jamie");
		person3.setLastName("Peters");
		person3.setAddress("908 73rd St");
		person3.setCity("Culver");
		person3.setZip("97451");
		person3.setPhone("841-874-7462");
		person3.setEmail("jpeter@email.com");
		String[] allergies3 = {""};
		person3.setAllergies(allergies3);
		String[] medications3 = {""};
		person3.setMedications(medications3);
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Brian");
		person4.setLastName("Stelzer");
		person4.setAddress("947 E. Rose Dr");
		person4.setCity("Culver");
		person4.setZip("97451");
		person4.setPhone("841-874-7784");
		person4.setEmail("bstel@email.com");
		String[] allergies4 = {"nillacilan"};
		person4.setAllergies(allergies4);
		String[] medications4 = {"ibupurin:200mg","hydrapermazol:400mg"};
		person4.setMedications(medications4);
			
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Shawna");
		person5.setLastName("Stelzer");
		person5.setAddress("947 E. Rose Dr");
		person5.setCity("Culver");
		person5.setZip("97451");
		person5.setPhone("841-874-7784");
		person5.setEmail("ssanw@email.com");
		String[] allergies5 = {""};
		person5.setAllergies(allergies5);
		String[] medications5 = {""};
		person5.setMedications(medications5);
	
		listPersons.add(person5);
		
		Person person6 = new Person();
		person6.setFirstName("Kendrik");
		person6.setLastName("Stelzer");
		person6.setAddress("947 E. Rose Dr");
		person6.setCity("Culver");
		person6.setZip("97451");
		person6.setPhone("841-874-7784");
		person6.setEmail("bstel@email.com");
		String[] allergies6 = {""};
		person6.setAllergies(allergies6);
		String[] medications6 = {"noxidian:100mg", "pharmacol:2500mg"};
		person6.setMedications(medications6);
		
		listPersons.add(person6);
		
		Person person7 = new Person();
		person7.setFirstName("Jonanathan");
		person7.setLastName("Marrack");
		person7.setAddress("29 15th St");
		person7.setCity("Culver");
		person7.setZip("97451");
		person7.setPhone("841-874-6513");
		person7.setEmail("drk@email.com");
		String[] allergies7 = {""};
		person7.setAllergies(allergies7);
		String[] medications7 = {""};
		person7.setMedications(medications7);
		
		listPersons.add(person7);
		
		Person person8 = new Person();
		person8.setFirstName("Sophia");
		person8.setLastName("Zemicks");
		person8.setAddress("892 Downing Ct");
		person8.setCity("Culver");
		person8.setZip("97451");
		person8.setPhone("841-874-7878");
		person8.setEmail("soph@email.com");
		String[] allergies8 = {"peanut", "shellfish", "aznol"};
		person8.setAllergies(allergies8);
		String[] medications8 = {"aznol:60mg", "hydrapermazol:900mg", "pharmacol:5000mg", "terazine:500mg"};
		person8.setMedications(medications8);
		
		listPersons.add(person8);
		
		Person person9 = new Person();
		person9.setFirstName("Warren");
		person9.setLastName("Zemicks");
		person9.setAddress("892 Downing Ct");
		person9.setCity("Culver");
		person9.setZip("97451");
		person9.setPhone("841-874-7512");
		person9.setEmail("ward@email.com");
		String[] allergies9 = {""};
		person9.setAllergies(allergies9);
		String[] medications9 = {""};
		person9.setMedications(medications9);
		
		listPersons.add(person9);
		
		Person person10 = new Person();
		person10.setFirstName("Zach");
		person10.setLastName("Zemicks");
		person10.setAddress("892 Downing Ct");
		person10.setCity("Culver");
		person10.setZip("97451");
		person10.setPhone("841-874-7512");
		person10.setEmail("zarc@email.com");
		String[] allergies10 = {""};
		person10.setAllergies(allergies10);
		String[] medications10 = {""};
		person10.setMedications(medications10);
		
		listPersons.add(person10);
		
		Person person11 = new Person();
		person11.setFirstName("Eric");
		person11.setLastName("Cadigan");
		person11.setAddress("951 LoneTree Rd");
		person11.setCity("Culver");
		person11.setZip("97451");
		person11.setPhone("841-874-7458");
		person11.setEmail("gramps@email.com");
		String[] allergies11 = {""};
		person11.setAllergies(allergies11);
		String[] medications11 = {"tradoxidine:400mg"};
		person11.setMedications(medications11);
		
		listPersons.add(person11);
    	
    	List<String> listAddress = new ArrayList<>();
		listAddress.add("644 Gershwin Cir");
		listAddress.add("908 73rd St");
		listAddress.add("947 E. Rose Dr");
		listAddress.add("29 15th St");
		listAddress.add("892 Downing Ct");
		listAddress.add("951 LoneTree Rd");
		
		List<Flood> listResult = floodService.getListPersonByAddress(listPersons, listAddress);
		assertNotNull(listResult);
		assertEquals(1,listResult.get(0).getPersons().size());
		assertEquals(2,listResult.get(1).getPersons().size());
		assertEquals(3,listResult.get(2).getPersons().size());
		assertEquals(1,listResult.get(3).getPersons().size());
		assertEquals(3,listResult.get(4).getPersons().size());
		assertEquals(1,listResult.get(5).getPersons().size());
    }
}
