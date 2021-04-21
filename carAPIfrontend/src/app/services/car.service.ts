import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../model/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }

  public  getCars(): Observable<Car[]>{
    const url = "http://desktop-i5ipudi:8080/carAPI-0.0.1-SNAPSHOT/cars";
    return this.http.get<Car[]>(url);
  }
}
