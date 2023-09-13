import { Component, Output, EventEmitter, Input, OnChanges, SimpleChanges } from '@angular/core';
import { CurrencyService } from '../../services/currency.service';
import { ICurrency } from '../../models/currency';

@Component({
  selector: 'app-currency-list',
  templateUrl: './currency-list.component.html',
  styleUrls: ['./currency-list.component.scss'],
})
export class CurrencyListComponent implements OnChanges{
 @Input() currencies: ICurrency[]= [];

  @Output() showFavorite = new EventEmitter();

  constructor(private currencyService: CurrencyService) {
   
  
  }
  ngOnChanges(changes: SimpleChanges): void {
    if(this.currencies.length){
      this.currencies = this.currencies.filter(e=> e.checked);
      localStorage.setItem('curencies',JSON.stringify(this.currencies))
    }
  }

  addToFaviorites() {
    this.showFavorite.emit("block");
  }
}
