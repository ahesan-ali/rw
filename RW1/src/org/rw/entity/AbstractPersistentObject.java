package org.rw.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractPersistentObject implements PersistentObject {


	private static final long serialVersionUID = 82152973534901258L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	protected Long id;
	
	@Column(name="dateCreated")
	protected Timestamp dateCreated;
	
	@Column(name="DateModified")
	protected Timestamp dateModified;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="CreatedByUserId", nullable=false)
	protected User createdByUser;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="ModifiedByUserId", nullable=false)
	protected User modifiedByUser;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

}
