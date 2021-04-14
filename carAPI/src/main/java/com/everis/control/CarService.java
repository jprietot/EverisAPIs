package com.everis.control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.everis.entity.Car;
import com.everis.utils.LoggerInterceptor;

@Stateless
@Interceptors(LoggerInterceptor.class)
public class CarService {
	
	private static final Logger LOG = Logger.getLogger(CarService.class);
	
	@PersistenceContext(unitName = "carAPI")
	private EntityManager em;
	
	/**
	 * Get a list of cars
	 * @return a car list
	 */
	public List<Car> getCars(){
		LOG.info("Getting cars list");
		TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c", Car.class);
		return query.getResultList();
	}
	
	/**
	 * Get a car by id
	 * @param id the variable to identify the car
	 * @return a car
	 */
	public Car getCar(long id) {
		LOG.info("Getting car by id: " + id);
		Car car = em.find(Car.class, id);
		return car;
	}
	
	/**
	 * Create a car
	 * @param car the entity that you gonna create
	 * @return a car
	 */
	@Transactional
	public Car createCar(Car car) {
		LOG.info("Creating new car");
		em.persist(car);
		return car;
	}

	/**
	 * Update a car
	 * @param car the entity that you gonna create
	 * @return a car or a null value
	 */
	@Transactional
	public Car updateCar(Car car) {
		LOG.info("Updating car:");
		if(getCar(car.getId())==null) {
			return null;
		}
		else {
			em.merge(car);
			return car;
		}
	}

	/**
	 * Delete a car
	 * @param id the variable to identify the car
	 * @return a car or a null value
	 */
	@Transactional
	public Car deleteCar(long id) {
		LOG.info("Deleting car by id: " + id);
		Car car = getCar(id);
		if(car == null) {
			return null;
		}
		else {
			em.remove(car);
			return car;
		}
	}
}
