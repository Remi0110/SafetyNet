package com.safetynet.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.safetynet.service.CommunityEmailService;

@ExtendWith(MockitoExtension.class)
public class CommunityEmailServiceTest {
	
	private static CommunityEmailService communityEmailService;

    private static Model model;
	    

    @BeforeAll
    private static void setUp() {
    	 model = mock(Model.class);
    	 communityEmailService = new CommunityEmailService(model);
    }
    
    @Test
	 public void testGetEmailsByCityName () throws Exception {
    	List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("John");
		person1.setLastName("Boyd");
		person1.setCity("Culver");
		person1.setEmail("jaboyd@email.com");
		
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Jacob");
		person2.setLastName("Boyd");
		person2.setCity("Culver");
		person2.setEmail("drk@email.com");
		
		listPersons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Tenley");
		person3.setLastName("Boyd");
		person3.setCity("Culver");
		person3.setEmail("tenz@email.com");
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Roger");
		person4.setLastName("Boyd");
		person4.setCity("Culver");
		person4.setEmail("jaboyd@email.com");

	
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Felicia");
		person5.setLastName("Boyd");
		person5.setCity("Culver");
		person5.setEmail("jaboyd@email.com");
	
		listPersons.add(person5);
		
		String city = "Culver";	
		when(model.getPersons()).thenReturn(listPersons);
		List <String> listEmails =  communityEmailService.getEmailsByCityName(city);
		// return distinct email
		assertEquals(3, listEmails.size());	
	    }
    
    @Test
	 public void testGetEmailsByCityNameWithNullValue (){
    	List<Person> listPersons = new ArrayList<>();
		Person person1 = new Person();
		person1.setFirstName("John");
		person1.setLastName("Boyd");
		person1.setCity("Culver");
		person1.setEmail("jaboyd@email.com");
		
		listPersons.add(person1);
		
		Person person2 = new Person();
		person2.setFirstName("Jacob");
		person2.setLastName("Boyd");
		person2.setCity("Culver");
		person2.setEmail("drk@email.com");
		
		listPersons.add(person2);

		Person person3 = new Person();
		person3.setFirstName("Tenley");
		person3.setLastName("Boyd");
		person3.setCity("Culver");
		person3.setEmail("tenz@email.com");
	
		listPersons.add(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Roger");
		person4.setLastName("Boyd");
		person4.setCity("Culver");
		person4.setEmail("jaboyd@email.com");

	
		listPersons.add(person4);
		
		Person person5 = new Person();
		person5.setFirstName("Felicia");
		person5.setLastName("Boyd");
		person5.setCity("Culver");
		person5.setEmail("jaboyd@email.com");
	
		listPersons.add(person5);
				
		when(model.getPersons()).thenReturn(listPersons);
			
		String city = null;
		assertThrows(
				  Exception.class,
		            ()->communityEmailService.getEmailsByCityName(city));
	    }
	
}
