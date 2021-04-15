package com.everis.control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
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
	
	@EJB
	private PersistenceService<Car, String> persistenceService;
	
	/**
	 * Get a list of cars
	 * @return a car list
	 */
	public List<Car> getCars(){
		LOG.info("Getting cars list");
		return persistenceService.getAll("Car.GetAllCars", Car.class);
	}
	
	/**
	 * Get a car by id
	 * @param id the variable to identify the car
	 * @return a car
	 */
	public Car getCar(String id) {
		LOG.info("Getting car by id: " + id);
		return persistenceService.getById(Car.class, id);
	}
	
	/**
	 * Create a car
	 * @param car the entity that you gonna create
	 * @return a car
	 */
	@Transactional
	public Car createCar(Car car) {
		LOG.info("Creating new car");
		return persistenceService.createOne(car);
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
			return persistenceService.updateOne(car);
		}
	}

	/**
	 * Delete a car
	 * @param id the variable to identify the car
	 * @return a car or a null value
	 */
	@Transactional
	public Car deleteCar(String id) {
		LOG.info("Deleting car by id: " + id);
		Car car = getCar(id);
		if(car == null) {
			return null;
		}
		else {
			return persistenceService.deleteOne(car);
		}
	}
}
