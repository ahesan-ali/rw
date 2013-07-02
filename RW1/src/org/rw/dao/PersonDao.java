package org.rw.dao;

import java.util.List;

import org.rw.entity.Person;

public interface PersonDao extends GenericDao<Person, Long> {

	List<Person> findByFirstName(String firstName);
	
}
