package com.everis.utils;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.Dependent;

import com.everis.entity.Country;
import com.everis.entity.CountryDto;

@Dependent
public class CountryMapper {
	public CountryDto countryToCountryDto(Country country) {
		if(country==null) {
			return null;
		}
		else {
			CountryDto countryDto = new CountryDto();
			countryDto.setId(country.getId());
			countryDto.setName(country.getName());
			return countryDto;
		}
	}
	
	public List<CountryDto> countryListToCountryListDto(List<Country> countryList){
		if(countryList==null) {
			return null;
		}
		else {
			return countryList.stream().map(country -> countryToCountryDto(country)).collect(Collectors.toList());
		}
	}
	
	public Country countryDtoToCountry(CountryDto countryDto) {
		if(countryDto==null) {
			return null;
		}
		else {
			Country country = new Country();
			country.setId(countryDto.getId());
			country.setName(countryDto.getName());
			return country;
		}
	}
	
	public List<Country> countryListDtoToCountryList(List<CountryDto> countryListDto){
		if(countryListDto==null) {
			return null;
		}
		else {
			return countryListDto.stream().map(countryDto -> countryDtoToCountry(countryDto)).collect(Collectors.toList());
		}
	}
}
