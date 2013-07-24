package org.rw.dao.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.rw.dao.GenericDao;
import org.rw.entity.PersistentObject;
import org.rw.util.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl <E extends PersistentObject> implements GenericDao<E>/*, FinderExecutor*/ {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SpringUtils springUtils;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GenericDaoImpl.class);
	
	/** default like clause match mode */
	protected static final MatchMode DEFAULT_MATCH_MODE = MatchMode.ANYWHERE;
	
	protected static final String DEFAULT_ORDER_BY = "dateCreated";
	
	private Class<E> persistentClass;
	
	
	public GenericDaoImpl(Class<E> entityType) {
	    this.persistentClass = entityType;
	}
	
	
	@Override
	public Long create(E entity) {
		entity.setCreatedByUser(springUtils.getLoggedInUser());
		entity.setModifiedByUser(springUtils.getLoggedInUser());
	    return (Long) getSession().save(entity);
	}
	
	
	@Override
	public E read(final Long id) {
		validateIdForRead(id);
		
	    @SuppressWarnings("unchecked")
		E entity = (E) getSession().get(persistentClass, id);
	    
	    if (entity == null) {
	    	throwEntityNotFoundException(id);
		}
	    
	    return entity;
	}
	
	
	@Override
	public void update(E entity) {
		entity.setModifiedByUser(springUtils.getLoggedInUser());
	    getSession().update(entity);
	}
	
	
	@Override
	public void delete(E entity) {
	    getSession().delete(entity);
	}
	
	
	private void validateIdForRead(final Long id) {
		if (id == null  ||  id < 1) {
			throwEntityNotFoundException(id);
		}
	}


	protected void throwEntityNotFoundException(final Long id) {
		try {
			Class<?> exceptionClass = getEntityNotFoundExceptionClass();
			Constructor<?> constructor = exceptionClass.getConstructor(Long.class);
			RuntimeException ex = (RuntimeException) constructor.newInstance(id);
			throw ex;
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.error("error throwing EntityNotFoundException", e);
			throw new RuntimeException(e);
		}
	}
	
	
	protected Class<?> getEntityNotFoundExceptionClass() {
		try {
			return Class.forName(getEntityNotFoundExceptionClassName());
		} catch (ClassNotFoundException cnfe) {
			throw new RuntimeException(cnfe);
		}
	}
	
	
	protected String getEntityNotFoundExceptionClassName() {
		return persistentClass.getName() + "NotFoundException";
	}

	
	@Override
	public List<E> findByProperty(final String propertyName, final Object propertyValue) {
		return findByPropertyWithCriteria(propertyName, propertyValue);
	}
	
	
	public List<E> findByPropertyWithHql(final String propertyName, final Object propertyValue) {
		StringBuffer queryString = new StringBuffer("from "); 
		queryString.append(persistentClass.getSimpleName());
		queryString.append(" where ");
		queryString.append(propertyName);
		queryString.append(" = :propertyValue order by ");
		queryString.append(DEFAULT_ORDER_BY);
		queryString.append(" desc");
		
		Query query = getSession().createQuery(queryString.toString());
		query.setParameter("propertyValue", propertyValue);
		
		@SuppressWarnings("unchecked")
		List<E> entities = query.list();
		return entities;
	}
	
	
	public List<E> findByPropertyWithCriteria(final String propertyName, final Object propertyValue) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq(propertyName, propertyValue));
		criteria.addOrder(Order.desc(DEFAULT_ORDER_BY));
		
		@SuppressWarnings("unchecked")
		List<E> entities = criteria.list();
		return entities;
	}
	
	
	@Override
	public List<E> findByExample(E entity) {
		Criteria criteria = createCriteriaWithExample(entity);
		@SuppressWarnings("unchecked")
		List<E> entities = criteria.list();
		return entities;
	}
	
	
	@Override
	public List<E> findByLikeExample(E entity) {
		Criteria criteria = createCriteriaWithLikeExample(entity);
		@SuppressWarnings("unchecked")
		List<E> entities = criteria.list();
		return entities;
	}

	
	@Override
	public List<E> findAll() {
		Criteria criteria = createCriteria();
		criteria.addOrder(Order.desc(DEFAULT_ORDER_BY));
		
		@SuppressWarnings("unchecked")
		List<E> entities = criteria.list();
		return entities;
	}
	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	protected Example createExample(E entity) {
		return Example.create(entity);
	}
	
	
	/** 
	 * with DEFAULT_MATCH_MODE
	 * @see #DEFAULT_MATCH_MODE
	 */
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