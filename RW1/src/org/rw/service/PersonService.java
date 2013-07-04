package org.rw.service;

import org.rw.entity.Person;
import org.rw.exception.PersonNotFoundException;

public interface PersonService {

	Long save(Person person);
	
	Person findById(Long id) throws PersonNotFoundException;

}
