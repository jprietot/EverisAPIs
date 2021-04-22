import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private service: CarService, private router: Router) { }

  ngOnInit(): void {
 
  }

  public getCar(e: any){
    this.router.navigate(['cars/', e.currentTarget.id]);
  }

}
