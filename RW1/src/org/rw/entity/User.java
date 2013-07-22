/**
 * 
 */
package org.rw.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = 1491705580500250495L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="dateCreated")
	private Timestamp dateCreated;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="CreatedByUserId", nullable=false)
	private User createdByUser;
	
	@Column(name="DateModified")
	private Timestamp dateModified;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="ModifiedByUserId", nullable=false)
	private User modifiedByUser;

	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="createdByUser")
	private Set<Person> personsCreated = new HashSet<Person>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="modifiedByUser")
	private Set<Person> personsModified = new HashSet<Person>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="createdByUser")
	private Set<User> usersCreated = new HashSet<User>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="modifiedByUser")
	private Set<User> usersModified = new HashSet<User>();
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
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

	
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	public User getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	
	public Timestamp getDateModified() {
		return dateModified;
	}
	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}
	
	
	public User getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(User modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}
	
	
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
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
