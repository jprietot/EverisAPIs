package com.everis.boundary;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.everis.entity.BrandDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


public interface BrandResourceInterface {
	
	@Operation(description = "Get all brands")
	@ApiResponse(responseCode = "200", description = "Returns a list of brands")
	public Response getBrands(String filterBy, int pages, String orderBy, int size, String sort);
	
	@Operation(description = "Get a brand", responses = {
			@ApiResponse(responseCode = "404", description = "Brand not found"),
			@ApiResponse(responseCode = "200", description = "Return brand"),
	})
	@Parameter(description = "Brand id", required = true)
	public Response getBrand(String id);
	
	@Operation(description = "Create a brand")
	@ApiResponse(responseCode = "200", description = "Return the brand that you created")
	@Parameter(description = "Brand", required = true)
	@Parameter(description = "UriInfo", required = true)
	public Response createBrand(BrandDto brand, UriInfo uriInfo);

	@Operation(description = "Update a brand", responses = {
			@ApiResponse(responseCode = "404", description = "Brand not found"),
			@ApiResponse(responseCode = "200", description = "Return the updated brand"),
	})
	@Parameter(description = "Brand id", required = true)
	@Parameter(description = "Brand", required = true)
	public Response updateBrand(String id, BrandDto brand);

	@Operation(description = "Delete a brand", responses = {
			@ApiResponse(responseCode = "404", description = "Brand not found"),
			@ApiResponse(responseCode = "200", description = "Return the deleted brand"),
	})
	@Parameter(description = "Brand id", required = true)
	public Response deleteBrand(String id);
}
