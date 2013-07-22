package org.rw.entity;

public class DuplicateUsernameException extends RuntimeException {

	
	private static final long serialVersionUID = -9210728114254639911L;
	
	private String username;
	
	
	@SuppressWarnings("unused")
	private DuplicateUsernameException() {}
	
	public DuplicateUsernameException(final String username) {
		this.username = username;
	}
	
	
	@Override
	public String getMessage() {
		return "There are more than one User instances with the same username[" + username + "]";
	}
	

}
