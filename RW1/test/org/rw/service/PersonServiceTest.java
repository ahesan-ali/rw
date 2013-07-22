package org.rw.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.rw.entity.Person;
import org.rw.entity.PersonNotFoundException;
import org.rw.test.SpringInitializer;
import org.springframework.beans.factory.annotation.Autowired;


public class PersonServiceTest extends SpringInitializer {

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
	
	@Test
	public void findByIdNegative() {
		thrown.expect(PersonNotFoundException.class);
		personService.findById(-1l);
	}
	
	
	@Test
	public void findByFirstName() {
		String firstName = "anil";
		List<Person> persons = personService.findByFirstName(firstName);
		for (Person person : persons) {
			assertEquals(firstName.toLowerCase(), person.getFirstName().toLowerCase());
		}
	}
	
	
	@Test
	public void findByFirstNameSqlInjection1() {
		String firstName = "anil' or 1=1; --";
		List<Person> persons = personService.findByFirstName(firstName);
		assertEquals(0, persons.size());
	}
	
	@Test
	public void findByFirstNameSqlInjection2() {
		String firstName = "anil or 1=1; --";
		List<Person> persons = personService.findByFirstName(firstName);
		assertEquals(0, persons.size());
	}
	
	
	@Test
	public void findAll() {
		List<Person> persons = personService.findAll();
		System.out.println(persons.size());
	}
	
	
}
