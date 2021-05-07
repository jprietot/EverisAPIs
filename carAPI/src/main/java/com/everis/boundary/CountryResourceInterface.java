package com.everis.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.everis.entity.CountryDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


public interface CountryResourceInterface {
	
	@Operation(description = "Get all countries")
	@ApiResponse(responseCode = "200", description = "Returns a list of countries")
	public Response getCountries(String filterBy, int pages, String orderBy, int size, String sort);
	
	@Operation(description = "Get a country", responses = {
			@ApiResponse(responseCode = "404", description = "Country not found"),
			@ApiResponse(responseCode = "200", description = "Return country"),
	})
	@Parameter(description = "Country id", required = true)
	public Response getCountry(String id);
	
	@Operation(description = "Create a country")
	@ApiResponse(responseCode = "200", description = "Return the country that you created")
	@Parameter(description = "Country", required = true)
	@Parameter(description = "UriInfo", required = true)
	public Response createCountry(CountryDto country, UriInfo uriInfo);

	@Operation(description = "Update a country", responses = {
			@ApiResponse(responseCode = "404", description = "Country not found"),
			@ApiResponse(responseCode = "200", description = "Return the updated country"),
	})
	@Parameter(description = "Country id", required = true)
	@Parameter(description = "Country", required = true)
	public Response updateCountry(String id, CountryDto country);

	@Operation(description = "Delete a country", responses = {
			@ApiResponse(responseCode = "404", description = "Country not found"),
			@ApiResponse(responseCode = "200", description = "Return the deleted country"),
	})
	@Parameter(description = "Country id", required = true)
	public Response deleteCountry(String id);
}
