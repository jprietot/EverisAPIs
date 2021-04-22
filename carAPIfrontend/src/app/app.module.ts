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

@NgModule({
  declarations: [
    AppComponent,
    CarTableComponent,
    CarDetailsComponent,
    MenuComponent,
    CreateCarComponent,
    UpdateCarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
