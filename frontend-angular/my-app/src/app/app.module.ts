import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './CardComponent/card.component';
import { CardModule } from './CardComponent/card.module';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { SearchComponent } from './search/search.component';
import { HomeModule } from './home/home.module';
import { SearchModule } from './search/search.module';
import { provideHttpClient } from '@angular/common/http';
import { AddFormComponent } from './add-form/add-form.component';


@NgModule({
  declarations: [
    AppComponent,
    

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
   
    
  ],     
  providers: [provideHttpClient()],
  bootstrap: [AppComponent]
})
export class AppModule { }
