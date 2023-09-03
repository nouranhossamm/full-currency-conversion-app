// data.component.ts
import { MatSelectModule } from '@angular/material/select';
import { Component, OnInit } from '@angular/core';
import { CurrencyService } from '../../services/currency.service';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
})
export class DataComponent implements OnInit {
  fetchedData: any; // You can define the type of your data here

  constructor(private currencyService: CurrencyService) {}

  ngOnInit() {
    this.currencyService.getCurriencies().subscribe(
      (data: any) => {
        this.fetchedData = Object.keys(data.conversion_rates);
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }
}
