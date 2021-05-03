import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Brand } from '../model/brand';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private http: HttpClient) { }

  private url = environment.brandsUrl;

  public getBrands(): Observable<Brand[]>{
    return this.http.get<Brand[]>(this.url);
  }

  public getBrand(brandId: string): Observable<Brand>{
    return this.http.get<Brand>(this.url + "/" + brandId);
  }

  public createBrand(brand: Brand): Observable<Brand>{
    return this.http.post<Brand>(this.url, brand);
  }

  public deleteBrand(brandId: string): Observable<Brand>{
    return this.http.delete<Brand>(this.url + "/" + brandId);
  }

  public updateBrand(brandId: string, brand: Brand): Observable<Brand>{
    return this.http.put<Brand>(this.url + "/" + brandId, brand);
  }
}
