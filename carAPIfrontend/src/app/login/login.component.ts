import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private cookieService: CookieService, private router: Router) { }
  user!: string;
  pass!: string;

  ngOnInit(): void {
  }

  public login(){
    this.loginService.login(this.user, this.pass).subscribe((data: any) =>{
      if(data.status == 200){
        let token: string = data.headers.get('Authorization');
        console.log(token);
        this.cookieService.set('token', token);
        this.router.navigate(['/']);
      }
    });
  }

}
