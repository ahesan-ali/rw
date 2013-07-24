package org.rw.util;

import org.rw.dao.UserDao;
import org.rw.entity.User;
import org.rw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils {

	
	@Autowired
	private UserService userService;
	
	
	public String getLoggedInUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	
	public User getLoggedInUser() {
		String username = getLoggedInUsername();
		return userService.findByUsername(username);
	}
	
	
}
