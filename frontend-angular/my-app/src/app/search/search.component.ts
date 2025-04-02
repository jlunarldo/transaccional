import { Component ,  ComponentRef,  ElementRef,ViewChild,viewChild, ViewContainerRef } from '@angular/core';
import { CategorieService } from '../Service/categorie.service';
import { FormsModule } from '@angular/forms';
import { EventFilterService } from './eventFilter.service';
import { AddFormComponent } from '../add-form/add-form.component';
import { EventFormService } from './form-active.service';

import { ProductService } from '../home/product.service';
import { ProductRequest } from '../add-form/ProductRequest';

@Component({
  selector: 'app-search',
  standalone: false,
  
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {
  
  constructor(public eventFilterService:EventFilterService, public categorieService:CategorieService, public eventFormService: EventFormService, private productService: ProductService){} //

  isDisabled:Boolean=false;
  optionSelect: string=""; 
  optionProduct: string="";

  categories: string[]=[
    "opcion1",
    "opcion 2 ",
    "opcion 3 ",
    "opcion 4"
  ];//para probar estilos
  @ViewChild('filter',{static: true}) filter!: ElementRef<HTMLSelectElement>; //static:true la  referencia se resuelve durante el ciclo de vida del ngOnInit, antes no necesitaba esto porque tenía a la promesa controlando

  ngOnInit() {
    this.loadCategories().then(() => {
      this.createOptions();
    });
  //this.createOptions();
  }


  ngAfterViewInit(){
    this.eventFormService.event$.subscribe(( ProductRequest:ProductRequest)=>{
      this.productService.saveProduct(ProductRequest);
      this.isDisabled=false;
      this.container().remove();
    })
  }
  loadCategories(): Promise<void> {
    return new Promise((resolve) => 
    this.categorieService.getAllCategorie().subscribe(response => {
      this.categories = response.list;
      resolve(); 
    }));

  }
  
  
  createOptions() {
    for (let i = 0; i < this.categories.length; i++) {
      const option = document.createElement('option');
      option.value = this.categories[i];
      option.textContent = this.categories[i];
      //console.log("asigno valores a los options");
      this.filter.nativeElement.appendChild(option);
      //console.log("termine de asignar valroes");
    }
  }

  changeCategorie():void {
      this.optionProduct=this.optionSelect;
      //console.log("este es el valor considerado"+this.optionProduct)
      this.eventFilterService.triggerEvent(this.optionProduct);


  }
  container= viewChild.required('container_form',{read:  ViewContainerRef});
    
    componentRef!: ComponentRef<AddFormComponent>;

  createComponentForm():void{
        this.isDisabled=true;
       this.componentRef=this.container().createComponent(AddFormComponent);
       
  }
}
