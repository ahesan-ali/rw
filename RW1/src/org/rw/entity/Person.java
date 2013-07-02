package org.rw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.time.DateUtils;
import org.rw.util.StringUtils;
import org.rw.util.TimestampUtils;


@Entity
@Table(name="Person")
public class Person {

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
	
public Person() {
	
}


	public Person(Long id, String firstName, String lastName, String gender,
		Timestamp dob) {
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
	
	
	@Override
	public String toString() {
		StringBuffer person = new StringBuffer();
		
		person.append("{");
			person.append("id:" + id + ",");
			person.append("firstName:" + StringUtils.doubleQuote(firstName) + ",");
			person.append("lastName:" + StringUtils.doubleQuote(lastName) + ",");
			person.append("gender:" + StringUtils.doubleQuote(gender) + ",");
			person.append("dob:" + StringUtils.doubleQuote(TimestampUtils.format(dob)) + ",");
		person.append("}");
		
		return person.toString();
	}
	
}
