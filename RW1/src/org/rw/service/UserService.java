package org.rw.service;

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
	
}
