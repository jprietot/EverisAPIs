import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { BrandService } from '../services/brand.service';
import { Brand } from '../model/brand';

@Component({
  selector: 'app-brand-table',
  templateUrl: './brand-table.component.html',
  styleUrls: ['./brand-table.component.css']
})
export class BrandTableComponent implements OnInit {

  displayedColumns = ['name'];
  dataSource!: MatTableDataSource<Brand>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private service: BrandService, private router: Router) { 
    this.service.getBrands().subscribe(brands =>{
      this.dataSource = new MatTableDataSource(brands);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  ngOnInit(): void {
 
  }

  public getBrand(e: any){
    this.router.navigate(['brands/', e.currentTarget.id]);
  }

  public filter(e: any){
    let filterValue = e.currentTarget.value;
    filterValue = filterValue.trim(); //Remove spaces
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }
}

