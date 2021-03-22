package com.everis.control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.everis.entity.Car;

public class CarService {
	
	private static Map<Long, Car> cars = new HashMap<Long, Car>();
	
	public CarService() {
		Car newCar1 = new Car(1, "Coche1", LocalDateTime.now(), "España", LocalDateTime.now(), LocalDateTime.now());
		Car newCar2 = new Car(2, "Coche2", LocalDateTime.now(), "España", LocalDateTime.now(), LocalDateTime.now());
		Car newCar3 = new Car(3, "Coche3", LocalDateTime.now(), "España", LocalDateTime.now(), LocalDateTime.now());
		cars.put(1l, newCar1);
		cars.put(2l, newCar2);
		cars.put(3l, newCar3);
	}
	
	//Devuelve todos los coches
	public List<Car> getCars(){
		return new ArrayList<Car>(cars.values());
	}
	
	//Devuelve un coche a traves de una id
	public Car getCar(long id) {
		return cars.get(id);
	}
	
	//Recibe un coche y lo añade al array
	public Car createCar(Car car) {
		car.setId(cars.size()+1);
		cars.put(car.getId(), car);
		return car;
	}

	//Recibe un coche y actualiza sus datos
	public Car updateCar(Car car) {
		//Comprobar que el coche existe
		if(!cars.containsKey(car.getId())) {
			return null;
		}
		else {
			cars.put(car.getId(), car);
			return car;
		}
	}

	//Recibe un id de coche y borra el coche con ese id
	public Car deleteCar(long id) {
		return cars.remove(id);
	}
}
