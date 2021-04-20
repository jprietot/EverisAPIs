package com.everis.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.everis.entity.Car;
import com.everis.entity.CarDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


public interface CarResourceInterface {
	
	@Operation(description = "Get all cars")
	@ApiResponse(responseCode = "200", description = "Returns a list of cars")
	public Response getCars(String filterBy, int pages, String orderBy, int size, String sort);
	
	@Operation(description = "Get a car", responses = {
			@ApiResponse(responseCode = "404", description = "Car not found"),
			@ApiResponse(responseCode = "200", description = "Return car"),
	})
	@Parameter(description = "Car id", required = true)
	public Response getCar(String id);
	
	@Operation(description = "Create a car")
	@ApiResponse(responseCode = "200", description = "Return the car that you created")
	@Parameter(description = "Car", required = true)
	@Parameter(description = "UriInfo", required = true)
	public Response createCar(CarDto car, UriInfo uriInfo);

	@Operation(description = "Update a car", responses = {
			@ApiResponse(responseCode = "404", description = "Car not found"),
			@ApiResponse(responseCode = "200", description = "Return the updated car"),
	})
	@Parameter(description = "Car id", required = true)
	@Parameter(description = "Car", required = true)
	public Response updateCar(String id, CarDto car);

	@Operation(description = "Delete a car", responses = {
			@ApiResponse(responseCode = "404", description = "Car not found"),
			@ApiResponse(responseCode = "200", description = "Return the deleted car"),
	})
	@Parameter(description = "Car id", required = true)
	public Response deleteCar(String id);
}
