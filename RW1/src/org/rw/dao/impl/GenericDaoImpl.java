package org.rw.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rw.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl <E, PK extends Serializable> implements GenericDao<E, PK>/*, FinderExecutor*/ {
	
	
	private Class<E> entityType;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public GenericDaoImpl(Class<E> entityType) {
	    this.entityType = entityType;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PK create(E entity) {
	    return (PK) getSession().save(entity);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public E read(PK id) {
	    return (E) getSession().get(entityType, id);
	}
	
	
	@Override
	public void update(E entity) {
	    getSession().update(entity);
	}
	
	
	@Override
	public void delete(E entity) {
	    getSession().delete(entity);
	}

	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByProperty(final String propertyName,  final String propertyValue) {
		Query query = getSession().createQuery("from " + entityType.getSimpleName() + " where " + propertyName + " = :propertyValue");
		query.setParameter("propertyValue", propertyValue);
		return query.list();
	}
	
}