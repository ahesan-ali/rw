/**
 * 
 */
package org.rw.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


/**
 * @author anil.bharadia
 *
 */
@Entity
@Table(name="UserRole")
public class UserRole extends AbstractPersistentObject implements GrantedAuthority {

	
	private static final long serialVersionUID = -427668755433915749L;
	
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="UserId", nullable=false)
	private User user;
	
	@Column(name="Authority")
	private String authority;

	
	public User getUser() {
		return user;
	}
	public void setUser(final User user) {
		this.user = user;
	}


	public String getAuthority() {
		return authority;
	}
	public void setAuthority(final String authority) {
		this.authority = authority;
	}
	
	
	@Override
	public String toString() {
		return getAuthority();
	}
	

}
