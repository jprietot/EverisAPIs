import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Car } from '../model/car';
import { CarService } from '../services/car.service';

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  carId: string = this.aroute.snapshot.paramMap.get('id') || "";
  car: Observable<Car> = this.service.getCar(this.carId);

  constructor(private service: CarService, private aroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  public deleteCar(){
    this.service.deleteCar(this.carId).subscribe();
    this.router.navigate(['cars']);
  }

  public updateCar(){
    this.router.navigate(['updateCar/', this.carId]);
  }

}
