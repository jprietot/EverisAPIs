import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../model/car';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }

  private url = environment.carsUrl;

  public getCars(): Observable<Car[]>{
    return this.http.get<Car[]>(this.url);
  }

  public getCar(carId: string): Observable<Car>{
    return this.http.get<Car>(this.url + "/" + carId);
  }

  public createCar(car: Car): Observable<Car>{
    return this.http.post<Car>(this.url, car);
  }

  public deleteCar(carId: string): Observable<Car>{
    return this.http.delete<Car>(this.url + "/" + carId);
  }

  public updateCar(carId: string, car: Car): Observable<Car>{
    return this.http.put<Car>(this.url + "/" + carId, car);
  }
  
}
