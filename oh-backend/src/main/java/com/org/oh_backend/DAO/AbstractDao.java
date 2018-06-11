package com.org.oh_backend.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	public T getByKey(PK key) {
		return (T) entityManager.find(persistentClass, key);
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}
	
	protected EntityManager getEntityManager(){
		return entityManager;
	}
}
