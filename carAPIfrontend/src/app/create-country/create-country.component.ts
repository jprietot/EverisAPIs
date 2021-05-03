import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Country } from '../model/country';
import { CountryService } from '../services/country.service';

@Component({
  selector: 'app-create-country',
  templateUrl: './create-country.component.html',
  styleUrls: ['./create-country.component.css']
})
export class CreateCountryComponent implements OnInit {

  name!: string;

  constructor(private service: CountryService, private router: Router) { }

  ngOnInit(): void {
  }

  public createCountry(){
    const country = new Country(this.name);
    this.service.createCountry(country).subscribe();
    this.router.navigate(['countries']);
  }
}