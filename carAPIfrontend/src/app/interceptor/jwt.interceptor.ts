import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { catchError } from 'rxjs/operators';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private router: Router, private cookieService: CookieService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token: string = this.cookieService.get('token');
    let req = request;
    if(token){
      req = request.clone({
        setHeaders: {
          authorization: 'Bearer ' + token
        }
      })
    }
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) =>{
        if(error.status === 401){
          this.router.navigateByUrl('/login');
        }
        return throwError(error);
      })
    );
  }
}
