package org.rw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.rw.commons.lang.TimestampUtils;
import org.rw.xml.adapter.SqlTimestampXmlAdapters;

@JsonAutoDetect(getterVisibility=Visibility.NONE)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="Person")
public class Person extends AbstractPersistentObject {
	
	
	private static final long serialVersionUID = 4776683158475479656L;
	
	
	@JsonSerialize
	@Column(name="FirstName")
	private String firstName;
	
	@JsonSerialize
	@Column(name="LastName")
	private String lastName;
	
	@JsonSerialize
	@Column(name="Gender", columnDefinition="enum('MALE', 'FEMALE')")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@XmlJavaTypeAdapter(SqlTimestampXmlAdapters.class)
	@Column(name="DOB")
	private Timestamp dob;
	
	
	public Person() {
		
	}
	
	
	public static enum Gender {
		MALE,
		FEMALE
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
	
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
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
			person.append("id:" + getId() + ",");
			person.append("firstName:" + firstName + ",");
			person.append("lastName:" + lastName + ",");
			person.append("gender:" + gender + ",");
			person.append("dob:" + TimestampUtils.format(dob) + ",");
		person.append("}");
		
		return person.toString();
	}
	
	
}
