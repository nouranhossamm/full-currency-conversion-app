import { Component, Input } from '@angular/core';

import { FormBuilder, FormGroup } from '@angular/forms';

import { HttpClient } from '@angular/common/http';
import { CurrencyService } from '../../services/currency.service';
import { ICurrency } from '../../models/currency';

@Component({
  selector: 'app-convert',
  templateUrl: './convert.component.html',
  styleUrls: ['./convert.component.css'],
})
export class ConvertComponent {
  @Input() data: ICurrency[] = [];
  isTrue: boolean = true;
  isDisabled: boolean = true;
  dropdownOpen = false;

  form: FormGroup;

  apiResponse: any; // Declare a variable to hold the API response

  fromValue: number = 0;
  toValue: number = 0;
  toSelectedCountry: string = '';
  fromSelectedCountry: string = '';

  toflagImagePath: string = '';
  fromflagImagePath: string = '';

  constructor(
    private currencyService: CurrencyService,
    private formBuilder: FormBuilder,
    private http: HttpClient
  ) {
    this.form = this.formBuilder.group({
      fromISO: '',
      toISO: '',
      amount: '',
      // Add more form controls as needed
    });
  }

  ngOnInit() {
    this.updateFromFlagImage();
    this.updateToFlagImage();
  }

  toggleDropdown() {
    this.dropdownOpen = !this.dropdownOpen;
  }

  submitForm() {
    const formData = this.form.value;

    const response = this.http.get(
      `https://concurrency-api.onrender.com/api/v1/currencies/convert/${formData.fromISO}/${formData.toISO}/${formData.amount}`
    );

    response.subscribe(
      (data: any) => {
        this.apiResponse = data.data.conversion_result; // Store the response in the variable
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
  }

  updateFromFlagImage() {
    if (this.data.length == 0) return;

    const image = this.data.find((item: any) => {
      return item.code === this.fromSelectedCountry;
    });

    if (image) {
      this.fromflagImagePath = image.icon_url;
    } else {
      this.fromflagImagePath = 'assets/flags/placeholder.png';
    }
  }
  updateToFlagImage() {
    const image = this.data.find((item: any) => {
      return item.code === this.toSelectedCountry;
    });

    if (image) {
      this.toflagImagePath = image.icon_url;
    } else {
      this.toflagImagePath = 'assets/flags/placeholder.png';
    }
  }
}
