package org.rw.entity;


/**
 * @since 1.0
 * @author anil.bharadia
 */
public class UserNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 9186415559350861191L;

	public UserNotFoundException(Long id) {
		super(User.class, id);
	}
	
}
