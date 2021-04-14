package com.everis.boundary;

import java.net.URI;
import java.util.List;


import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.everis.control.CarService;
import com.everis.entity.Car;
import com.everis.utils.LoggerInterceptor;


@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Interceptors(LoggerInterceptor.class)
public class CarResource implements CarResourceInterface{
	
	private static final Logger LOG = Logger.getLogger(CarResource.class);
	
	@EJB
	private CarService carService;
	
	/**
	 * Find all cars
	 * @return a status code response
	 */
	@GET
	public Response getCars(){
		LOG.info("Getting cars list");
		List<Car> carList = carService.getCars();
		return Response.status(Status.OK).entity(carList).build();
	}
	
	/**
	 * Find a car by id
	 * @param id the variable to identify the car
	 * @return a status code response or a status code response and a car
	 */
	@GET
	@Path("/{carId}")
	public Response getCar(@PathParam("carId") long id) {
		LOG.info("Getting car by id: " + id);
		Car car = carService.getCar(id);
		if(car==null) {
			LOG.error("Car not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Car found");
			return Response.status(Status.OK).entity(car).build();
		}
	}
	
	/**
	 * Create a car
	 * @param car the entity that you gonna create
	 * @param uriInfo the URI info that it corresponding to the requested resource
	 * @return a status code response
	 */
	@POST
	public Response createCar(Car car, @Context UriInfo uriInfo) {
		LOG.info("Creating new car");
		Car newCar = carService.createCar(car);
		String newId = String.valueOf(newCar.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newCar).build();
	}

	/**
	 * Update a car
	 * @param id the variable to identify the car
	 * @param car the entity that you gonna update
	 * @return a status code response or a status code response and a car
	 */
	@PUT
	@Path("/{carId}")
	public Response updateCar(@PathParam("carId") long id, Car car) {
		LOG.info("Updating car by id: " + id);
		car.setId(id);
		Car updCar = carService.updateCar(car);
		if(updCar==null) {
			LOG.error("Car not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Car updated");
			return Response.status(Status.OK).entity(updCar).build();
		}
	}

	/**
	 * Delete a car
	 * @param id the variable to identify the car
	 * @return a status code response or a status code response and a car
	 */
	@DELETE
	@Path("/{carId}")
	public Response deleteCar(@PathParam("carId") long id) {
		LOG.info("Deleting car by id: " + id);
		Car deletedCar = carService.deleteCar(id);
		if(deletedCar==null) {
			LOG.error("Car not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Car deleted");
			return Response.status(Status.OK).entity(deletedCar).build();
		}
	}
	
}
