import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EventFormService } from '../search/form-active.service';
import { Product } from '../../Product';
import { ProductRequest } from './ProductRequest';


@Component({
  selector: 'app-add-form',
  standalone: false,
  
  templateUrl: './add-form.component.html',
  styleUrl: './add-form.component.css'
})


export class AddFormComponent {
  formProduct: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder, private eventForm:EventFormService){}
 
  product:ProductRequest={
    
      nameProduct: "Laptop Gamer",
      categorie: "Electronics",
      priceTotal: 1500,
      description:"sdasdsa"
  }
     

  ngOnInit() {
    this.formProduct = this.fb.group({
      nameProduct: ['', Validators.required],
      categorie: ['', Validators.required],
      priceTotal: ['', [Validators.required, Validators.min(0)]],
      description: ['', [Validators.required, Validators.maxLength(100)]]
    });
  }
   
  ngAfterViewInit(){
    
  }

  get getName() {
    return this.formProduct.get('nameProduct');
  }

  get getCategory() {
    return this.formProduct.get('categorie');
  }

  get getPrice() {
    return this.formProduct.get('priceTotal');
  }

  get getDescription() {
    return this.formProduct.get('description');
  }


  formSubmitted():void{
    
    this.product = {
      "nameProduct": this.getName?.value,
      "categorie": this.getCategory?.value,
      "priceTotal": this.getPrice?.value,
      "description": this.getDescription?.value
    };

    this.eventForm.triggerEvent(this.product);
  } 
}
