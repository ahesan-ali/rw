package org.rw.service.impl;

import org.rw.dao.PersonDao;
import org.rw.entity.Person;
import org.rw.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Override
	public void save(Person person) {
		personDao.create(person);
	}

}
