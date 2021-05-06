import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Country } from '../model/country';
import { environment } from '../../environments/environment';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  constructor(private http: HttpClient, private cookieService: CookieService) { }

  private url = environment.countriesUrl;
  private headers = new HttpHeaders().set('Authorization', this.cookieService.get('token'));

  public getCountries(): Observable<Country[]>{
    return this.http.get<Country[]>(this.url, {headers: this.headers});
  }

  public getCountry(countryId: string): Observable<Country>{
    return this.http.get<Country>(this.url + "/" + countryId, {headers: this.headers});
  }

  public createCountry(country: Country): Observable<Country>{
    return this.http.post<Country>(this.url, country, {headers: this.headers});
  }

  public deleteCountry(countryId: string): Observable<Country>{
    return this.http.delete<Country>(this.url + "/" + countryId, {headers: this.headers});
  }

  public updateCountry(countryId: string, country: Country): Observable<Country>{
    return this.http.put<Country>(this.url + "/" + countryId, country, {headers: this.headers});
  }
}
