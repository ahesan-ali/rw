package org.rw.dao;

import java.util.List;

import org.rw.entity.PersistentObject;
import org.rw.entity.EntityNotFoundException;

public interface GenericDao <E extends PersistentObject> {

	
    /** Persist the newInstance object into database */
    Long create(E newInstance);

    
    /**
     * Retrieve an object that was previously persisted to the database using the indicated id as primary key
     * @return a persistent instance or {@link EntityNotFoundException} (never <code>null</code>)
     */
    E read(Long id);

    
    /** Save changes made to a persistent object.  */
    void update(E transientObject);

    
    /** Remove an object from persistent storage in the database */
    void delete(E persistentObject);
    
    
    List<E> findByProperty(String propertyName, Object propertyValue);
    
    
    List<E> findByExample(E entity);

    
    List<E> findByLikeExample(E entity);
    
    
    List<E> findAll();
    
    
}

