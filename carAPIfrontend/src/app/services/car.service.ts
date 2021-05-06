import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../model/car';
import { environment } from '../../environments/environment';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient, private cookieService: CookieService) { }

  private url = environment.carsUrl;
  private headers = new HttpHeaders().set('Authorization', this.cookieService.get('token'));

  public getCars(): Observable<Car[]>{
    return this.http.get<Car[]>(this.url, {headers: this.headers});
  }

  public getCar(carId: string): Observable<Car>{
    return this.http.get<Car>(this.url + "/" + carId, {headers: this.headers});
  }

  public createCar(car: Car): Observable<Car>{
    return this.http.post<Car>(this.url, car, {headers: this.headers});
  }

  public deleteCar(carId: string): Observable<Car>{
    return this.http.delete<Car>(this.url + "/" + carId, {headers: this.headers});
  }

  public updateCar(carId: string, car: Car): Observable<Car>{
    return this.http.put<Car>(this.url + "/" + carId, car, {headers: this.headers});
  }
  
}
