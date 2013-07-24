package org.rw.service;

import java.util.List;

import org.rw.entity.User;
import org.rw.entity.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @since 1.0
 * @author anil.bharadia
 */
public interface UserService extends UserDetailsService {

	Long save(User user);
	
	User findById(Long id) throws UserNotFoundException;

	User findByUsername(String username);

	List<User> findAll();
	
}
