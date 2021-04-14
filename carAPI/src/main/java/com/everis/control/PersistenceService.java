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

	public List<T> getCars(Class<T> c){
		TypedQuery<T> query = em.createQuery("SELECT c FROM Car c", c);
		return query.getResultList();
	}
	
	public T getCar(Class<T> c, I id) {
		return em.find(c, id);
	}
	
	public T createCar(T entity) {
		em.persist(entity);
		return entity;
	}

	public T updateCar(T entity) {
		em.merge(entity);
		return entity;
	}

	public T deleteCar(T entity) {
		em.remove(entity);
		return entity;
	}
}
