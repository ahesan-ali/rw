package org.rw.exception;

import java.io.Serializable;

import org.rw.entity.Person;

public class PersonNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = -3482002470726982327L;

	public PersonNotFoundException(Serializable id) {
		super(Person.class, id);
	}

}
