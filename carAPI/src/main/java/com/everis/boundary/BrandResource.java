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

import com.everis.control.BrandService;
import com.everis.entity.BrandDto;
import com.everis.utils.BrandMapper;
import com.everis.utils.LoggerInterceptor;


@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Interceptors(LoggerInterceptor.class)
public class BrandResource implements BrandResourceInterface{
	
	private static final Logger LOG = Logger.getLogger(BrandResource.class);
	
	@EJB
	private BrandService brandService;
	
	private BrandMapper brandMapper = new BrandMapper();
	
	/**
	 * Find all brands
	 * @param filterBy the varible to do the filter
	 * @param pages the varible to do the pagination
	 * @param orderBy the varible to order the list
	 * @param size the varible to set the size of the list
	 * @param sort the variable to sort asc o desc the list
	 * @return a status code response
	 */
	@GET
	public Response getBrands(@QueryParam("filter") String filterBy, 
							@DefaultValue("0") @QueryParam("page") int pages, 
							@DefaultValue("id") @QueryParam("order") String orderBy, 
							@DefaultValue("10") @QueryParam("size") int size, 
							@DefaultValue("asc") @QueryParam("sort") String sort){
		LOG.info("Getting brands list");
		List<BrandDto> brandList = brandMapper.brandListToBrandListDto(brandService.getBrands(filterBy, pages, orderBy, size, sort));
		return Response.status(Status.OK).entity(brandList).build();
	}
	
	/**
	 * Find a brand by id
	 * @param id the variable to identify the brand
	 * @return a status code response or a status code response and a brand
	 */
	@GET
	@Path("/{brandId}")
	public Response getBrand(@PathParam("brandId") String id) {
		LOG.info("Getting brand by id: " + id);
		BrandDto brand = brandMapper.brandToBrandDto(brandService.getBrand(id));
		if(brand==null) {
			LOG.error("Brand not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Brand found");
			return Response.status(Status.OK).entity(brand).build();
		}
	}
	
	/**
	 * Create a brand
	 * @param brand the entity that you gonna create
	 * @param uriInfo the URI info that it corresponding to the requested resource
	 * @return a status code response
	 */
	@POST
	public Response createBrand(BrandDto brand, @Context UriInfo uriInfo) {
		LOG.info("Creating new brand");
		BrandDto newBrand = brandMapper.brandToBrandDto(brandService.createBrand(brand));
		String newId = String.valueOf(newBrand.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newBrand).build();
	}

	/**
	 * Update a brand
	 * @param id the variable to identify the brand
	 * @param car the entity that you gonna update
	 * @return a status code response or a status code response and a brand
	 */
	@PUT
	@Path("/{brandId}")
	public Response updateBrand(@PathParam("brandId") String id, BrandDto brand) {
		LOG.info("Updating brand by id: " + id);
		brand.setId(id);
		BrandDto updBrand = brandMapper.brandToBrandDto(brandService.updateBrand(brand));
		if(updBrand==null) {
			LOG.error("Brand not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Brand updated");
			return Response.status(Status.OK).entity(updBrand).build();
		}
	}

	/**
	 * Delete a brand
	 * @param id the variable to identify the brand
	 * @return a status code response or a status code response and a brand
	 */
	@DELETE
	@Path("/{brandId}")
	public Response deleteBrand(@PathParam("brandId") String id) {
		LOG.info("Deleting brand by id: " + id);
		BrandDto deletedBrand = brandMapper.brandToBrandDto(brandService.deleteBrand(id));
		if(deletedBrand==null) {
			LOG.error("Brand not found");
			return Response.status(Status.NOT_FOUND).build();
		}
		else {
			LOG.info("Brand deleted");
			return Response.status(Status.OK).entity(deletedBrand).build();
		}
	}
	
}
