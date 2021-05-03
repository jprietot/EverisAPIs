import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Brand } from '../model/brand';
import { Car } from '../model/car';
import { Country } from '../model/country';
import { BrandService } from '../services/brand.service';
import { CarService } from '../services/car.service';
import { CountryService } from '../services/country.service';

@Component({
  selector: 'app-update-car',
  templateUrl: './update-car.component.html',
  styleUrls: ['./update-car.component.css']
})
export class UpdateCarComponent implements OnInit {

  carId: string = this.aroute.snapshot.paramMap.get('id') || "";

  constructor(private carService: CarService, private brandService: BrandService, private countryService: CountryService, private router: Router, private aroute: ActivatedRoute) { }

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

  public updateCar(){
    const car = new Car(this.brand, this.country, this.registration, this.lastUpdated, this.createdAt);
    this.carService.updateCar(this.carId, car).subscribe();
    this.router.navigate(['cars/', this.carId]);
  }

}
