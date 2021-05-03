package com.everis.boundary;

import java.net.URI;
import java.util.List;


import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ejb.EJB;
import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
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

import com.everis.control.CountryService;
import com.everis.entity.CountryDto;
import com.everis.utils.CountryMapper;
import com.everis.utils.LoggerInterceptor;


@Path("/countries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Interceptors(LoggerInterceptor.class)
public class CountryResource implements CountryResourceInterface{
	
	private static final Logger LOG = Logger.getLogger(CountryResource.class);
	
	@EJB
	private CountryService countryService;
	
	private CountryMapper countryMapper = new CountryMapper();
	
	/**
	 * Find all countries
	 * @param filterBy the varible to do the filter
	 * @param pages the varible to do the pagination
	 * @param orderBy the varible to order the list
	 * @param size the varible to set the size of the list
	 * @param sort the variable to sort asc o desc the list
	 * @return a status code response
	 */
	@GET
	public Response getCountries(@QueryParam("filter") String filterBy, 
							@DefaultValue("0") @QueryParam("page") int pages, 
							@DefaultValue("id") @QueryParam("order") String orderBy, 
							@DefaultValue("10") @QueryParam("size") int size, 
							@DefaultValue("asc") @QueryParam("sort") String sort){
		LOG.info("Getting brands list");
		List<CountryDto> countryList = countryMapper.countryListToCountryListDto(countryService.getCountries(filterBy, pages, orderBy, size, sort));
		return Response.status(Status.OK).entity(countryList).build();
	}
	
	/**
	 * Find a country by id
	 * @param id the variable to identify the country
	 * @return a status code response or a status code response and a country
	 */
	@GET
	@Path("/{countryId}")
	public Response getCountry(@PathParam("countryId") String id) {
		LOG.info("Getting country by id: " + id);
		CountryDto country = countryMapper.countryToCountryDto(countryService.getCountry(id));
		if(country==null) {
			LOG.error("Country not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Country found");
			return Response.status(Status.OK).entity(country).build();
		}
	}
	
	/**
	 * Create a country
	 * @param country the entity that you gonna create
	 * @param uriInfo the URI info that it corresponding to the requested resource
	 * @return a status code response
	 */
	@POST
	public Response createCountry(CountryDto country, @Context UriInfo uriInfo) {
		LOG.info("Creating new country");
		CountryDto newCountry = countryMapper.countryToCountryDto(countryService.createCountry(country));
		String newId = String.valueOf(newCountry.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newCountry).build();
	}

	/**
	 * Update a country
	 * @param id the variable to identify the country
	 * @param country the entity that you gonna update
	 * @return a status code response or a status code response and a country
	 */
	@PUT
	@Path("/{countryId}")
	public Response updateCountry(@PathParam("countryId") String id, CountryDto country) {
		LOG.info("Updating country by id: " + id);
		country.setId(id);
		CountryDto updCountry = countryMapper.countryToCountryDto(countryService.updateCountry(country));
		if(updCountry==null) {
			LOG.error("Country not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Country updated");
			return Response.status(Status.OK).entity(updCountry).build();
		}
	}

	/**
	 * Delete a country
	 * @param id the variable to identify the country
	 * @return a status code response or a status code response and a country
	 */
	@DELETE
	@Path("/{countryId}")
	public Response deleteCountry(@PathParam("countryId") String id) {
		LOG.info("Deleting country by id: " + id);
		CountryDto deletedCountry = countryMapper.countryToCountryDto(countryService.deleteCountry(id));
		if(deletedCountry==null) {
			LOG.error("Country not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Country deleted");
			return Response.status(Status.OK).entity(deletedCountry).build();
		}
	}
	
}
