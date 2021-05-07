import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Brand } from '../model/brand';
import { BrandService } from '../services/brand.service';

@Component({
  selector: 'app-create-brand',
  templateUrl: './create-brand.component.html',
  styleUrls: ['./create-brand.component.css']
})
export class CreateBrandComponent implements OnInit {

  name!: string;

  constructor(private service: BrandService, private router: Router) { }

  ngOnInit(): void {
  }

  public createBrand(){
    const brand = new Brand(this.name);
    this.service.createBrand(brand).subscribe();
    this.router.navigate(['brands']);
  }
}
