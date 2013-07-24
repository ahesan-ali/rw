package org.rw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@ContextConfiguration({ "classpath:/spring/applicationContext.xml", "classpath:/spring/securityContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
	
	
	@Test
	public void init() {}

	
}
