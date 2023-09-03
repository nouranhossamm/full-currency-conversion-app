import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContainerComponent } from './components/container/container.component';
import { DataComponent } from './components/data/data.component';
import { ConcurrencyComponent } from './components/concurrency/concurrency.component';

const routes: Routes = [
//  { path: '', component: ConcurrencyComponent },

  { path: 'data', component: DataComponent },
  {
    path: '',
    component: ContainerComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HomeRoutingModule {}
