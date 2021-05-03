import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Brand } from '../model/brand';
import { BrandService } from '../services/brand.service';

@Component({
  selector: 'app-brand-details',
  templateUrl: './brand-details.component.html',
  styleUrls: ['./brand-details.component.css']
})
export class BrandDetailsComponent implements OnInit {

  brandId: string = this.aroute.snapshot.paramMap.get('id') || "";
  brand: Observable<Brand> = this.service.getBrand(this.brandId);

  constructor(private service: BrandService, private aroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }

  public deleteBrand(){
    this.service.deleteBrand(this.brandId).subscribe();
    this.router.navigate(['brands']);
  }

  public updateBrand(){
    this.router.navigate(['updateBrand/', this.brandId]);
  }

}