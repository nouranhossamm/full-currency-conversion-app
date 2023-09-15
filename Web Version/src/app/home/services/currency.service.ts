import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ICodesResponse, ICurrency, ICurrencyResponse } from '../models/currency';
import {  Observable, map, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CurrencyService {
  constructor(private httpClient: HttpClient) {}

  getCurriencies(): Observable<ICurrencyResponse> {
    return this.httpClient.get<ICurrencyResponse>(
      `https://concurrency-api.onrender.com/api/v1/currencies`
    );
  }

  postCurriencies(codes: string[]) {
    return this.httpClient.post<ICodesResponse>(
      `https://concurrency-api.onrender.com/api/v1/currencies/compare`,
      {
        base_code: 'USD',
        target_codes: codes,
      }
    );
  }

  getCurrenciesValues() {
    let result: ICurrency[] = [];
    return this.getCurriencies().pipe(
      switchMap((e: ICurrencyResponse) => {
        const codes = e.data.map((e) => e.code);
        result = e.data;
        return this.postCurriencies(codes);
      }),
      map((d) => {
        result = result.map((e) => ({
          ...e,
          value: d.data.conversion_rates[e.code],
        }));
        return result;
      })
    );
  }
}
