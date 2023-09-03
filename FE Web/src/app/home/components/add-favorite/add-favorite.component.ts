import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ICurrency } from '../../models/currency';
@Component({
  selector: 'app-add-favorite',
  templateUrl: './add-favorite.component.html',
  styleUrls: ['./add-favorite.component.scss'],
})
export class AddFavoriteComponent {
  @Input() currencies: ICurrency[] = [];
  @Output() currenciesChange = new EventEmitter<ICurrency[]>();

  onCheckChange(ev: ICurrency) {
    this.currencies = this.currencies.map((e) => {
      if (e.code === ev.code) {
        return { ...e, checked: !ev.checked };
      } else return e;
    });
    this.currenciesChange.emit(this.currencies);
  }
}
