package com.everis.control;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PersistenceService<T,I> {
	
	@PersistenceContext(unitName = "carAPI")
	private EntityManager em;

	public List<T> getAll(Class<T> c){
		TypedQuery<T> query = em.createQuery("SELECT c FROM Car c", c);
		return query.getResultList();
	}
	
	public T getById(Class<T> c, I id) {
		return em.find(c, id);
	}
	
	public T createOne(T entity) {
		em.persist(entity);
		return entity;
	}

	public T updateOne(T entity) {
		em.merge(entity);
		return entity;
	}

	public T deleteOne(T entity) {
		em.remove(entity);
		return entity;
	}
}
