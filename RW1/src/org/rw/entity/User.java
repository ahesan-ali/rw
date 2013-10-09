/**
 * 
 */
package org.rw.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author anil.bharadia
 *
 */
@Entity
@Table(name="User")
public class User extends AbstractPersistentObject implements UserDetails {


	private static final long serialVersionUID = 1491705580500250495L;

	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	

	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="createdByUser")
	private Set<Person> personsCreated = new HashSet<Person>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="modifiedByUser")
	private Set<Person> personsModified = new HashSet<Person>();
	/*
	@OneToMany(fetch=FetchType.LAZY, mappedBy="createdByUser")
	private Set<User> usersCreated = new HashSet<User>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="modifiedByUser")
	private Set<User> usersModified = new HashSet<User>();
	*/
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
	public Set<Person> getPersonsCreated() {
		return personsCreated;
	}
	public void setPersonsCreated(Set<Person> personsCreated) {
		this.personsCreated = personsCreated;
	}
	
	
	public Set<Person> getPersonsModified() {
		return personsModified;
	}
	public void setPersonsModified(Set<Person> personsModified) {
		this.personsModified = personsModified;
	}
	
	
	/*
	public Set<User> getUsersCreated() {
		return usersCreated;
	}
	public void setUsersCreated(Set<User> usersCreated) {
		this.usersCreated = usersCreated;
	}
	
	
	public Set<User> getUsersModified() {
		return usersModified;
	}
	public void setUsersModified(Set<User> usersModified) {
		this.usersModified = usersModified;
	}
	*/
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getUserRoles();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
