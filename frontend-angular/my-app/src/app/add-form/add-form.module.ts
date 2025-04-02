import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AddFormComponent} from './add-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [AddFormComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    AddFormComponent
  ]
})

export class AddFormModule { }
