import { Component } from '@angular/core';
import { CurrencyService } from '../../services/currency.service';
import { ICurrency } from '../../models/currency';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.scss'],
})
export class ContainerComponent {
  showFav = 'none';
  currencies: ICurrency[] =
    JSON.parse(localStorage.getItem('curencies') || '[]') ?? [];

  data: ICurrency[] = [];

  constructor(private currencyService: CurrencyService) {
    this.currencyService.getCurrenciesValues().subscribe((data) => {
      this.currencies = data.map((e) => {
        let found = this.currencies.find((d) => d.code === e.code);
        if (found) {
          return { ...e, checked: true };
        } else return e;
      });
    });
  }

  showFavoriteEvent(ev: string) {
    this.showFav = ev;
  }

  openPopup() {
    this.showFav = 'block';
  }

  closePopup() {
    this.showFav = 'none';
  }
}
