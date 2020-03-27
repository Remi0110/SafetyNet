package com.safetynet.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.safetynet.controller.FirestationController;
import com.safetynet.service.FirestationService;
import com.safetynet.service.Util;


@WebMvcTest(FirestationController.class)
@ExtendWith(SpringExtension.class)
public class FirestationControllerTest {

	@Autowired
    private MockMvc mvc;
	
	@MockBean
    private Util Util;
	
	@MockBean
	private FirestationService firestationService;
	
	@Test
	 public void addFirestationTest() throws Exception {

	        this.mvc.perform(post("/firestation/add")
	        .contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"7777 XXXXX Ddddd\",\"station\": \"1\"}"))
	        .andDo(MockMvcResultHandlers.print())
	        
	                .andExpect(status().isOk());
	 }
	
	 @Test
	 public void deleteFirestationTest() throws Exception {

	        this.mvc.perform(MockMvcRequestBuilders.delete("/firestation/delete")
	    	        .contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"1509 Culver St\",\"station\": \"3\"}"))

	        .andDo(MockMvcResultHandlers.print())
	        
	                .andExpect(status().isOk());        
	 }
	 
	 @Test
	 public void updateFirestationTest() throws Exception {

	        this.mvc.perform(MockMvcRequestBuilders.put("/firestation/update")
	        .contentType(MediaType.APPLICATION_JSON).content("{\"address\": \"1509 Culver St\",\"station\": \"2\"}"))
	        .andDo(MockMvcResultHandlers.print())
	        
	                .andExpect(status().isOk());
	 }
	
}
