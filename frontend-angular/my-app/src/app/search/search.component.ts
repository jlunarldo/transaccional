import { Component ,  ElementRef,ViewChild,viewChild, ViewContainerRef } from '@angular/core';
import { CategorieService } from '../Service/categorie.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search',
  standalone: false,
  
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {
  optionSelect: string=""; 
  optionProduct: string="";

  categories: string[]=[
    "opcion1",
    "opcion 2 ",
    "opcion 3 ",
    "opcion 4"
  ];//para probar estilos
  constructor(){} //public categorieService:CategorieService
  @ViewChild('filter',{static: true}) filter!: ElementRef<HTMLSelectElement>; //static:true la  referencia se resuelve durante el ciclo de vida del ngOnInit, antes no necesitaba esto porque tenía a la promesa controlando
  //hacerme acordar de sacarlo pq podría explotar
  
  
  //categories!: string[]  //para probar la entidad

  

  ngOnInit() {
    /*this.loadCategories().then(() => {
      this.createOptions();
  });*/
  this.createOptions();
  }

  /*loadCategories(): Promise<void> {
    return new Promise((resolve) => 
    this.categorieService.getAllCategorie().subscribe(response => {
      console.log("Response completa:", response);
      this.categories = response.list;
      resolve(); 
    }));

  }
  */
  
  createOptions() {
    for (let i = 0; i < 4; i++) {
      const option = document.createElement('option');
      console.log(this.categories[i]);
      option.value = this.categories[i];
      option.textContent = this.categories[i];
      console.log("asigno valores a los options");
      this.filter.nativeElement.appendChild(option);
      console.log("termine de asignar valroes");
    }
  }

  changeCategorie():void {
      this.optionProduct=this.optionSelect;
      console.log("este es el valor considerado"+this.optionProduct)
  }
}
