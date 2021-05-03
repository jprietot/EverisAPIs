import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarTableComponent } from './car-table/car-table.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { MenuComponent } from './menu/menu.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { UpdateCarComponent } from './update-car/update-car.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { BrandTableComponent } from './brand-table/brand-table.component';
import { BrandDetailsComponent } from './brand-details/brand-details.component';
import { CreateBrandComponent } from './create-brand/create-brand.component';
import { UpdateBrandComponent } from './update-brand/update-brand.component';
import { CountryTableComponent } from './country-table/country-table.component';
import { CountryDetailsComponent } from './country-details/country-details.component';
import { CreateCountryComponent } from './create-country/create-country.component';
import { UpdateCountryComponent } from './update-country/update-country.component';

@NgModule({
  declarations: [
    AppComponent,
    CarTableComponent,
    CarDetailsComponent,
    MenuComponent,
    CreateCarComponent,
    UpdateCarComponent,
    BrandTableComponent,
    BrandDetailsComponent,
    CreateBrandComponent,
    UpdateBrandComponent,
    CountryTableComponent,
    CountryDetailsComponent,
    CreateCountryComponent,
    UpdateCountryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
