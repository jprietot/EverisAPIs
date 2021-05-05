package com.everis.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.Dependent;

import com.everis.entity.Car;
import com.everis.entity.CarDto;

@Dependent
public class CarMapper {
	
	public CarDto carToCarDto(Car car) {
		if(car==null) {
			return null;
		}
		else {
			CarDto carDto = new CarDto();
			carDto.setId(car.getId());
			carDto.setBrand(car.getBrand());
			carDto.setCountry(car.getCountry());
			carDto.setRegistration(car.getRegistration());
			carDto.setCreatedAt(car.getCreatedAt());
			carDto.setLastUpdated(car.getLastUpdated());
			return carDto;
		}
	}
	
	public List<CarDto> carListToCarListDto(List<Car> carList){
		if(carList==null) {
			return null;
		}
		else {
			return carList.stream().map(car -> carToCarDto(car)).collect(Collectors.toList());
		}
	}
	
	public Car carDtoToCar(CarDto carDto) {
		if(carDto==null) {
			return null;
		}
		else {
			Car car = new Car();
			car.setId(carDto.getId());
			car.setBrand(carDto.getBrand());
			car.setCountry(carDto.getCountry());
			car.setRegistration(carDto.getRegistration());
			car.setCreatedAt(carDto.getCreatedAt());
			car.setLastUpdated(carDto.getLastUpdated());
			return car;
		}
	}
	
	public List<Car> carListDtoToCarList(List<CarDto> carListDto){
		if(carListDto==null) {
			return null;
		}
		else {
			return carListDto.stream().map(carDto -> carDtoToCar(carDto)).collect(Collectors.toList());
		}
	}

}
