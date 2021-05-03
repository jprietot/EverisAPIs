package com.everis.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.everis.entity.Brand;
import com.everis.entity.BrandDto;

public class BrandMapper {
	public BrandDto brandToBrandDto(Brand brand) {
		if(brand==null) {
			return null;
		}
		else {
			BrandDto brandDto = new BrandDto();
			brandDto.setId(brand.getId());
			brandDto.setName(brand.getName());
			return brandDto;
		}
	}
	
	public List<BrandDto> brandListToBrandListDto(List<Brand> brandList){
		if(brandList==null) {
			return null;
		}
		else {
			return brandList.stream().map(brand -> brandToBrandDto(brand)).collect(Collectors.toList());
		}
	}
	
	public Brand brandDtoToBrand(BrandDto brandDto) {
		if(brandDto==null) {
			return null;
		}
		else {
			Brand brand = new Brand();
			brand.setId(brandDto.getId());
			brand.setName(brandDto.getName());
			return brand;
		}
	}
	
	public List<Brand> brandListDtoToBrandList(List<BrandDto> brandListDto){
		if(brandListDto==null) {
			return null;
		}
		else {
			return brandListDto.stream().map(brandDto -> brandDtoToBrand(brandDto)).collect(Collectors.toList());
		}
	}
}
