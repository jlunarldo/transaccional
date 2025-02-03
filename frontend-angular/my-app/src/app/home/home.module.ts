import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { CardModule } from '../CardComponent/card.module';
import { SearchModule } from '../search/search.module';
import { HeaderModule } from '../header/header.module';


@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    CardModule,
    SearchModule,
    HeaderModule
  ],
  exports:[
    HomeComponent
  ]
})
export class HomeModule { }
