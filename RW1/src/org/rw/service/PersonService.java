package org.rw.service;


import java.util.List;

import org.rw.entity.Person;
import org.rw.entity.PersonNotFoundException;

/**
 * @since 1.0
 * @author anil.bharadia
 */
public interface PersonService {

	Long save(Person person);
	
	Person findById(Long id) throws PersonNotFoundException;

	List<Person> findByFirstName(String firstName);

	List<Person> findByLikeExample(Person person);

	List<Person> findAll();

}
