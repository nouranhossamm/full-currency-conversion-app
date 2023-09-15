import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { ConvertCompareComponent } from './components/convert-compare/convert-compare.component';
import { CurrencyListComponent } from './components/currency-list/currency-list.component';
import { AddFavoriteComponent } from './components/add-favorite/add-favorite.component';
import { ContainerComponent } from './components/container/container.component';
import { ConvertComponent } from './components/convert/convert.component';
import { CompareComponent } from './components/compare/compare.component';
import { DataComponent } from './components/data/data.component';
import { ConcurrencyComponent } from './components/concurrency/concurrency.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { MatOptionModule } from '@angular/material/core';

@NgModule({
  declarations: [
    ConvertCompareComponent,
    CurrencyListComponent,
    AddFavoriteComponent,
    ContainerComponent,
    ConvertComponent,
    CompareComponent,
    DataComponent,
    ConcurrencyComponent,
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
   // BrowserModule,
    //  HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatOptionModule,
  ],
})
export class HomeModule {}
