import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Brand } from '../model/brand';
import { environment } from '../../environments/environment';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private http: HttpClient, private cookieService: CookieService) { }

  private url = environment.brandsUrl;
  private headers = new HttpHeaders().set('Authorization', this.cookieService.get('token'));

  public getBrands(): Observable<Brand[]>{
    return this.http.get<Brand[]>(this.url, {headers: this.headers});
  }

  public getBrand(brandId: string): Observable<Brand>{
    return this.http.get<Brand>(this.url + "/" + brandId, {headers: this.headers});
  }

  public createBrand(brand: Brand): Observable<Brand>{
    return this.http.post<Brand>(this.url, brand, {headers: this.headers});
  }

  public deleteBrand(brandId: string): Observable<Brand>{
    return this.http.delete<Brand>(this.url + "/" + brandId, {headers: this.headers});
  }

  public updateBrand(brandId: string, brand: Brand): Observable<Brand>{
    return this.http.put<Brand>(this.url + "/" + brandId, brand, {headers: this.headers});
  }
}
