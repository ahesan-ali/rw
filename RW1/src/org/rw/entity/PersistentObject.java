package org.rw.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public interface PersistentObject extends Serializable {

	Long getId();
	void setId(Long id);
	
	Timestamp getDateCreated();
	void setDateCreated(Timestamp dateCreated);
	
	Timestamp getDateModified();
	void setDateModified(Timestamp dateModified);
	
	User getCreatedByUser();
	void setCreatedByUser(User createdByUser);
	
	User getModifiedByUser();
	void setModifiedByUser(User modifiedByUser);
	
}
