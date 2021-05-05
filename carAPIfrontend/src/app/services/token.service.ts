import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  private url = environment.loginUrl;

  constructor(private http: HttpClient) { }

  public getUserToken(){
    const params = new URLSearchParams();
    params.set('user', 'user');
    params.set('pass', 'user');
    
  }
}
