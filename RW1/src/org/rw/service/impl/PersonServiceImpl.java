package org.rw.service.impl;

import java.util.List;

import org.rw.dao.PersonDao;
import org.rw.entity.Person;
import org.rw.entity.PersonNotFoundException;
import org.rw.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @since 1.0
 * @author anil.bharadia
 */
@Service("personService")
@Transactional(readOnly=true)
public class PersonServiceImpl implements PersonService {

	
	@Autowired
	private PersonDao personDao;
	
	
	@Override
	@Transactional(readOnly=false)
	public Long save(Person person) {
		return personDao.create(person);
	}


	@Override
	@Transactional(readOnly=true)
	public Person findById(Long id) {
		if (id == null) {
			throw new PersonNotFoundException(id);
		}
		Person person = personDao.read(id);
		if (person == null) {
			throw new PersonNotFoundException(id);
		}
		return person;
	}


	@Override
	@Transactional(readOnly=true)
	public List<Person> findByFirstName(final String firstName) {
		return personDao.findByFirstName(firstName);
	}


	@Override
	@Transactional(readOnly=true)
	public List<Person> findByLikeExample(Person person) {
		return personDao.findByLikeExample(person);
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Person> findAll() {
		return personDao.findAll();
	}
	

}
