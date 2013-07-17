package org.rw.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.rw.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl <E, PK extends Serializable> implements GenericDao<E, PK>/*, FinderExecutor*/ {
	
	
	protected static final MatchMode DEFAULT_MATCH_MODE = MatchMode.ANYWHERE;
	
	private Class<E> persistentClass;
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public GenericDaoImpl(Class<E> entityType) {
	    this.persistentClass = entityType;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PK create(E entity) {
	    return (PK) getSession().save(entity);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public E read(PK id) {
	    return (E) getSession().get(persistentClass, id);
	}
	
	
	@Override
	public void update(E entity) {
	    getSession().update(entity);
	}
	
	
	@Override
	public void delete(E entity) {
	    getSession().delete(entity);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByProperty(final String propertyName,  final String propertyValue) {
		Query query = getSession().createQuery("from " + persistentClass.getSimpleName() + " where " + propertyName + " = :propertyValue");
		query.setParameter("propertyValue", propertyValue);
		return query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByExample(E entity) {
		Criteria criteria = createCriteriaWithExample(entity);
		return criteria.list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByLikeExample(E entity) {
		Criteria criteria = createCriteriaWithLikeExample(entity);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() {
		return createCriteria().list();
	}
	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	protected Example createExample(E entity) {
		return Example.create(entity);
	}
	
	
	/** with DEFAULT_MATCH_MODE */
	protected Example createLikeExample(E entity) {
		return createLikeExample(entity, DEFAULT_MATCH_MODE);
	}

	
	protected Example createLikeExample(E entity, MatchMode matchMode) {
		Example example = createExample(entity);
		example.enableLike(matchMode);
		return example;
	}
	
	
	protected Criteria createCriteria() {
		return getSession().createCriteria(persistentClass);
	}
	
	
	protected Criteria createCriteriaWithExample(E entity) {
		Criteria criteria = createCriteria();
		Example example = createExample(entity);
		criteria.add(example);
		return criteria;
	}
	
	
	protected Criteria createCriteriaWithLikeExample(E entity) {
		return createCriteriaWithLikeExample(entity, DEFAULT_MATCH_MODE);
	}
	
	
	protected Criteria createCriteriaWithLikeExample(E entity, MatchMode matchMode) {
		Criteria criteria = createCriteria();
		Example example = createLikeExample(entity, matchMode);
		criteria.add(example);
		return criteria;
	}

	
}