package com.everis.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.everis.entity.Car;
import com.everis.entity.CarDto;
import com.everis.utils.CarMapper;
import com.everis.utils.LoggerInterceptor;

@Stateless
@Interceptors(LoggerInterceptor.class)
public class CarService {
	
	private static final Logger LOG = Logger.getLogger(CarService.class);
	
	@EJB
	private PersistenceService<Car, String> persistenceService;
	
	@Inject
	private CarMapper carMapper;
	
	/**
	 * Get a list of cars
	 * @param filterBy the varible to do the filter
	 * @param pages the varible to do the pagination
	 * @param orderBy the varible to order the list
	 * @param size the varible to set the size of the list
	 * @param sort the variable to sort asc o desc the list
	 * @return a car list
	 */
	public List<Car> getCars(String filterBy, int pages, String orderBy, int size, String sort){
		LOG.info("Getting cars list");
		List<Car> carList = persistenceService.getAll(Car.class, filterBy, pages, orderBy, size, sort);
		return carList;
	}
	
	/**
	 * Get a car by id
	 * @param id the variable to identify the car
	 * @return a car
	 */
	public Car getCar(String id) {
		LOG.info("Getting car by id: " + id);
		Car car = persistenceService.getById(Car.class, id);
		return car;
	}
	
	/**
	 * Create a car
	 * @param car the entity that you gonna create
	 * @return a car
	 */
	@Transactional
	public Car createCar(CarDto car) {
		LOG.info("Creating new car");
		Car newCar = persistenceService.createOne(carMapper.carDtoToCar(car));
		return newCar;
	}

	/**
	 * Update a car
	 * @param car the entity that you gonna create
	 * @return a car or a null value
	 */
	@Transactional
	public Car updateCar(CarDto car) {
		LOG.info("Updating car:");
		Car carToUpdate = persistenceService.getById(Car.class, car.getId());
		if(carToUpdate==null) {
			return null;
		}
		else {
			carToUpdate = persistenceService.updateOne(carMapper.carDtoToCar(car));
			return carToUpdate;
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
		Car carToDelete = persistenceService.getById(Car.class, id);
		if(carToDelete == null) {
			return null;
		}
		else {
			carToDelete = persistenceService.deleteOne(carToDelete);
			return carToDelete;
		}
	}
}
