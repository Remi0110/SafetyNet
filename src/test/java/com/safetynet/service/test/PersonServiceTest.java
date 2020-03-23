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

import com.safetynet.model.Model;
import com.safetynet.model.Person;
import com.safetynet.service.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	private static PersonService personService;

	private static Model model;
	
	@BeforeAll
	private static void setUp() {
		model = mock(Model.class);
		personService = new PersonService(model);
	}
	
	@Test
	public void testAdd() throws Exception {
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

		listPersons.add(person2);

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
		
		assertEquals(6, listPersons.size());
		
		Person newPerson = new Person();
		newPerson.setFirstName("AAAAA");
		newPerson.setLastName("BBBBB");
		newPerson.setAddress("CCCCCC");
		newPerson.setCity("DDDDD");
		newPerson.setZip("EEEEE");
		newPerson.setPhone("FFFFF");
		newPerson.setEmail("GGGGG");
		
		when(model.getPersons()).thenReturn(listPersons);
		listPersons = personService.add(newPerson);

		assertEquals(7, listPersons.size());
		assertEquals(newPerson.getFirstName(), listPersons.get(6).getFirstName());	
	}
	
	@Test
	public void testUpdate() throws Exception {
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

		listPersons.add(person2);

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
		
		assertEquals("aly@imail.com", listPersons.get(5).getEmail());
		
		Person updatedPerson = new Person();
		updatedPerson.setFirstName("Allison");
		updatedPerson.setLastName("Boyd");
		updatedPerson.setEmail("aaaabbb@gmail.com");
		
		when(model.getPersons()).thenReturn(listPersons);
		listPersons = personService.update(updatedPerson);
		
		assertEquals("aaaabbb@gmail.com", listPersons.get(5).getEmail());
	}
	
	@Test
	public void testDelete() throws Exception {
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

		listPersons.add(person2);

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
		
		assertEquals(6, listPersons.size());
		
		when(model.getPersons()).thenReturn(listPersons);
		listPersons = personService.delete(person6.getFirstName(), person6.getLastName());

		assertEquals(5, listPersons.size());
	}
	
}
