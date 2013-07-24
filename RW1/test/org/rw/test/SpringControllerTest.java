package org.rw.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
public class SpringControllerTest extends SpringTest {

	
	@Test
	public void init() {}
	
	
	@Autowired
	protected WebApplicationContext wac;

	protected MockMvc mockMvc;

	@Before
	public void setup() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	
}
