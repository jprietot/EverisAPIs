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
	
	//Devuelve todos los coches
	public List<Car> getCars(){
		LOG.info("Getting cars list");
		TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c", Car.class);
		return query.getResultList();
	}
	
	//Devuelve un coche a traves de una id
	public Car getCar(long id) {
		LOG.info("Getting car by id: " + id);
		Car car = em.find(Car.class, id);
		return car;
	}
	
	//Recibe un coche y lo añade al array
	@Transactional
	public Car createCar(Car car) {
		LOG.info("Creating new car");
		em.persist(car);
		return car;
	}

	//Recibe un coche y actualiza sus datos
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

	//Recibe un id de coche y borra el coche con ese id
	@Transactional
	public Car deleteCar(long id) {
		LOG.info("Deleting car by id: " + id);
		Car car = getCar(id);
		em.remove(car);
		return car;
	}
}
