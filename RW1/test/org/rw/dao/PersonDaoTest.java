package org.rw.dao;

import org.junit.Test;
import org.rw.test.SpringInitializer;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDaoTest extends SpringInitializer {

	@Autowired
	private PersonDao personDao;
	
	@Test
	public void finaAll() {
		personDao.findAll();
	}
	
	
}
