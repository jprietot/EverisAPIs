import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Brand } from '../model/brand';
import { BrandService } from '../services/brand.service';

@Component({
  selector: 'app-update-brand',
  templateUrl: './update-brand.component.html',
  styleUrls: ['./update-brand.component.css']
})
export class UpdateBrandComponent implements OnInit {

  brandId: string = this.aroute.snapshot.paramMap.get('id') || "";
  name!: string;

  constructor(private service: BrandService, private router: Router, private aroute: ActivatedRoute) { }

  ngOnInit(): void {
  }

  public updateBrand(){
    const brand = new Brand(this.name);
    this.service.updateBrand(this.brandId, brand).subscribe();
    this.router.navigate(['brands/', this.brandId]);
  }
}
