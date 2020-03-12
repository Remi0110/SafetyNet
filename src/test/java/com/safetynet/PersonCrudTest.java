package com.safetynet;

import static org.hamcrest.Matchers.hasSize;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test; // JUnit 5
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.safetynet.controller.PersonController;
import com.safetynet.model.Model;
import com.safetynet.service.PersonService;

@WebMvcTest(PersonController.class)
//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class PersonCrudTest {

	@Autowired
    private MockMvc mvc;
	
	@Autowired
    private Model model;
	
	@MockBean
	private PersonService service;
	
	 
	 @Test
	 public void addPersonTest() throws Exception {

	        this.mvc.perform(post("/person/add")
	        .contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Test\",\"lastName\": \"\",\"address\": \"\",\"city\": \"\",\"zip\": \"\",\"phone\": \"\",\"email\": \"\"}"))
	        .andDo(MockMvcResultHandlers.print())
	        
	                .andExpect(status().isOk());
	 }
	 
	 @Test
	 public void deletePersonTest() throws Exception {

	        this.mvc.perform(MockMvcRequestBuilders.delete("/person/delete")
	        .param("firstName", "Eric").param("lastName", "Cadigan"))
	        .andDo(MockMvcResultHandlers.print())
	        
	                .andExpect(status().isOk());
//	                .andExpect(jsonPath("$", hasSize(22)));

	 }

	 @Test
	 public void updatePersonTest() throws Exception {

	        this.mvc.perform(MockMvcRequestBuilders.put("/person/update")
	        .contentType(MediaType.APPLICATION_JSON).content("{\"firstName\": \"Jacob\",\"lastName\": \"Boyd\",\"address\": \"157 dum street\",\"city\": \"Culver\",\"zip\": \"15874\",\"phone\": \"825-854-6513\",\"email\": \"Jacob@gmail.com\"}"))
	        .andDo(MockMvcResultHandlers.print())
	        
	                .andExpect(status().isOk());
//	                .andExpect(jsonPath("$[1].email", is("Jacob@gmail.com")));
	 }
}
