package com.everis.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.everis.entity.Brand;
import com.everis.entity.BrandDto;
import com.everis.utils.BrandMapper;
import com.everis.utils.LoggerInterceptor;

@Stateless
@Interceptors(LoggerInterceptor.class)
public class BrandService {
	
	private static final Logger LOG = Logger.getLogger(BrandService.class);
	
	@EJB
	private PersistenceService<Brand, String> persistenceService;
	
	private BrandMapper brandMapper = new BrandMapper();
	
	/**
	 * Get a list of brands
	 * @param filterBy the varible to do the filter
	 * @param pages the varible to do the pagination
	 * @param orderBy the varible to order the list
	 * @param size the varible to set the size of the list
	 * @param sort the variable to sort asc o desc the list
	 * @return a brand list
	 */
	public List<Brand> getBrands(String filterBy, int pages, String orderBy, int size, String sort){
		LOG.info("Getting brands list");
		List<Brand> brandList = persistenceService.getAll(Brand.class, filterBy, pages, orderBy, size, sort);
		return brandList;
	}
	
	/**
	 * Get a brand by id
	 * @param id the variable to identify the brand
	 * @return a brand
	 */
	public Brand getBrand(String id) {
		LOG.info("Getting brand by id: " + id);
		Brand brand = persistenceService.getById(Brand.class, id);
		return brand;
	}
	
	/**
	 * Create a brand
	 * @param brand the entity that you gonna create
	 * @return a brand
	 */
	@Transactional
	public Brand createBrand(BrandDto brand) {
		LOG.info("Creating new brand");
		Brand newBrand = persistenceService.createOne(brandMapper.brandDtoToBrand(brand));
		return newBrand;
	}

	/**
	 * Update a brand
	 * @param brand the entity that you gonna create
	 * @return a brand or a null value
	 */
	@Transactional
	public Brand updateBrand(BrandDto brand) {
		LOG.info("Updating brand:");
		Brand brandToUpdate = persistenceService.getById(Brand.class, brand.getId());
		if(brandToUpdate==null) {
			return null;
		}
		else {
			brandToUpdate = persistenceService.updateOne(brandMapper.brandDtoToBrand(brand));
			return brandToUpdate;
		}
	}

	/**
	 * Delete a brand
	 * @param id the variable to identify the brand
	 * @return a brand or a null value
	 */
	@Transactional
	public Brand deleteBrand(String id) {
		LOG.info("Deleting brand by id: " + id);
		Brand brandToDelete = persistenceService.getById(Brand.class, id);
		if(brandToDelete == null) {
			return null;
		}
		else {
			brandToDelete = persistenceService.deleteOne(brandToDelete);
			return brandToDelete;
		}
	}
}
