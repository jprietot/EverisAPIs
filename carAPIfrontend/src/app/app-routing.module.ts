import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarDetailsComponent } from './car-details/car-details.component';
import { CarTableComponent } from './car-table/car-table.component';
import { CreateCarComponent } from './create-car/create-car.component';
import { UpdateCarComponent } from './update-car/update-car.component';

const routes: Routes = [
  {path: 'cars', component: CarTableComponent},
  {path: 'cars/:id', component: CarDetailsComponent},
  {path: 'createCar', component: CreateCarComponent},
  {path: 'updateCar/:id', component: UpdateCarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
