package org.rw.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.rw.entity.Person;
import org.rw.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration({ "classpath:/spring/applicationContext.xml" })
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

	@Autowired
	private PersonService personService;
	
	
	@Rule
 	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void findByIdNormal() {
		Person person = personService.findById(1l);
		assertEquals(Long.valueOf(1l), person.getId());
	}
	
	
	@Test
	public void findByIdNotExist() {
		thrown.expect(PersonNotFoundException.class);
		personService.findById(1212l);
	}
	
	
	@Test
	public void findByIdNull() {
		thrown.expect(PersonNotFoundException.class);
		personService.findById(null);
	}
	
	
}
