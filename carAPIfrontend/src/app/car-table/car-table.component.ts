import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Car } from '../model/car';
import { CarService } from '../services/car.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-car-table',
  templateUrl: './car-table.component.html',
  styleUrls: ['./car-table.component.css']
})
export class CarTableComponent implements OnInit {

  displayedColumns = ['brand', 'country'];
  dataSource!: MatTableDataSource<Car>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private service: CarService, private router: Router) { 
    this.service.getCars().subscribe(cars =>{
      this.dataSource = new MatTableDataSource(cars);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  ngOnInit(): void {
 
  }

  public getCar(e: any){
    this.router.navigate(['cars/', e.currentTarget.id]);
  }

  public filter(e: any){
    let filterValue = e.currentTarget.value;
    filterValue = filterValue.trim(); //Remove spaces
    filterValue = filterValue.toLowerCase();
    this.dataSource.filter = filterValue;
  }
}
