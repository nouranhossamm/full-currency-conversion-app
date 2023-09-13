// ParentComponent TypeScript
import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import { CurrencyService } from '../../services/currency.service';
import { ICurrency } from '../../models/currency';

@Component({
  selector: 'app-parent',
  templateUrl: './concurrency.component.html',
  styleUrls: ['./concurrency.component.css'],
})
export class ConcurrencyComponent implements OnInit {
  isTrue: boolean = true;

  isConvertActive: boolean = true; // Initial form to display
  data: ICurrency[] = [];
  constructor(private currencyService: CurrencyService) {
    this.currencyService.getCurriencies().subscribe({
      next: (data) => {
        this.data = data.data; // Store the response in the variable
      },
      error: (error) => {
        // handle error
      },
    });
  }
  ngOnInit() {}
  changeToCompareForm() {
    this.isConvertActive = false;
    this.isTrue = false;
  }
  changeToConvertForm() {
    this.isConvertActive = true;
    this.isTrue = true;
  }
}
