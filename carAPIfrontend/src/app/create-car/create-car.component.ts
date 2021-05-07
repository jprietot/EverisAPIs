import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Brand } from '../model/brand';
import { Car } from '../model/car';
import { Country } from '../model/country';
import { BrandService } from '../services/brand.service';
import { CarService } from '../services/car.service';
import { CountryService } from '../services/country.service';

@Component({
  selector: 'app-create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css']
})
export class CreateCarComponent implements OnInit {

  constructor(private carService: CarService, private brandService: BrandService, private countryService: CountryService, private router: Router) { }

  brand!: Brand;
  country!: Country;
  registration!: Date;
  lastUpdated!: Date;
  createdAt!: Date;
  brands: Observable<Brand[]> = this.brandService.getBrands();
  countries: Observable<Country[]> = this.countryService.getCountries();

  ngOnInit(): void {
  }

  getBrand(e: any){
    let currentBrand = e.currentTarget.value;
    this.brandService.getBrand(currentBrand).subscribe(brand => this.brand = brand);
  }

  getCountry(e: any){
    let currentCountry = e.currentTarget.value;
    this.countryService.getCountry(currentCountry).subscribe(country => this.country = country);
  }

  public createCar(){
    const car = new Car(this.brand, this.country, this.registration, this.lastUpdated, this.createdAt);
    this.carService.createCar(car).subscribe();
    this.router.navigate(['cars']);
  }

}
