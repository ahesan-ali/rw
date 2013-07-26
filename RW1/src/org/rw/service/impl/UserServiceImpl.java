package org.rw.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.rw.dao.UserDao;
import org.rw.entity.DuplicateUsernameException;
import org.rw.entity.User;
import org.rw.entity.UserRole;
import org.rw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @since 1.0
 * @author anil.bharadia
 */
@Service(value="userService")
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	@Transactional(readOnly=false)
	public Long save(User user) {
		return userDao.create(user);
	}

	
	@Override
	@Transactional(readOnly=true)
	public User findById(final Long id) {
		return userDao.read(id);
	}


	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		
		Set<UserRole> roles = user.getUserRoles();
		for (@SuppressWarnings("unused") UserRole role : roles) {
			// just to lazy load user roles
		}
		
		return user;
	}


	@Override
	public User findByUsername(final String username) {
		if (StringUtils.isBlank(username)) {
			throw new UsernameNotFoundException("username is null or blank");
		}
		
		List<User> users = userDao.findByProperty("username", username);
		if (users.size() != 1) {
			throw new DuplicateUsernameException(username);
		} else {
			return users.get(0);
		}
	}


	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return userDao.findAll();
	}
	

}
