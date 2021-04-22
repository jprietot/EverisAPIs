import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Car } from '../model/car';
import { CarService } from '../services/car.service';

@Component({
  selector: 'app-create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css']
})
export class CreateCarComponent implements OnInit {

  private brand!: string;
  private country!: string;
  private registration!: Date;
  private lastUpdated!: Date;
  private createdAt!: Date;

  constructor(private service: CarService, private router: Router) { }

  ngOnInit(): void {
  }

  public createCar(){
    const car = new Car(this.brand, this.country, this.registration, this.lastUpdated, this.createdAt);
    this.service.createCar(car).subscribe();
    this.router.navigate(['cars']);
  }

}
