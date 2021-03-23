package com.everis.control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.everis.entity.Car;

@Stateless
public class CarService {
	
	@PersistenceContext(unitName = "carAPI")
	private EntityManager em;
	
	//Devuelve todos los coches
	public List<Car> getCars(){
		Query query = em.createQuery("SELECT c FROM Car c");
		return (List<Car>)query.getResultList();
	}
	
	//Devuelve un coche a traves de una id
	public Car getCar(long id) {
		Car car = em.find(Car.class, id);
		return car;
	}
	
	//Recibe un coche y lo añade al array
	@Transactional
	public Car createCar(Car car) {
		em.persist(car);
		return car;
	}

	//Recibe un coche y actualiza sus datos
	@Transactional
	public Car updateCar(Car car) {
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
		Car car = getCar(id);
		em.remove(car);
		return car;
	}
}
