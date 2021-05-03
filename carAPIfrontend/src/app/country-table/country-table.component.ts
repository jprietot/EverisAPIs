import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Country } from '../model/country';
import { CountryService } from '../services/country.service';

@Component({
  selector: 'app-country-table',
  templateUrl: './country-table.component.html',
  styleUrls: ['./country-table.component.css']
})
export class CountryTableComponent implements OnInit {

  displayedColumns = ['name'];
  dataSource!: MatTableDataSource<Country>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private service: CountryService, private router: Router) { 
    this.service.getCountries().subscribe(countries =>{
      this.dataSource = new MatTableDataSource(countries);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  ngOnInit(): void {
 
  }

  public getCountry(e: any){
    this.router.navigate(['countries/', e.currentTarget.id]);
  }

  public filter(e: any){
    let filterValue = e.currentTarget.value;
    filterValue = filterValue.trim(); //Remove spaces
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }
}