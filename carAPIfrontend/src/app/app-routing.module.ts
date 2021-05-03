import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BrandDetailsComponent } from './brand-details/brand-details.component';
import { BrandTableComponent } from './brand-table/brand-table.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { CarTableComponent } from './car-table/car-table.component';
import { CountryDetailsComponent } from './country-details/country-details.component';
import { CountryTableComponent } from './country-table/country-table.component';
import { CreateBrandComponent } from './create-brand/create-brand.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { CreateCountryComponent } from './create-country/create-country.component';
import { UpdateBrandComponent } from './update-brand/update-brand.component';
import { UpdateCarComponent } from './update-car/update-car.component';
import { UpdateCountryComponent } from './update-country/update-country.component';

const routes: Routes = [
  {path: 'cars', component: CarTableComponent},
  {path: 'cars/:id', component: CarDetailsComponent},
  {path: 'createCar', component: CreateCarComponent},
  {path: 'updateCar/:id', component: UpdateCarComponent},
  {path: 'brands', component: BrandTableComponent},
  {path: 'brands/:id', component: BrandDetailsComponent},
  {path: 'createBrand', component: CreateBrandComponent},
  {path: 'updateBrand/:id', component: UpdateBrandComponent},
  {path: 'countries', component: CountryTableComponent},
  {path: 'countries/:id', component: CountryDetailsComponent},
  {path: 'createCountry', component: CreateCountryComponent},
  {path: 'updateCountry/:id', component: UpdateCountryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
