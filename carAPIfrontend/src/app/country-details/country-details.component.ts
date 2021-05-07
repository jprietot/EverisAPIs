import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Country } from '../model/country';
import { CountryService } from '../services/country.service';

@Component({
  selector: 'app-country-details',
  templateUrl: './country-details.component.html',
  styleUrls: ['./country-details.component.css']
})
export class CountryDetailsComponent implements OnInit {

  countryId: string = this.aroute.snapshot.paramMap.get('id') || "";
  country: Observable<Country> = this.service.getCountry(this.countryId);

  constructor(private service: CountryService, private aroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  public deleteCountry(){
    this.service.deleteCountry(this.countryId).subscribe();
    this.router.navigate(['countries']);
  }

  public updateCountry(){
    this.router.navigate(['updateCountry/', this.countryId]);
  }

}