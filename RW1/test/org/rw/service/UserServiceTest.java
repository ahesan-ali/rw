package org.rw.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.rw.entity.UserNotFoundException;
import org.rw.test.SpringInitializer;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends SpringInitializer {

	@Rule
 	public ExpectedException thrown = ExpectedException.none();
	
	@Autowired
	private UserService userService;
	
	
	@Test
	public void findByIdNegative() {
		thrown.expect(UserNotFoundException.class);
		userService.findById(-1l);
	}
	
	
	@Test
	public void findByIdZero() {
		thrown.expect(UserNotFoundException.class);
		userService.findById(0l);
	}
	
	
	@Test
	public void findByIdNull() {
		thrown.expect(UserNotFoundException.class);
		userService.findById(null);
	}
	
	
	public void findByIdPositive() {
		userService.findById(1l);
	}
	
	
}
