package org.rw.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.rw.service.UserService;
import org.rw.test.SpringControllerTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class PersonControllerTest extends SpringControllerTest {

	
	@Autowired
	private UserService userService;
	
	
	@Test
	public void add() throws Exception {
		mockMvc.perform(get("/person/add", new Object[0])).andExpect(status().isOk());
	}
	
	
	@Test
	public void save() throws Exception {
		UserDetails userDetails = userService.findByUsername("anil");
        Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
		
        mockMvc.perform(
			post("/person/save", new Object[0])
				.param("firstName", "JunitFN")
				.param("lastName", "JunitLN")
				.param("gender", "MALE")
				.param("dob", "11/02/1989")
		).andExpect(
				//redirectedUrl("view")
				status().isMovedTemporarily()
		);
	}
	
	
}
