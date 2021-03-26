package com.everis.boundary;

import java.net.URI;
import java.util.List;


import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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


@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResource {
	
	private static final Logger LOG = Logger.getLogger(CarResource.class);
	
	@Inject
	private CarService carService;
	
	//Devuelve todos los coches
	@GET
	public Response getCars(){
		LOG.info("Getting cars list");
		List<Car> carList = carService.getCars();
		return Response.status(Status.OK).entity(carList).build();
	}
	
	//Devuelve un coche a traves de una id
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
	
	//Recibe un coche y lo añade al array
	@POST
	public Response createCar(Car car, @Context UriInfo uriInfo) {
		LOG.info("Creating new car");
		Car newCar = carService.createCar(car);
		String newId = String.valueOf(newCar.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newCar).build();
	}

	//Recibe un coche y actualiza sus datos
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

	//Recibe un id de coche y borra el coche con ese id
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
