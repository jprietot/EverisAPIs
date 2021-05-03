import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Country } from '../model/country';
import { CountryService } from '../services/country.service';

@Component({
  selector: 'app-update-country',
  templateUrl: './update-country.component.html',
  styleUrls: ['./update-country.component.css']
})
export class UpdateCountryComponent implements OnInit {

  countryId: string = this.aroute.snapshot.paramMap.get('id') || "";
  name!: string;

  constructor(private service: CountryService, private router: Router, private aroute: ActivatedRoute) { }

  ngOnInit(): void {
  }

  public updateCountry(){
    const country = new Country(this.name);
    this.service.updateCountry(this.countryId, country).subscribe();
    this.router.navigate(['countries/', this.countryId]);
  }
}
