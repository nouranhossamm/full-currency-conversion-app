import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { CurrencyService } from '../../services/currency.service';
import { ICurrency } from '../../models/currency';

@Component({
  selector: 'app-compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.css'],
})
export class CompareComponent {
  @Input() data: ICurrency[] = []; // You can define the type of your data here

  isTrue: boolean = true;
  isDisabled: boolean = true;

  form: FormGroup;

  apiResponse: any; // Declare a variable to hold the API response

  conversion_rates: any = [];

  fromValue: number = 0;
  toValue: number = 0;
  target1SelectedCountry: string = '';
  target2SelectedCountry: string = '';
  fromSelectedCountry: string = '';

  target1ImagePath: string = 'assets/flags/placeholder.png';
  target2ImagePath: string = 'assets/flags/placeholder.png';
  fromflagImagePath: string = 'assets/flags/placeholder.png';

  target1value: number = 0;
  target2value: number = 0;

  constructor(
    private currencyService: CurrencyService,
    private formBuilder: FormBuilder,
    private http: HttpClient
  ) {
    this.form = this.formBuilder.group({
      fromISO: '',
      amount: '',
      target1SelectedCountry: '',
      target2SelectedCountry: '',
      // Add more form controls as needed
    });
  }

  submitForm(event: Event) {
    event.preventDefault();
    event.stopPropagation();

    // Get the form data
    const formData = this.form.getRawValue();

    // Construct the request body
    const requestBody = {
      base_code: formData.fromISO,
      target_codes: [
        formData.target1SelectedCountry,
        formData.target2SelectedCountry,
      ],
    };
    // Make the API call
    const response = this.http.post(
      'https://concurrency-api.onrender.com/api/v1/currencies/compare',
      requestBody
    );

    // Subscribe to the response observable to get the API response
    response.subscribe((data: any) => {
      this.target1value =
        data.data.conversion_rates[formData.target1SelectedCountry] *
        formData.amount;
      this.target2value =
        data.data.conversion_rates[formData.target2SelectedCountry] *
        formData.amount;
    });
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

  updateTarget1Image() {
    const image = this.data.find((item: any) => {
      return item.code === this.target1SelectedCountry;
    });

    if (image) {
      this.target1ImagePath = image.icon_url;
    } else {
      this.target1ImagePath = 'assets/flags/placeholder.png';
    }
  }
  updateTarget2Image() {
    const image = this.data.find((item: any) => {
      return item.code === this.target2SelectedCountry;
    });
    if (image) {
      this.target2ImagePath = image.icon_url;
    } else {
      this.target2ImagePath = 'assets/flags/placeholder.png';
    }
  }
}
