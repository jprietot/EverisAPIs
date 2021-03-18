package com.everis.boundary;



import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
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

import com.everis.entity.Car;

@Path("/Cars")
public class CarResource {
	
	private static Map<Long, Car> cars = new HashMap<Long, Car>();
	
	public CarResource() {
		// TODO Auto-generated constructor stub
		Car newCar1 = new Car(1, "Coche1", LocalDateTime.now(), "España", LocalDateTime.now(), LocalDateTime.now());
		Car newCar2 = new Car(2, "Coche2", LocalDateTime.now(), "España", LocalDateTime.now(), LocalDateTime.now());
		Car newCar3 = new Car(3, "Coche3", LocalDateTime.now(), "España", LocalDateTime.now(), LocalDateTime.now());
		cars.put(1l, newCar1);
		cars.put(2l, newCar2);
		cars.put(3l, newCar3);
	}
	//Devuelve todos los coches
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getCars(){
		return new ArrayList<Car>(cars.values());
	}
	
	//Devuelve un coche a traves de una id
	@GET
	@Path("/{carId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCar(@PathParam("carId") long id) {
		Car newCar = cars.get(id);
		if(newCar==null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			return Response.status(Status.OK).entity(newCar).build();
		}
	}
	
	//Recibe un coche y lo añade al array
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Car car, @Context UriInfo uriInfo) {
		cars.put(car.getId(), car);
		String newId = String.valueOf(car.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(car).build();
	}

	//Recibe un coche y actualiza sus datos
	@PUT
	@Path("/{carId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCar(@PathParam("carId") long id, Car car) {
		car.setId(id);
		if(car.getId()<=0) {
			//Devolver mediante objeto error
			return Response.status(Status.NOT_FOUND).build();
		}
		cars.put(car.getId(), car);
		return Response.status(Status.OK).entity(car).build();
	}

	//Recibe un id de coche y borra el coche con ese id
	@DELETE
	@Path("/{carId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCar(@PathParam("carId") long id) {
		Car newCar = cars.remove(id);
		//Añadir logica
		if(newCar==null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			return Response.status(Status.OK).entity(newCar).build();
		}
	}
	
}
