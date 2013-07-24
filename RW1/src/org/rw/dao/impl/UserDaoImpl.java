package org.rw.dao.impl;

import org.rw.dao.UserDao;
import org.rw.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @since 1.0
 * @author anil.bharadia
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

}
