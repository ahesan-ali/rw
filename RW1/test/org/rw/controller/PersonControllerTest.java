package org.rw.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.regex.Pattern;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.rw.service.UserService;
import org.rw.test.SpringControllerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MvcResult;

public class PersonControllerTest extends SpringControllerTest {

	
	@Autowired
	private UserService userService;
	
	
	@Test
	public void add() throws Exception {
		mockMvc.perform(get("/person/add", new Object[0])).andExpect(status().isOk());
	}
	
	
	@Test
	public void save() throws Exception {
		UserDetails userDetails = userService.loadUserByUsername("anil");
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
		
        /*mockMvc.perform(
			post("/person/save", new Object[0])
				.param("firstName", "JunitFN")
				.param("lastName", "JunitLN")
				.param("gender", "MALE")
				.param("dob", "11/02/1989")
		).andExpect(
				//redirectedUrl("view")
				status().isMovedTemporarily()
		);*/
        
        MvcResult result = mockMvc.perform(
			post("/person/save", new Object[0])
				.param("firstName", "JunitFN")
				.param("lastName", "JunitLN")
				.param("gender", "MALE")
				.param("dob", "11/02/1989")
		).andExpect(
				//redirectedUrl("view")
				status().isMovedTemporarily()
		).andReturn();
        
        MockHttpServletResponse response = result.getResponse();
        
        String location = response.getHeader("Location");
        
        Pattern pattern = Pattern.compile("\\Aview/[0-9]+\\z");
        assertTrue(pattern.matcher(location).find());
        
	}
	
	
	@Test
	public void saveWithInvalidGender() throws Exception {
		UserDetails userDetails = userService.loadUserByUsername("anil");
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        mockMvc.perform(	
			post("/person/save", new Object[0])
				.param("firstName", "JunitFN")
				.param("lastName", "JunitLN")
				.param("gender", "M")
				.param("dob", "11/02/1989")
		).andExpect(
				status().isBadRequest()
		);
	}
	
	
	@Test
	public void view() throws Exception {
		mockMvc.perform(	
			post("/person/view/1", new Object[0])
		).andExpect(
			status().isOk()
		);
	}
	
	
	@Test
	public void viewJson() throws Exception {
		mockMvc.perform(	
			post("/person/view/1.json", new Object[0])
		).andExpect(
			status().isOk()
		).andExpect(
			content().contentType(MediaType.APPLICATION_JSON)
		).andExpect(
			jsonPath("$.person.id", Matchers.equalTo(1))
		);
	}
	
	@Test
	public void viewXml() throws Exception {
		mockMvc.perform(	
			post("/person/view/1.xml", new Object[0])
		).andExpect(
			content().contentType(MediaType.APPLICATION_XML)
		).andExpect(
			status().isOk()
		);
	}
	
	
}
