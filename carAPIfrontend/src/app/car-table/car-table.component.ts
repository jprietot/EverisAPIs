import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../model/car';
import { CarService } from '../services/car.service';

@Component({
  selector: 'app-car-table',
  templateUrl: './car-table.component.html',
  styleUrls: ['./car-table.component.css']
})
export class CarTableComponent implements OnInit {

  cars: Observable<Car[]> = this.service.getCars();

  constructor(private service: CarService) { }

  ngOnInit(): void {
 
  }

}
