package org.rw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.rw.commons.lang.StringUtils;
import org.rw.commons.lang.TimestampUtils;


@Entity
@Table(name="Person")
public class Person implements Serializable {
	
	private static final long serialVersionUID = 4776683158475479656L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="DOB")
	private Timestamp dob;
	
	@Column(name="dateCreated")
	private Timestamp dateCreated;
	
	@Column(name="DateModified")
	private Timestamp dateModified;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="CreatedByUserId", nullable=false)
	private User createdByUser;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="ModifiedByUserId", nullable=false)
	private User modifiedByUser;
	
	
	public Person() {
		
	}

	
	public Person(Long id, String firstName, String lastName, String gender, Timestamp dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public Timestamp getDob() {
		return dob;
	}
	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
	
	
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Timestamp getDateModified() {
		return dateModified;
	}
	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}


	public User getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}


	public User getModifiedByUser() {
		return modifiedByUser;
	}
	public void setModifiedByUser(User modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}


	@Override
	public String toString() {
		StringBuffer person = new StringBuffer();
		
		person.append("{");
			person.append(StringUtils.doubleQuote("id:") + id + ",");
			person.append("firstName:" + StringUtils.doubleQuote(firstName) + ",");
			person.append("lastName:" + StringUtils.doubleQuote(lastName) + ",");
			person.append("gender:" + StringUtils.doubleQuote(gender) + ",");
			person.append("dob:" + StringUtils.doubleQuote(TimestampUtils.format(dob)) + ",");
		person.append("}");
		
		return person.toString();
	}
	
	
}
