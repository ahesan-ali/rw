/**
 * 
 */
package org.rw.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author anil.bharadia
 *
 */
@Entity
@Table(name="User")
public class User implements Serializable {

	private static final long serialVersionUID = 1491705580500250495L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="DateRegistered")
	private Timestamp dateRegistered;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="createdBy")
	private Set<Person> personsCreated = new HashSet<Person>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="modifiedBy")
	private Set<Person> personsModified = new HashSet<Person>();
	
	
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

	
	public Timestamp getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(Timestamp dateRegistered) {
		this.dateRegistered = dateRegistered;
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

	
}
