import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchComponent } from './search.component';
import { FormsModule } from '@angular/forms';
import { AddFormModule } from '../add-form/add-form.module';



@NgModule({
  declarations: [SearchComponent],
  imports: [
    CommonModule, FormsModule, AddFormModule
  ],
  exports:[SearchComponent]
})
export class SearchModule { }
