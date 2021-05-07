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
import { GuardGuard } from './guard/guard.guard';
import { LoginComponent } from './login/login.component';
import { UpdateBrandComponent } from './update-brand/update-brand.component';
import { UpdateCarComponent } from './update-car/update-car.component';
import { UpdateCountryComponent } from './update-country/update-country.component';

const routes: Routes = [
  {path: '',  redirectTo: '/cars', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'cars', component: CarTableComponent, canActivate: [GuardGuard]},
  {path: 'cars/:id', component: CarDetailsComponent, canActivate: [GuardGuard]},
  {path: 'createCar', component: CreateCarComponent, canActivate: [GuardGuard]},
  {path: 'updateCar/:id', component: UpdateCarComponent, canActivate: [GuardGuard]},
  {path: 'brands', component: BrandTableComponent, canActivate: [GuardGuard]},
  {path: 'brands/:id', component: BrandDetailsComponent, canActivate: [GuardGuard]},
  {path: 'createBrand', component: CreateBrandComponent, canActivate: [GuardGuard]},
  {path: 'updateBrand/:id', component: UpdateBrandComponent, canActivate: [GuardGuard]},
  {path: 'countries', component: CountryTableComponent, canActivate: [GuardGuard]},
  {path: 'countries/:id', component: CountryDetailsComponent, canActivate: [GuardGuard]},
  {path: 'createCountry', component: CreateCountryComponent, canActivate: [GuardGuard]},
  {path: 'updateCountry/:id', component: UpdateCountryComponent, canActivate: [GuardGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
