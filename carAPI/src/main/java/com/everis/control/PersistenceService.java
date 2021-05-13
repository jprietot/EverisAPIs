package com.everis.control;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javax.persistence.criteria.Predicate;

@Stateless
public class PersistenceService<T,I> {
	
	@PersistenceContext(unitName = "carAPI")
	private EntityManager em;

	public List<T> getAll(Class<T> c, String filterBy, int pages, String orderBy, int size, String sort){
		
		if(sort==null) {
			sort="asc";
		}
		if(orderBy==null) {
			orderBy="id";
		}
		if(pages<=0) {
			pages=0;
		}
		if(size<=0 || size >=20) {
			size=10;
		}
		
		TypedQuery<T> query = filters(c, filterBy, orderBy, sort);
		
		query.setMaxResults(size);
		query.setFirstResult(pages*size);
		
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
	
	private TypedQuery<T> filters(Class<T> c, String filterBy, String orderBy, String sort){
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(c);
		Root<T> root = criteriaQuery.from(c);
		
		if(filterBy!=null) {
			Predicate brandPredict = criteriaBuilder.like(root.get("brand"), "%"+filterBy+"%");
			Predicate countryPredict = criteriaBuilder.like(root.get("country"), "%"+filterBy+"%");
			Predicate chosePredict = criteriaBuilder.or(brandPredict, countryPredict);
			criteriaQuery.where(chosePredict);
		}
		
		if(sort.equals("asc")) {
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get(orderBy)));
		}
		else {
			criteriaQuery.orderBy(criteriaBuilder.desc(root.get(orderBy)));
		}
		
		return em.createQuery(criteriaQuery);
	}
	
	public void execNamedQuery(String query) {
		Query q = em.createNamedQuery(query);
		q.executeUpdate();
	}
	
}
