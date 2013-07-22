package org.rw.dao;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.rw.entity.PersonNotFoundException;
import org.rw.test.SpringInitializer;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDaoTest extends SpringInitializer {

	@Autowired
	private PersonDao personDao;
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void finaAll() {
		personDao.findAll();
	}
	
	
	@Test
	public void readNegative() {
		thrown.expect(PersonNotFoundException.class);
		personDao.read(-1l);
	}
	
	@Test
	public void readZero() {
		thrown.expect(PersonNotFoundException.class);
		personDao.read(0l);
	}
	
	@Test
	public void read() {
		personDao.read(1l);
	}
	
	@Test
	public void readNull() {
		thrown.expect(PersonNotFoundException.class);
		personDao.read(null);
	}
	
	
}
