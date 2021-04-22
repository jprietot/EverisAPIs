import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Car } from '../model/car';
import { CarService } from '../services/car.service';

@Component({
  selector: 'app-update-car',
  templateUrl: './update-car.component.html',
  styleUrls: ['./update-car.component.css']
})
export class UpdateCarComponent implements OnInit {

  carId: string = this.aroute.snapshot.paramMap.get('id') || "";

  brand!: string;
  country!: string;
  registration!: Date;
  lastUpdated!: Date;
  createdAt!: Date;

  constructor(private service: CarService, private aroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  public updateCar(){
    const car = new Car(this.brand, this.country, this.registration, this.lastUpdated, this.createdAt);
    this.service.updateCar(this.carId, car).subscribe();
    this.router.navigate(['cars/', this.carId]);
  }

}
