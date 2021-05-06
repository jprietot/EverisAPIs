import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  private url = environment.loginUrl;
  
  public login(user: string, pass: string): Observable<Object>{
    const headers = new HttpHeaders().set('content-type', 'application/json').set('Access-Control-Allow-Origin', '*');
    return this.http.post(this.url+'?user='+user+'&pass='+pass, headers, {observe: 'response'});
  } 
}
