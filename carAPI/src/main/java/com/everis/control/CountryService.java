package com.everis.control;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.everis.entity.Country;
import com.everis.entity.CountryDto;
import com.everis.utils.CountryMapper;
import com.everis.utils.LoggerInterceptor;

@Stateless
@Interceptors(LoggerInterceptor.class)
public class CountryService {
	
	private static final Logger LOG = Logger.getLogger(CountryService.class);
	
	@EJB
	private PersistenceService<Country, String> persistenceService;
	
	@Inject
	private CountryMapper countryMapper;
	
	/**
	 * Get a list of countries
	 * @param filterBy the varible to do the filter
	 * @param pages the varible to do the pagination
	 * @param orderBy the varible to order the list
	 * @param size the varible to set the size of the list
	 * @param sort the variable to sort asc o desc the list
	 * @return a country list
	 */
	public List<Country> getCountries(String filterBy, int pages, String orderBy, int size, String sort){
		LOG.info("Getting cars list");
		List<Country> countryList = persistenceService.getAll(Country.class, filterBy, pages, orderBy, size, sort);
		return countryList;
	}
	
	/**
	 * Get a country by id
	 * @param id the variable to identify the country
	 * @return a country
	 */
	public Country getCountry(String id) {
		LOG.info("Getting country by id: " + id);
		Country country = persistenceService.getById(Country.class, id);
		return country;
	}
	
	/**
	 * Create a country
	 * @param country the entity that you gonna create
	 * @return a country
	 */
	@Transactional
	public Country createCountry(CountryDto country) {
		LOG.info("Creating new country");
		Country newCountry = persistenceService.createOne(countryMapper.countryDtoToCountry(country));
		return newCountry;
	}

	/**
	 * Update a country
	 * @param country the entity that you gonna create
	 * @return a country or a null value
	 */
	@Transactional
	public Country updateCountry(CountryDto country) {
		LOG.info("Updating country:");
		Country countryToUpdate = persistenceService.getById(Country.class, country.getId());
		if(countryToUpdate==null) {
			return null;
		}
		else {
			countryToUpdate = persistenceService.updateOne(countryMapper.countryDtoToCountry(country));
			return countryToUpdate;
		}
	}

	/**
	 * Delete a country
	 * @param id the variable to identify the country
	 * @return a country or a null value
	 */
	@Transactional
	public Country deleteCountry(String id) {
		LOG.info("Deleting country by id: " + id);
		Country countryToDelete = persistenceService.getById(Country.class, id);
		if(countryToDelete == null) {
			return null;
		}
		else {
			countryToDelete = persistenceService.deleteOne(countryToDelete);
			return countryToDelete;
		}
	}
}
