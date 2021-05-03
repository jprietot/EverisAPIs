import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Country } from '../model/country';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(private http: HttpClient) { }

  private url = environment.countriesUrl;

  public getCountries(): Observable<Country[]>{
    return this.http.get<Country[]>(this.url);
  }

  public getCountry(countryId: string): Observable<Country>{
    return this.http.get<Country>(this.url + "/" + countryId);
  }

  public createCountry(country: Country): Observable<Country>{
    return this.http.post<Country>(this.url, country);
  }

  public deleteCountry(countryId: string): Observable<Country>{
    return this.http.delete<Country>(this.url + "/" + countryId);
  }

  public updateCountry(countryId: string, country: Country): Observable<Country>{
    return this.http.put<Country>(this.url + "/" + countryId, country);
  }
}
